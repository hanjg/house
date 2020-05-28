package com.babyjuan.house.service.impl;

import com.babyjuan.house.common.enums.RecordStatus;
import com.babyjuan.house.repository.entity.Community;
import com.babyjuan.house.repository.entity.SecondHandHouse;
import com.babyjuan.house.repository.entity.SecondHandHouseExample;
import com.babyjuan.house.repository.entity.ShHouseDistrictSummary;
import com.babyjuan.house.repository.entity.ShHouseDistrictSummaryExample;
import com.babyjuan.house.repository.mapper.CommunityMapper;
import com.babyjuan.house.repository.mapper.SecondHandHouseMapper;
import com.babyjuan.house.repository.mapper.ShHouseDistrictSummaryMapper;
import com.babyjuan.house.service.SecondHandHouseService;
import com.babyjuan.house.service.dto.BaseResponse;
import com.babyjuan.house.service.dto.DistrictSecondHandHouseSummaryDTO;
import com.babyjuan.house.service.dto.PageDTO;
import com.babyjuan.house.service.dto.SecondHandHouseDTO;
import com.babyjuan.house.service.dto.SecondHandHouseSummaryDTO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author anxi
 * @version 2020/5/25 19:37
 */
@Service
public class SecondHandHouseServiceImpl implements SecondHandHouseService {

    @Autowired
    private SecondHandHouseMapper secondHandHouseMapper;

    @Autowired
    private CommunityMapper communityMapper;

    @Autowired
    private ShHouseDistrictSummaryMapper shHouseDistrictSummaryMapper;

    @Override
    public BaseResponse<PageDTO<SecondHandHouseDTO>> getSecondHouseList(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);

        SecondHandHouseExample example = new SecondHandHouseExample();
        example.createCriteria().andStatusNotEqualTo(RecordStatus.EXPIRED.getStatus());
        example.setOrderByClause("to_time desc");
        List<SecondHandHouse> houseList = secondHandHouseMapper.selectByExample(example);

        List<SecondHandHouseDTO> houseDtoList = new ArrayList<>();
        for (SecondHandHouse house : houseList) {
            Community community = communityMapper.selectByPrimaryKey(house.getCommunityInfoId());
            String communityName = community.getCommunityName();
            SecondHandHouseDTO houseDto = buildSecondHandHouseDTO(house, communityName);
            houseDtoList.add(houseDto);
        }

        PageInfo<SecondHandHouse> pageInfo = new PageInfo<>(houseList);
        PageDTO<SecondHandHouseDTO> pageDTO = new PageDTO<>();
        pageDTO.setTotal(pageInfo.getTotal());
        pageDTO.setRows(houseDtoList);
        return BaseResponse.newSuccessResponse(pageDTO);
    }

    @Override
    public BaseResponse<PageDTO<SecondHandHouseSummaryDTO>> getSecondHouseSummaryList(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);

        ShHouseDistrictSummaryExample example = new ShHouseDistrictSummaryExample();
        example.setOrderByClause("info_time desc");
        List<ShHouseDistrictSummary> summaryList = shHouseDistrictSummaryMapper.selectByExample(example);
        List<SecondHandHouseSummaryDTO> result = summaryList.stream()
                .map(SecondHandHouseServiceImpl::buildSummaryDTO)
                .collect(Collectors.toList());

        PageInfo<ShHouseDistrictSummary> pageInfo = new PageInfo<>(summaryList);
        PageDTO<SecondHandHouseSummaryDTO> pageDTO = new PageDTO<>();
        pageDTO.setTotal(pageInfo.getTotal());
        pageDTO.setRows(result);
        return BaseResponse.newSuccessResponse(pageDTO);
    }

    @Override
    public BaseResponse<DistrictSecondHandHouseSummaryDTO> getSecondHouseSummaryRange(Date from, Date to) {
        ShHouseDistrictSummaryExample example = new ShHouseDistrictSummaryExample();
        example.createCriteria().andInfoTimeBetween(from, to);
        List<ShHouseDistrictSummary> summaryList = shHouseDistrictSummaryMapper.selectByExample(example);
        Map<Date, List<ShHouseDistrictSummary>> dateMap = summaryList.stream()
                .collect(Collectors.groupingBy(
                        ShHouseDistrictSummary::getInfoTime,
                        Collectors.mapping(v -> v, Collectors.toList())
                ));
        DistrictSecondHandHouseSummaryDTO result = new DistrictSecondHandHouseSummaryDTO();
        List<Date> dateList = dateMap.keySet().stream().sorted().collect(Collectors.toList());
        Set<String> districtSet = summaryList.stream()
                .map(ShHouseDistrictSummary::getDistrict)
                .collect(Collectors.toSet());
        Map<String, List<SecondHandHouseSummaryDTO>> sumMap = assembleSumMap(dateMap, dateList, districtSet);
        result.setTimeList(dateList);
        result.setDistricts(districtSet);
        result.setSumMap(sumMap);
        return BaseResponse.newSuccessResponse(result);
    }

    private Map<String, List<SecondHandHouseSummaryDTO>> assembleSumMap(Map<Date,
            List<ShHouseDistrictSummary>> dateMap, List<Date> dateList, Set<String> districtSet) {
        Map<String, List<SecondHandHouseSummaryDTO>> sumMap = new HashMap<>();
        for (String district : districtSet) {
            sumMap.put(district, new ArrayList<>());
        }
        for (Date date : dateList) {
            List<ShHouseDistrictSummary> daySum = dateMap.get(date);
            Map<String, SecondHandHouseSummaryDTO> dayMap = daySum.stream()
                    .collect(Collectors.toMap(
                            ShHouseDistrictSummary::getDistrict,
                            SecondHandHouseServiceImpl::buildSummaryDTO,
                            (k1, k2) -> k1
                    ));
            for (String district : sumMap.keySet()) {
                SecondHandHouseSummaryDTO dto = dayMap.get(district);
                if (dto == null) {
                    dto = new SecondHandHouseSummaryDTO();
                    dto.setInfoTime(date);
                    dto.setDistrict(district);
                }
                sumMap.get(district).add(dto);
            }
        }
        for (String district : sumMap.keySet()) {
            List<SecondHandHouseSummaryDTO> districtSum = sumMap.get(district);
            fillEmptyAvgUnitPrice(districtSum);
            fillEmptyAvgTotalPrice(districtSum);
            fillEmptyAvgTotalHouse(districtSum);
        }
        return sumMap;
    }

    private void fillEmptyAvgUnitPrice(List<SecondHandHouseSummaryDTO> districtSum) {
        double avgUnitPrice = districtSum.stream()
                .map(SecondHandHouseSummaryDTO::getAvgUnitPrice)
                .filter(Objects::nonNull)
                .mapToDouble(BigDecimal::doubleValue)
                .average()
                .getAsDouble();
        BigDecimal avgUnitBigDecimal = new BigDecimal(avgUnitPrice).setScale(2, BigDecimal.ROUND_HALF_UP);
        for (SecondHandHouseSummaryDTO summaryDTO : districtSum) {
            if (summaryDTO.getAvgUnitPrice() == null) {
                summaryDTO.setAvgUnitPrice(avgUnitBigDecimal);
            }
        }
    }

    private void fillEmptyAvgTotalPrice(List<SecondHandHouseSummaryDTO> districtSum) {
        double avgTotalPrice = districtSum.stream()
                .map(SecondHandHouseSummaryDTO::getAvgTotalPrice)
                .filter(Objects::nonNull)
                .mapToDouble(BigDecimal::doubleValue)
                .average()
                .getAsDouble();
        BigDecimal avgTotalBigDecimal = new BigDecimal(avgTotalPrice).setScale(2, BigDecimal.ROUND_HALF_UP);
        for (SecondHandHouseSummaryDTO summaryDTO : districtSum) {
            if (summaryDTO.getAvgTotalPrice() == null) {
                summaryDTO.setAvgTotalPrice(avgTotalBigDecimal);
            }
        }
    }

    private void fillEmptyAvgTotalHouse(List<SecondHandHouseSummaryDTO> districtSum) {
        double totalHouse = districtSum.stream()
                .map(SecondHandHouseSummaryDTO::getTotalHouseCount)
                .filter(Objects::nonNull)
                .mapToInt(Integer::valueOf)
                .average()
                .getAsDouble();
        BigDecimal avgTotalBigDecimal = new BigDecimal(totalHouse).setScale(0, BigDecimal.ROUND_HALF_UP);
        for (SecondHandHouseSummaryDTO summaryDTO : districtSum) {
            if (summaryDTO.getTotalHouseCount() == null) {
                summaryDTO.setTotalHouseCount(avgTotalBigDecimal.intValue());
            }
        }
    }

    private static SecondHandHouseSummaryDTO buildSummaryDTO(ShHouseDistrictSummary summary) {
        SecondHandHouseSummaryDTO dto = new SecondHandHouseSummaryDTO();
        dto.setDistrict(summary.getDistrict());
        dto.setInfoTime(summary.getInfoTime());
        dto.setAvgTotalPrice(summary.getAvgTotalPrice());
        dto.setAvgUnitPrice(summary.getAvgUnitPrice());
        dto.setTotalHouseCount(Integer.valueOf(summary.getTotalHouseCount()));
        return dto;
    }

    private SecondHandHouseDTO buildSecondHandHouseDTO(SecondHandHouse house, String communityName) {
        SecondHandHouseDTO houseDto = new SecondHandHouseDTO();
        houseDto.setArea(house.getArea());
        houseDto.setUnitPrice(house.getUnitPrice());
        houseDto.setBedroomNum(house.getBedroomNum());
        houseDto.setHallNum(house.getHallNum());
        houseDto.setCommunity(communityName);
        houseDto.setFromTime(house.getFromTime());
        houseDto.setPriceTotal(house.getPriceTotal());
        houseDto.setTitle(house.getTitle());
        return houseDto;
    }
}

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
import com.babyjuan.house.service.dto.PageDTO;
import com.babyjuan.house.service.dto.SecondHandHouseDTO;
import com.babyjuan.house.service.dto.SecondHandHouseSummaryDTO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.ArrayList;
import java.util.List;
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

    private static SecondHandHouseSummaryDTO buildSummaryDTO(ShHouseDistrictSummary summary) {
        SecondHandHouseSummaryDTO dto = new SecondHandHouseSummaryDTO();
        dto.setDistrict(summary.getDistrict());
        dto.setInfoTime(summary.getInfoTime());
        dto.setAvgTotalPrice(summary.getAvgTotalPrice());
        dto.setAvgUnitPrice(summary.getAvgUnitPrice());
        dto.setTotalHouseCount(summary.getTotalHouseCount());
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

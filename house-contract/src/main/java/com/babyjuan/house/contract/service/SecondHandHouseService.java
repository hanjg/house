package com.babyjuan.house.contract.service;

import com.babyjuan.house.contract.dto.BaseResponse;
import com.babyjuan.house.contract.dto.DistrictSecondHandHouseSummaryDTO;
import com.babyjuan.house.contract.dto.PageDTO;
import com.babyjuan.house.contract.dto.SecondHandHouseDTO;
import com.babyjuan.house.contract.dto.SecondHandHouseSummaryDTO;
import java.util.Date;
import java.util.List;

/**
 * @author anxi
 * @version 2020/5/25 19:34
 */
public interface SecondHandHouseService {

    BaseResponse<List<String>> getAllDistricts();

    BaseResponse<PageDTO<SecondHandHouseDTO>> getSecondHouseList(int page, int pageSize);

    BaseResponse<PageDTO<SecondHandHouseDTO>> getSecondHouseListFromES(int offset, int limit);

    BaseResponse<PageDTO<SecondHandHouseDTO>> getSecondHouseListFromES(int offset, int limit, String title);

    BaseResponse<PageDTO<SecondHandHouseSummaryDTO>> getSecondHouseSummaryList(int page, int pageSize);

    BaseResponse<DistrictSecondHandHouseSummaryDTO> getSecondHouseSummaryRange(Date from, Date to);

    BaseResponse<DistrictSecondHandHouseSummaryDTO> getSecondHouseSummarySpecific(Date from, Date to,
            List<String> districts);
}

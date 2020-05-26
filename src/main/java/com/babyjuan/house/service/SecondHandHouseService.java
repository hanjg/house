package com.babyjuan.house.service;

import com.babyjuan.house.service.dto.BaseResponse;
import com.babyjuan.house.service.dto.PageDTO;
import com.babyjuan.house.service.dto.SecondHandHouseDTO;
import com.babyjuan.house.service.dto.SecondHandHouseSummaryDTO;

/**
 * @author anxi
 * @version 2020/5/25 19:34
 */
public interface SecondHandHouseService {

    BaseResponse<PageDTO<SecondHandHouseDTO>> getSecondHouseList(int page, int pageSize);

    BaseResponse<PageDTO<SecondHandHouseSummaryDTO>> getSecondHouseSummaryList(int page, int pageSize);
}

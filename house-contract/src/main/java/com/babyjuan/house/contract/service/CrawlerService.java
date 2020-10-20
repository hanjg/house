package com.babyjuan.house.contract.service;

import com.babyjuan.house.contract.dto.BaseResponse;
import com.babyjuan.house.contract.dto.SpiderStateDTO;

/**
 * @Author: hjg
 * @Date: Create in 2018/6/4 16:04
 * @Description:
 */
public interface CrawlerService {

    BaseResponse<SpiderStateDTO> secondHandHouseCrawlerStatus();

}

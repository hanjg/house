package com.babyjuan.house.rest.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.babyjuan.house.common.utils.ExceptionUtils;
import com.babyjuan.house.contract.dto.BaseResponse;
import com.babyjuan.house.contract.service.CrawlerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: hjg
 * @Date: Create in 2018/6/6 22:32
 * @Description:
 */
@Controller
@RequestMapping("/crawler")
public class CrawlerController {

    @Reference(check = false)
    private CrawlerService crawlerService;

    @RequestMapping("/secondHandHouse/status")
    @ResponseBody
    public BaseResponse shStatus() {
        BaseResponse result = null;
        try {
            result = crawlerService.secondHandHouseCrawlerStatus();
        } catch (Exception e) {
            result = BaseResponse.newFailureResponse(ExceptionUtils.getStackTrace(e));
        }
        return result;
    }
}

package com.babyjuan.house.controller;

import com.babyjuan.house.common.utils.ExceptionUtils;
import com.babyjuan.house.service.CrawlerService;
import com.babyjuan.house.service.dto.BaseResponse;
import com.babyjuan.house.task.spider.SpiderState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Autowired
    @Qualifier("crawlerServiceImpl")
    private CrawlerService crawlerService;

    @Autowired
    @Qualifier("secondHandCrawlerServiceImpl")
    private CrawlerService secondHandCrawlerService;

    @RequestMapping("/rentingHouse/status")
    @ResponseBody
    public BaseResponse status() {
        BaseResponse result = null;
        try {
            SpiderState spiderState = crawlerService.status();
            result = BaseResponse.newSuccessResponse(spiderState);
        } catch (Exception e) {
            result = BaseResponse.newFailureResponse(ExceptionUtils.getStackTrace(e));
        }
        return result;
    }

    @RequestMapping("/secondHandHouse/status")
    @ResponseBody
    public BaseResponse shStatus() {
        BaseResponse result = null;
        try {
            SpiderState spiderState = secondHandCrawlerService.status();
            result = BaseResponse.newSuccessResponse(spiderState);
        } catch (Exception e) {
            result = BaseResponse.newFailureResponse(ExceptionUtils.getStackTrace(e));
        }
        return result;
    }
}

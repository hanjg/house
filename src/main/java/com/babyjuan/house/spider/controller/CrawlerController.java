package com.babyjuan.house.spider.controller;

import com.babyjuan.house.common.utils.ExceptionUtil;
import com.babyjuan.house.common.HouseResult;
import com.babyjuan.house.spider.service.CrawlerService;
import com.babyjuan.house.common.SpiderState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("/start/{repeatTimes}")
    @ResponseBody
    public HouseResult start(@PathVariable(required = false) Integer repeatTimes) {
        if (repeatTimes == null) {
            repeatTimes = 1000;
        }
        HouseResult result = null;
        try {
            result = crawlerService.start(repeatTimes);
        } catch (Exception e) {
            result = HouseResult.build(500, ExceptionUtil.getStackTrace(e));
        }
        return result;
    }

    @RequestMapping("/status")
    @ResponseBody
    public HouseResult status() {
        HouseResult result = null;
        try {
            SpiderState spiderState = crawlerService.status();
            result = HouseResult.ok(spiderState);
        } catch (Exception e) {
            result = HouseResult.build(500, ExceptionUtil.getStackTrace(e));
        }
        return result;
    }

    @RequestMapping("sh/start/{repeatTimes}")
    @ResponseBody
    public HouseResult shStart(@PathVariable(required = false) Integer repeatTimes) {
        if (repeatTimes == null) {
            repeatTimes = 1000;
        }
        HouseResult result = null;
        try {
            result = secondHandCrawlerService.start(repeatTimes);
        } catch (Exception e) {
            result = HouseResult.build(500, ExceptionUtil.getStackTrace(e));
        }
        return result;
    }

    @RequestMapping("sh/status")
    @ResponseBody
    public HouseResult shStatus() {
        HouseResult result = null;
        try {
            SpiderState spiderState = secondHandCrawlerService.status();
            result = HouseResult.ok(spiderState);
        } catch (Exception e) {
            result = HouseResult.build(500, ExceptionUtil.getStackTrace(e));
        }
        return result;
    }

}

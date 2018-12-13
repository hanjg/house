package com.babyjuan.house.controller;

import com.babyjuan.house.common.utils.ExceptionUtil;
import com.babyjuan.house.common.HouseResult;
import com.babyjuan.house.service.crawler.CrawlerService;
import com.babyjuan.house.service.crawler.model.SpiderState;
import org.springframework.beans.factory.annotation.Autowired;
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
    private CrawlerService crawlerService;

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

}

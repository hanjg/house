package com.babyjuan.house.controller;

import com.babyjuan.house.common.ExceptionUtil;
import com.babyjuan.house.common.HouseResult;
import com.babyjuan.house.common.enums.HouseSource;
import com.babyjuan.house.service.crawler.CrawlerService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private CrawlerService crawlerService;

    @RequestMapping("/start")
    @ResponseBody
    public HouseResult start() {
        HouseResult result = null;
        try {
            crawlerService.run();
            result = HouseResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            result = HouseResult.build(500,ExceptionUtil.getStackTrace(e));
        }
        return result;
    }

    @RequestMapping("/stop")
    @ResponseBody
    public HouseResult stop() {
        HouseResult result = null;
        try {
            crawlerService.stop();
            result = HouseResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            result = HouseResult.build(500,ExceptionUtil.getStackTrace(e));
        }
        return result;
    }

}

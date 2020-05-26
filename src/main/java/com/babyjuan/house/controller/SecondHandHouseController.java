package com.babyjuan.house.controller;

import com.babyjuan.house.service.SecondHandHouseService;
import com.babyjuan.house.service.dto.BaseResponse;
import com.babyjuan.house.service.dto.PageDTO;
import com.babyjuan.house.service.dto.SecondHandHouseDTO;
import com.babyjuan.house.service.dto.SecondHandHouseSummaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: hjg
 * @Date: Create in 2018/7/14 21:18
 * @Description:
 */
@Controller
@RequestMapping("/secondHandHouse")
public class SecondHandHouseController {

    @Autowired
    private SecondHandHouseService secondHandHouseService;

    @RequestMapping("/list")
    @ResponseBody
    public BaseResponse<PageDTO<SecondHandHouseDTO>> getHouseList(@RequestParam Integer page,
            @RequestParam Integer size) {
        return secondHandHouseService.getSecondHouseList(page, size);
    }

    @RequestMapping("/summary/list")
    @ResponseBody
    BaseResponse<PageDTO<SecondHandHouseSummaryDTO>> getSecondHouseSummaryList(@RequestParam Integer page,
            @RequestParam Integer size) {
        return secondHandHouseService.getSecondHouseSummaryList(page, size);
    }
}

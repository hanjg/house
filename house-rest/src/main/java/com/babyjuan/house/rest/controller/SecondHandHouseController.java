package com.babyjuan.house.rest.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.babyjuan.house.contract.dto.BaseResponse;
import com.babyjuan.house.contract.dto.DistrictSecondHandHouseSummaryDTO;
import com.babyjuan.house.contract.dto.PageDTO;
import com.babyjuan.house.contract.dto.SecondHandHouseDTO;
import com.babyjuan.house.contract.dto.SecondHandHouseSummaryDTO;
import com.babyjuan.house.contract.service.SecondHandHouseService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.time.DateUtils;
import org.assertj.core.util.Lists;
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

    @Reference(check = false)
    private SecondHandHouseService secondHandHouseService;

    @RequestMapping("/districts")
    @ResponseBody
    public BaseResponse<List<String>> getAllDistricts() {
        return secondHandHouseService.getAllDistricts();
    }

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

    @RequestMapping("/summary/range")
    @ResponseBody
    BaseResponse<DistrictSecondHandHouseSummaryDTO> getSecondHouseSummaryRange() {
        Date now = new Date();
        Date from = DateUtils.addMonths(now, -1);
        Date to = DateUtils.addDays(now, -3);
        return secondHandHouseService.getSecondHouseSummaryRange(from, to);
    }

    @RequestMapping("/summary/specific")
    @ResponseBody
    BaseResponse<DistrictSecondHandHouseSummaryDTO> getSecondHouseSummarySpecific(
            @RequestParam Long from, @RequestParam Long to, @RequestParam String district) {
        List<String> districts = new ArrayList<>();
        districts.add(district);
        return secondHandHouseService.getSecondHouseSummarySpecific(new Date(from), new Date(to), districts);
    }
}

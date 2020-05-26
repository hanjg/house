package com.babyjuan.house.controller;

import com.babyjuan.house.service.dto.PageDTO;
import com.babyjuan.house.service.RentingHouseService;
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
@RequestMapping("/rentingHouse")
public class RentingHouseController {

    @Autowired
    private RentingHouseService rentingHouseService;

    @RequestMapping("/list")
    @ResponseBody
    public PageDTO getHouseList(@RequestParam Integer page, @RequestParam Integer size) {
        return rentingHouseService.getRentingHouseList(page, size);
    }

    @RequestMapping("/favourate/list")
    @ResponseBody
    public PageDTO getFavourateHouseList(Integer page, Integer size) {
        return rentingHouseService.getFavourateHouseList(page, size);
    }
}

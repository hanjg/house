package com.babyjuan.house.list.controller;

import com.babyjuan.house.common.EasyUIDataGridResult;
import com.babyjuan.house.list.service.RentingHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public EasyUIDataGridResult getHouseList() {
        return rentingHouseService.getRentingHouseList(1, 10);
    }

    @RequestMapping("/favourate/list")
    @ResponseBody
    public EasyUIDataGridResult getFavourateHouseList(Integer page, Integer rows) {
        return rentingHouseService.getFavourateHouseList(page, rows);
    }
}

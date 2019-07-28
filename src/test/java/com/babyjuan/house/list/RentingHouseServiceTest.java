package com.babyjuan.house.list;

import com.babyjuan.house.HouseApplicationTests;
import com.babyjuan.house.common.EasyUIDataGridResult;
import com.babyjuan.house.list.service.RentingHouseService;
import com.babyjuan.house.repository.entity.RentingHouse;
import com.babyjuan.house.list.service.dto.RentingHouseDto;
import java.util.Date;
import java.util.List;
import org.joda.time.DateTime;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: hjg
 * @Date: Create in 2018/6/21 17:48
 * @Description:
 */
public class RentingHouseServiceTest extends HouseApplicationTests {

    @Autowired
    private RentingHouseService rentingHouseService;

    private Date lastPushDate = DateTime.parse("1000-01-01").toDate();

    @Test
    public void getRelativeHouseList() throws Exception {
        String com1 = "蓝筹";
        String com2 = "盘金";
        queryHouse(com1, com2);
        lastPushDate = DateTime.parse("2100-01-01").toDate();
        queryHouse(com1, com2);
    }

    @Test
    public void getRentingHosueList() {
        EasyUIDataGridResult result = rentingHouseService.getRentingHouseList(1, 10);
        List<RentingHouseDto> dtos = (List<RentingHouseDto>) result.getRows();
        for (RentingHouseDto house : dtos) {
            System.out.println(house.toString());
        }
    }

    private void queryHouse(String com1, String com2) {
        List<RentingHouse> list1 = rentingHouseService.getLatestFavourateHouseList(com1, lastPushDate);
        List<RentingHouse> list2 = rentingHouseService.getLatestFavourateHouseList(com2, lastPushDate);
        System.out.println(com1 + " : ");
        printHouse(list1);
        System.out.println(com2 + " :");
        printHouse(list2);
    }

    private void printHouse(List<RentingHouse> houseList) {
        for (RentingHouse house : houseList) {
            System.out.println(house);
        }
    }

}
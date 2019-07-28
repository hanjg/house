package com.babyjuan.house.spider;

import com.babyjuan.house.repository.entity.RentingHouse;
import org.junit.Test;

/**
 * @Author: hjg
 * @Date: Create in 2018/6/19 20:22
 * @Description:
 */
public class TestlongNull {

    @Test
    public void test() {
        System.out.println(returnlong());
    }

    private long returnlong() {
        RentingHouse house = new RentingHouse();
        return house.getInfoId();
    }
}

package com.babyjuan.house.spider;

import org.junit.Test;

/**
 * @Author: hjg
 * @Date: Create in 2018/6/21 18:27
 * @Description:
 */
public class TestSplit {

    @Test
    public void test() {
        String s = "sdf,d";
        String[] tokens = s.split(",");
        System.out.println(tokens[0]);
        System.out.println(tokens.length);

    }
}

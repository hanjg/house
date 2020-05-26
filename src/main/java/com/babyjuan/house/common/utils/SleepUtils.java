package com.babyjuan.house.common.utils;

/**
 * @author anxi
 * @version 2020/5/27 0:29
 */
public class SleepUtils {

    public static void sleep(long millseconds) {
        try {
            Thread.sleep(millseconds);
        } catch (InterruptedException e) {
            //ignore
        }
    }
}

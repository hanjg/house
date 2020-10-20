package com.babyjuan.house.task.analyze;

import com.babyjuan.house.task.HouseTaskApplicationTests;
import java.util.Calendar;
import java.util.Date;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: hjg
 * @Date: Create in 2018/6/21 17:48
 * @Description:
 */
public class AnalyzeTest extends HouseTaskApplicationTests {

    @Autowired
    private SecondHandHouseAnalyzeJob analyzeJob;

    @Test
    public void generateAvaragePrice() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, Calendar.AUGUST, 1, 0, 0, 0);
        Date from = calendar.getTime();
        calendar.set(2020, Calendar.JANUARY, 31, 0, 0, 0);
        Date to = calendar.getTime();
        analyzeJob.generateAvaragePrice(from, to);
    }

    @Test
    public void start() {
        analyzeJob.start();
    }
}

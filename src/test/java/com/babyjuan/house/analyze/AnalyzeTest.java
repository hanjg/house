package com.babyjuan.house.analyze;

import com.babyjuan.house.HouseApplicationTests;
import com.babyjuan.house.task.analyze.AnalyzeJob;
import java.util.Calendar;
import java.util.Date;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: hjg
 * @Date: Create in 2018/6/21 17:48
 * @Description:
 */
public class AnalyzeTest extends HouseApplicationTests {

    @Autowired
    private AnalyzeJob analyzeJob;

    @Test
    public void test() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, Calendar.AUGUST, 1, 0, 0, 0);
        Date from = calendar.getTime();
        calendar.set(2020, Calendar.JANUARY, 31, 0, 0, 0);
        Date to = calendar.getTime();
        analyzeJob.generateAvaragePrice(from, to);
    }
}

package com.babyjuan.house.task.analyze;

import com.babyjuan.house.repository.mapper.SecondHandHouseMapper;
import com.babyjuan.house.repository.mapper.ShHouseDistrictSummaryMapper;
import com.babyjuan.house.repository.entity.ShHouseDistrictSummary;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author anxi
 * @version 2020/2/3 18:25
 */
@Component
public class AnalyzeJob {

    @Autowired
    private SecondHandHouseMapper secondHandHouseMapper;

    @Autowired
    private ShHouseDistrictSummaryMapper shHouseDistrictSummaryMapper;

    public void generateAvaragePrice(Date from, Date to) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(from);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        while (calendar.getTime().compareTo(to) <= 0) {
            generateAvaragePrice(calendar.getTime());
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        calendar.clear();
    }


    private void generateAvaragePrice(Date date) {
        System.out.println(date.toString());
        List<ShHouseDistrictSummary> List = secondHandHouseMapper.queryDistrictSummary(date);
        for(ShHouseDistrictSummary shHouseDistrictSummary:List){
            shHouseDistrictSummary.setInfoTime(date);
            shHouseDistrictSummaryMapper.insert(shHouseDistrictSummary);
        }
    }
}

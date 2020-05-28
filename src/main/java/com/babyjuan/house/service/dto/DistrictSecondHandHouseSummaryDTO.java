package com.babyjuan.house.service.dto;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author anxi
 * @version 2020/5/27 19:31
 */
public class DistrictSecondHandHouseSummaryDTO {

    private List<Date> timeList;

    private Set<String> districts;
    /**
     * 行政区：汇总
     */
    private Map<String, List<SecondHandHouseSummaryDTO>> sumMap;

    public List<Date> getTimeList() {
        return timeList;
    }

    public void setTimeList(List<Date> timeList) {
        this.timeList = timeList;
    }

    public Set<String> getDistricts() {
        return districts;
    }

    public void setDistricts(Set<String> districts) {
        this.districts = districts;
    }

    public Map<String, List<SecondHandHouseSummaryDTO>> getSumMap() {
        return sumMap;
    }

    public void setSumMap(
            Map<String, List<SecondHandHouseSummaryDTO>> sumMap) {
        this.sumMap = sumMap;
    }
}

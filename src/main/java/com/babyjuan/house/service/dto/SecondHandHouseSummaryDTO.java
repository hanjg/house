package com.babyjuan.house.service.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author anxi
 * @version 2020/5/25 19:35
 */
public class SecondHandHouseSummaryDTO
{
    private String district;

    private Date infoTime;

    private BigDecimal avgTotalPrice;

    private BigDecimal avgUnitPrice;

    private String totalHouseCount;

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Date getInfoTime() {
        return infoTime;
    }

    public void setInfoTime(Date infoTime) {
        this.infoTime = infoTime;
    }

    public BigDecimal getAvgTotalPrice() {
        return avgTotalPrice;
    }

    public void setAvgTotalPrice(BigDecimal avgTotalPrice) {
        this.avgTotalPrice = avgTotalPrice;
    }

    public BigDecimal getAvgUnitPrice() {
        return avgUnitPrice;
    }

    public void setAvgUnitPrice(BigDecimal avgUnitPrice) {
        this.avgUnitPrice = avgUnitPrice;
    }

    public String getTotalHouseCount() {
        return totalHouseCount;
    }

    public void setTotalHouseCount(String totalHouseCount) {
        this.totalHouseCount = totalHouseCount;
    }
}

package com.babyjuan.house.contract.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author anxi
 * @version 2020/5/25 19:35
 */
public class SecondHandHouseSummaryDTO implements Serializable {

    private static final long serialVersionUID = -5013142665154091391L;

    private String district;

    private Date infoTime;

    private BigDecimal avgTotalPrice;

    private BigDecimal avgUnitPrice;

    private Integer totalHouseCount;

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

    public Integer getTotalHouseCount() {
        return totalHouseCount;
    }

    public void setTotalHouseCount(Integer totalHouseCount) {
        this.totalHouseCount = totalHouseCount;
    }
}

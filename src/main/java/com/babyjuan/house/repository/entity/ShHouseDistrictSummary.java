package com.babyjuan.house.repository.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ShHouseDistrictSummary {
    private Long infoId;

    private String district;

    private BigDecimal avgTotalPrice;

    private BigDecimal avgUnitPrice;

    private String totalHouseCount;

    private Date infoTime;

    public Long getInfoId() {
        return infoId;
    }

    public void setInfoId(Long infoId) {
        this.infoId = infoId;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
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
        this.totalHouseCount = totalHouseCount == null ? null : totalHouseCount.trim();
    }

    public Date getInfoTime() {
        return infoTime;
    }

    public void setInfoTime(Date infoTime) {
        this.infoTime = infoTime;
    }
}
package com.babyjuan.house.repository.mysql.entity;

import java.util.Date;

public class ShHouseDeal {
    private Long infoId;

    private Integer sourceId;

    private String houseCode;

    private Long originPrice;

    private Long finalPrice;

    private Long finalUnitPrice;

    private Integer dealTime;

    private Integer adjustCount;

    private Integer lookCount;

    private Integer attentionCount;

    private String md5;

    private Date gmtModified;

    public Long getInfoId() {
        return infoId;
    }

    public void setInfoId(Long infoId) {
        this.infoId = infoId;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public String getHouseCode() {
        return houseCode;
    }

    public void setHouseCode(String houseCode) {
        this.houseCode = houseCode == null ? null : houseCode.trim();
    }

    public Long getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(Long originPrice) {
        this.originPrice = originPrice;
    }

    public Long getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Long finalPrice) {
        this.finalPrice = finalPrice;
    }

    public Long getFinalUnitPrice() {
        return finalUnitPrice;
    }

    public void setFinalUnitPrice(Long finalUnitPrice) {
        this.finalUnitPrice = finalUnitPrice;
    }

    public Integer getDealTime() {
        return dealTime;
    }

    public void setDealTime(Integer dealTime) {
        this.dealTime = dealTime;
    }

    public Integer getAdjustCount() {
        return adjustCount;
    }

    public void setAdjustCount(Integer adjustCount) {
        this.adjustCount = adjustCount;
    }

    public Integer getLookCount() {
        return lookCount;
    }

    public void setLookCount(Integer lookCount) {
        this.lookCount = lookCount;
    }

    public Integer getAttentionCount() {
        return attentionCount;
    }

    public void setAttentionCount(Integer attentionCount) {
        this.attentionCount = attentionCount;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5 == null ? null : md5.trim();
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}

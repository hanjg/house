package com.babyjuan.house.repository.mysql.entity;

import java.math.BigDecimal;
import java.util.Date;

public class SecondHandHouse {
    private Long infoId;

    private Integer sourceId;

    private String houseCode;

    private String title;

    private Byte bedroomNum;

    private Byte hallNum;

    private String orientation;

    private Integer priceTotal;

    private Integer unitPrice;

    private BigDecimal area;

    private Long communityInfoId;

    private String md5;

    private Date fromTime;

    private Date toTime;

    private Byte status;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Byte getBedroomNum() {
        return bedroomNum;
    }

    public void setBedroomNum(Byte bedroomNum) {
        this.bedroomNum = bedroomNum;
    }

    public Byte getHallNum() {
        return hallNum;
    }

    public void setHallNum(Byte hallNum) {
        this.hallNum = hallNum;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation == null ? null : orientation.trim();
    }

    public Integer getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(Integer priceTotal) {
        this.priceTotal = priceTotal;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public Long getCommunityInfoId() {
        return communityInfoId;
    }

    public void setCommunityInfoId(Long communityInfoId) {
        this.communityInfoId = communityInfoId;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5 == null ? null : md5.trim();
    }

    public Date getFromTime() {
        return fromTime;
    }

    public void setFromTime(Date fromTime) {
        this.fromTime = fromTime;
    }

    public Date getToTime() {
        return toTime;
    }

    public void setToTime(Date toTime) {
        this.toTime = toTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}

package com.babyjuan.house.dao.entity;

import java.math.BigDecimal;
import java.util.Date;

public class RentingHouse {
    private Long infoId;

    private Integer sourceId;

    private String houseCode;

    private String title;

    private Byte bedroomNum;

    private Byte hallNum;

    private String orientation;

    private Integer priceTotal;

    private BigDecimal rentArea;

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

    public BigDecimal getRentArea() {
        return rentArea;
    }

    public void setRentArea(BigDecimal rentArea) {
        this.rentArea = rentArea;
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

    @Override
    public String toString() {
        return "RentingHouse{" +
                "infoId=" + infoId +
                ", sourceId=" + sourceId +
                ", houseCode='" + houseCode + '\'' +
                ", title='" + title + '\'' +
                ", bedroomNum=" + bedroomNum +
                ", hallNum=" + hallNum +
                ", orientation='" + orientation + '\'' +
                ", priceTotal=" + priceTotal +
                ", rentArea=" + rentArea +
                ", communityInfoId=" + communityInfoId +
                ", md5='" + md5 + '\'' +
                ", fromTime=" + fromTime +
                ", toTime=" + toTime +
                ", status=" + status +
                '}';
    }
}
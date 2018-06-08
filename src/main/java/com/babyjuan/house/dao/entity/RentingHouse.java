package com.babyjuan.house.dao.entity;

import java.math.BigDecimal;
import java.util.Date;

public class RentingHouse extends RentingHouseKey {
    private String title;

    private Byte bedroomNum;

    private Byte hallNum;

    private String orientation;

    private Integer priceTotal;

    private BigDecimal rentArea;

    private Long communityId;

    private Date createTime;

    private Date updateTime;

    private String md5;

    private Boolean isNew;

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

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5 == null ? null : md5.trim();
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }
}
package com.babyjuan.house.dao.entity;

public class RentingHouseKey {
    private String houseCode;

    private Integer houseSourceId;

    public String getHouseCode() {
        return houseCode;
    }

    public void setHouseCode(String houseCode) {
        this.houseCode = houseCode == null ? null : houseCode.trim();
    }

    public Integer getHouseSourceId() {
        return houseSourceId;
    }

    public void setHouseSourceId(Integer houseSourceId) {
        this.houseSourceId = houseSourceId;
    }
}
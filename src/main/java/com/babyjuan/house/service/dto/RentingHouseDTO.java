package com.babyjuan.house.service.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: hjg
 * @Date: Create in 2018/7/14 21:00
 * @Description:
 */
public class RentingHouseDTO {

    private String title;

    private Byte bedroomNum;

    private Byte hallNum;

    private Integer priceTotal;

    private BigDecimal rentArea;

    private String community;

    private Date fromTime;

    public Date getFromTime() {
        return fromTime;
    }

    public void setFromTime(Date fromTime) {
        this.fromTime = fromTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    @Override
    public String toString() {
        return "RentingHouseDTO{" +
                "title='" + title + '\'' +
                ", bedroomNum=" + bedroomNum +
                ", hallNum=" + hallNum +
                ", priceTotal=" + priceTotal +
                ", rentArea=" + rentArea +
                ", community='" + community + '\'' +
                ", fromTime=" + fromTime +
                '}';
    }
}

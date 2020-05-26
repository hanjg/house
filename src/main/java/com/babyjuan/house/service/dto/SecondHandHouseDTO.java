package com.babyjuan.house.service.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author anxi
 * @version 2020/5/25 19:35
 */
public class SecondHandHouseDTO {

    private String title;

    private Byte bedroomNum;

    private Byte hallNum;

    private Integer priceTotal;

    private Integer unitPrice;

    private BigDecimal area;

    private String community;

    private Date fromTime;

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

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public Date getFromTime() {
        return fromTime;
    }

    public void setFromTime(Date fromTime) {
        this.fromTime = fromTime;
    }
}

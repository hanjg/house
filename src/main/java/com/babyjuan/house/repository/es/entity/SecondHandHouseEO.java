package com.babyjuan.house.repository.es.entity;

/**
 * @author anxi
 * @version 2020/8/19 13:08
 */
public class SecondHandHouseEO {

    private String houseCode;

    private String title;

    private Integer priceTotal;

    private Integer unitPrice;

    private Double area;

    private Long fromTime;

    private Long toTime;

    public String getHouseCode() {
        return houseCode;
    }

    public void setHouseCode(String houseCode) {
        this.houseCode = houseCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Long getFromTime() {
        return fromTime;
    }

    public void setFromTime(Long fromTime) {
        this.fromTime = fromTime;
    }

    public Long getToTime() {
        return toTime;
    }

    public void setToTime(Long toTime) {
        this.toTime = toTime;
    }
}

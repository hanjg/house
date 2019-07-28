package com.babyjuan.house.common.constant;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: hjg
 * @Date: Create in 2018/12/12 15:14
 * @Description:
 */
@Component
public class LianjiaConst {

//    @Value("${lianjia.city.rent.root}")
    private String rentCityRoot;
    @Value("#{'${lianjia.city.districts}'.split(',')}")
    private List<String> districts;
    @Value("${lianjia.city.name}")
    private String cityName;

    @Value("${lianjia.city.second.hand.root}")
    private String secondHandCityRoot;
    @Value("#{'${lianjia.city.second.hand.districts}'.split(',')}")
    private List<String> secondHandDistricts;
    @Value("${lianjia.city.second.hand.name}")
    private String secondHandCityName;

    public String getRentCityRoot() {
        return rentCityRoot;
    }

    public void setRentCityRoot(String rentCityRoot) {
        this.rentCityRoot = rentCityRoot;
    }

    public List<String> getDistricts() {
        return districts;
    }

    public void setDistricts(List<String> districts) {
        this.districts = districts;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getSecondHandCityRoot() {
        return secondHandCityRoot;
    }

    public void setSecondHandCityRoot(String secondHandCityRoot) {
        this.secondHandCityRoot = secondHandCityRoot;
    }

    public List<String> getSecondHandDistricts() {
        return secondHandDistricts;
    }

    public void setSecondHandDistricts(List<String> secondHandDistricts) {
        this.secondHandDistricts = secondHandDistricts;
    }

    public String getSecondHandCityName() {
        return secondHandCityName;
    }

    public void setSecondHandCityName(String secondHandCityName) {
        this.secondHandCityName = secondHandCityName;
    }
}

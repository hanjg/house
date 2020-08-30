package com.babyjuan.house.service;

import com.babyjuan.house.service.dto.PageDTO;
import com.babyjuan.house.repository.mysql.entity.RentingHouse;
import java.util.Date;
import java.util.List;

/**
 * @Author: hjg
 * @Date: Create in 2018/6/21 17:22
 * @Description:
 */
public interface RentingHouseService {

    /**
     * 获得关注小区的更新租房信息
     */
    List<RentingHouse> getLatestFavourateHouseList(String communityName, Date lastPushTime);


    /**
     * 获得关注小区的租房信息
     */
    PageDTO getFavourateHouseList(int page, int rows);

    /**
     * 获得所有租房信息
     */
    PageDTO getRentingHouseList(int page, int rows);

}

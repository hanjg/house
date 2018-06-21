package com.babyjuan.house.service.manager;

import com.babyjuan.house.dao.entity.RentingHouse;
import java.util.Date;
import java.util.List;

/**
 * @Author: hjg
 * @Date: Create in 2018/6/21 17:22
 * @Description:
 */
public interface RentingHouseService {

    List<RentingHouse> getLatestRelativeHouseList(String communityName,Date lastPushTime);

}

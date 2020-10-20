package com.babyjuan.house.repository;

import com.babyjuan.house.common.enums.RecordStatus;
import com.babyjuan.house.repository.mysql.entity.Community;
import com.babyjuan.house.repository.mysql.entity.SecondHandHouse;
import com.babyjuan.house.repository.mysql.entity.ShHouseDeal;
import com.babyjuan.house.repository.mysql.entity.ShHouseDistrictSummary;
import java.util.Date;
import java.util.List;

/**
 * @author anxi
 * @version 2020/9/2 19:31
 */
public interface MysqlRepository {

    /**
     * second hand house
     */
    List<SecondHandHouse> selectSecondHandhouse(int page, int pageSize);

    List<SecondHandHouse> selectSecondHandhouse(RecordStatus status);

    List<SecondHandHouse> selectSecondHandhouse(String md5);

    void updateSecondHandhouse(SecondHandHouse house);

    void insertSecondHandhouse(SecondHandHouse house);

    int updateSecondHandhouseStatus();

    /**
     * second hand house deal
     */
    List<ShHouseDeal> selectShHouseDeal(String houseCode);

    void updateShHouseDeal(ShHouseDeal deal);

    void insertShHouseDeal(ShHouseDeal deal);

    /**
     * community
     */
    Community selectCommunity(Long infoId);

    List<Community> selectCommunity(RecordStatus status);

    List<Community> selectCommunity(String md5);

    void updateCommunity(Community community);

    void insertCommunity(Community community);

    int updateCommunityStatus();

    /**
     * summary
     */
    List<String> queryAllDistricts();

    List<ShHouseDistrictSummary> selectSecondHouseSummaryList(int page, int pageSize);

    List<ShHouseDistrictSummary> selectSecondHouseSummaryList(Date from, Date to);

    List<ShHouseDistrictSummary> selectSecondHouseSummaryList(Date from, Date to, List<String> districts);

    List<ShHouseDistrictSummary> selectSecondHouseSummaryList(Date date, String district);

    List<ShHouseDistrictSummary> summarySecondHouseDistrictSummary(Date date);

    void insertSecondHouseSummary(ShHouseDistrictSummary summary);

}

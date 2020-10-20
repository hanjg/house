package com.babyjuan.house.repository;

import com.babyjuan.house.repository.es.entity.SecondHandHouseEO;
import java.util.List;
import org.apache.commons.lang3.tuple.Pair;

/**
 * @author anxi
 * @version 2020/9/2 19:30
 */
public interface ESRepository {

    Pair<Long, List<SecondHandHouseEO>> getSecondHouseList(int offset, int limit);

    Pair<Long, List<SecondHandHouseEO>> getSecondHouseList(int offset, int limit, String title);

    boolean putSecondHouse(SecondHandHouseEO secondHandHouseEO);

    boolean deleteSecondHouse(String houseCode);
}

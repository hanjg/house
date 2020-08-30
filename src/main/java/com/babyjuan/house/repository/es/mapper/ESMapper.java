package com.babyjuan.house.repository.es.mapper;

import com.babyjuan.house.repository.es.entity.SecondHandHouseEO;
import java.util.List;
import org.apache.commons.lang3.tuple.Pair;

/**
 * @author anxi
 * @version 2020/8/19 13:07
 */
public interface ESMapper {

    Pair<Long, List<SecondHandHouseEO>> getSecondHouseList(int offset, int limit);

    Pair<Long, List<SecondHandHouseEO>> getSecondHouseList(int offset, int limit, String title);

    boolean putSecondHouse(SecondHandHouseEO secondHandHouseEO);

    boolean deleteSecondHouse(String houseCode);
}

package com.babyjuan.house.dao.mapper;

import com.babyjuan.house.dao.entity.RentingHouse;
import com.babyjuan.house.dao.entity.RentingHouseExample;
import com.babyjuan.house.dao.entity.RentingHouseKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RentingHouseMapper {
    int countByExample(RentingHouseExample example);

    int deleteByExample(RentingHouseExample example);

    int deleteByPrimaryKey(RentingHouseKey key);

    int insert(RentingHouse record);

    int insertSelective(RentingHouse record);

    List<RentingHouse> selectByExample(RentingHouseExample example);

    RentingHouse selectByPrimaryKey(RentingHouseKey key);

    int updateByExampleSelective(@Param("record") RentingHouse record, @Param("example") RentingHouseExample example);

    int updateByExample(@Param("record") RentingHouse record, @Param("example") RentingHouseExample example);

    int updateByPrimaryKeySelective(RentingHouse record);

    int updateByPrimaryKey(RentingHouse record);
}
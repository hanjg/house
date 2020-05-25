package com.babyjuan.house.repository.mapper;

import com.babyjuan.house.repository.entity.RentingHouse;
import com.babyjuan.house.repository.entity.RentingHouseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RentingHouseMapper {
    int countByExample(RentingHouseExample example);

    int deleteByExample(RentingHouseExample example);

    int deleteByPrimaryKey(Long infoId);

    int insert(RentingHouse record);

    int insertSelective(RentingHouse record);

    List<RentingHouse> selectByExample(RentingHouseExample example);

    RentingHouse selectByPrimaryKey(Long infoId);

    int updateByExampleSelective(@Param("record") RentingHouse record, @Param("example") RentingHouseExample example);

    int updateByExample(@Param("record") RentingHouse record, @Param("example") RentingHouseExample example);

    int updateByPrimaryKeySelective(RentingHouse record);

    int updateByPrimaryKey(RentingHouse record);

    int updateStatus();
}

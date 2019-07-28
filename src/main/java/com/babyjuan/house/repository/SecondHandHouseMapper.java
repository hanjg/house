package com.babyjuan.house.repository;

import com.babyjuan.house.repository.entity.SecondHandHouse;
import com.babyjuan.house.repository.entity.SecondHandHouseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondHandHouseMapper {
    int countByExample(SecondHandHouseExample example);

    int deleteByExample(SecondHandHouseExample example);

    int deleteByPrimaryKey(Long infoId);

    int insert(SecondHandHouse record);

    int insertSelective(SecondHandHouse record);

    List<SecondHandHouse> selectByExample(SecondHandHouseExample example);

    SecondHandHouse selectByPrimaryKey(Long infoId);

    int updateByExampleSelective(@Param("record") SecondHandHouse record,
            @Param("example") SecondHandHouseExample example);

    int updateByExample(@Param("record") SecondHandHouse record, @Param("example") SecondHandHouseExample example);

    int updateByPrimaryKeySelective(SecondHandHouse record);

    int updateByPrimaryKey(SecondHandHouse record);

    int updateStatus();
}
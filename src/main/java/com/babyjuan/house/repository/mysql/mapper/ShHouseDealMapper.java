package com.babyjuan.house.repository.mysql.mapper;

import com.babyjuan.house.repository.mysql.entity.ShHouseDeal;
import com.babyjuan.house.repository.mysql.entity.ShHouseDealExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShHouseDealMapper {
    int countByExample(ShHouseDealExample example);

    int deleteByExample(ShHouseDealExample example);

    int deleteByPrimaryKey(Long infoId);

    int insert(ShHouseDeal record);

    int insertSelective(ShHouseDeal record);

    List<ShHouseDeal> selectByExample(ShHouseDealExample example);

    ShHouseDeal selectByPrimaryKey(Long infoId);

    int updateByExampleSelective(@Param("record") ShHouseDeal record, @Param("example") ShHouseDealExample example);

    int updateByExample(@Param("record") ShHouseDeal record, @Param("example") ShHouseDealExample example);

    int updateByPrimaryKeySelective(ShHouseDeal record);

    int updateByPrimaryKey(ShHouseDeal record);
}

package com.babyjuan.house.repository.mysql.mapper;

import com.babyjuan.house.repository.mysql.entity.ShHouseDistrictSummary;
import com.babyjuan.house.repository.mysql.entity.ShHouseDistrictSummaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShHouseDistrictSummaryMapper {
    int countByExample(ShHouseDistrictSummaryExample example);

    int deleteByExample(ShHouseDistrictSummaryExample example);

    int deleteByPrimaryKey(Long infoId);

    int insert(ShHouseDistrictSummary record);

    int insertSelective(ShHouseDistrictSummary record);

    List<ShHouseDistrictSummary> selectByExample(ShHouseDistrictSummaryExample example);

    ShHouseDistrictSummary selectByPrimaryKey(Long infoId);

    int updateByExampleSelective(@Param("record") ShHouseDistrictSummary record,
            @Param("example") ShHouseDistrictSummaryExample example);

    int updateByExample(@Param("record") ShHouseDistrictSummary record,
            @Param("example") ShHouseDistrictSummaryExample example);

    int updateByPrimaryKeySelective(ShHouseDistrictSummary record);

    int updateByPrimaryKey(ShHouseDistrictSummary record);

    List<String> queryAllDistricts();
}

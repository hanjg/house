package com.babyjuan.house.list;

import com.babyjuan.house.HouseApplicationTests;
import com.babyjuan.house.common.utils.JsonUtils;
import com.babyjuan.house.repository.es.mapper.ESMapper;
import com.babyjuan.house.repository.es.entity.SecondHandHouseEO;
import com.babyjuan.house.service.SecondHandHouseService;
import com.babyjuan.house.service.dto.BaseResponse;
import com.babyjuan.house.service.dto.PageDTO;
import com.babyjuan.house.service.dto.SecondHandHouseDTO;
import java.math.BigDecimal;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author anxi
 * @version 2020/8/20 0:42
 */
public class SecondHouseServiceTest extends HouseApplicationTests {

    @Autowired
    private SecondHandHouseService secondHandHouseService;

    @Autowired
    private ESMapper esMapper;

    @Test
    public void queryFromES() {
        BaseResponse<PageDTO<SecondHandHouseDTO>> response = secondHandHouseService.getSecondHouseListFromES(0, 10, "123");
        for (SecondHandHouseDTO dto : response.getResult().getRows()) {
            System.out.println(JsonUtils.objectToJson(dto));
        }
    }

    @Test
    public void insertES() {
        SecondHandHouseEO eo = new SecondHandHouseEO();
        eo.setTitle("房屋33333");
        eo.setArea(new BigDecimal("99.99").doubleValue());
        eo.setFromTime(1597680310L);
        eo.setHouseCode("SH003");
        eo.setPriceTotal(9990000);
        eo.setUnitPrice(100000);
        eo.setToTime(1597680310L);
        esMapper.putSecondHouse(eo);
    }

    @Test
    public void deleteES() {
        esMapper.deleteSecondHouse("SH003");
    }
}

package com.babyjuan.house.api;

import com.alibaba.dubbo.config.annotation.Reference;
import com.babyjuan.house.common.utils.JsonUtils;
import com.babyjuan.house.contract.dto.BaseResponse;
import com.babyjuan.house.contract.dto.PageDTO;
import com.babyjuan.house.contract.dto.SecondHandHouseDTO;
import com.babyjuan.house.contract.service.SecondHandHouseService;
import com.babyjuan.house.repository.ESRepository;
import com.babyjuan.house.repository.es.entity.SecondHandHouseEO;
import java.math.BigDecimal;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author anxi
 * @version 2020/8/20 0:42
 */
public class SecondHouseServiceTest extends HouseApiApplicationTests {

    @Reference
    private SecondHandHouseService secondHandHouseService;

    @Autowired(required = false)
    private ESRepository esRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void queryFromES() {
        BaseResponse<PageDTO<SecondHandHouseDTO>> response = secondHandHouseService
                .getSecondHouseListFromES(0, 10, "123");
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
        esRepository.putSecondHouse(eo);
    }

    @Test
    public void deleteES() {
        esRepository.deleteSecondHouse("SH003");
    }

    @Test
    public void testSecondHouse() {
        System.out.println(JsonUtils.objectToJson(secondHandHouseService.getAllDistricts()));
        System.out.println(JsonUtils.objectToJson(secondHandHouseService.getSecondHouseList(0, 3)));
    }
}

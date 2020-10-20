package com.babyjuan.house.api.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.babyjuan.house.contract.api.HouseApiService;

/**
 * @author anxi
 * @version 2020/9/2 0:37
 */
@Service
public class HouseApiServiceImpl implements HouseApiService {

    @Override
    public String test() {
        return "hello!!!";
    }
}

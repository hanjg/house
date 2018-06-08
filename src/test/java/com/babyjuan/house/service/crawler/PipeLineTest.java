package com.babyjuan.house.service.crawler;

import com.babyjuan.house.base.BaseTest;
import com.babyjuan.house.dao.entity.Community;
import com.babyjuan.house.dao.mapper.CommunityMapper;
import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: hjg
 * @Date: Create in 2018/6/6 16:43
 * @Description:
 */
public class PipeLineTest extends BaseTest {

    @Autowired
    private CommunityMapper communityMapper;

    @Test
    public void testGetNull() {
        Community community = communityMapper.selectByPrimaryKey(234L);
        Assert.assertNull(community);
    }

    @Test
    public void testBigDecimal(){
        BigDecimal bigDecimal  = new BigDecimal("23.33");
        System.out.println(bigDecimal.toString());
    }

}

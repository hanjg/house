package com.babyjuan.house.task.spider;

import com.babyjuan.house.repository.mysql.entity.Community;
import com.babyjuan.house.repository.mysql.mapper.CommunityMapper;
import com.babyjuan.house.task.HouseTaskApplicationTests;
import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: hjg
 * @Date: Create in 2018/6/6 16:43
 * @Description:
 */
public class PipeLineTest extends HouseTaskApplicationTests {

    @Autowired
    private CommunityMapper communityMapper;

    @Test
    public void testGetNull() {
        Community community = communityMapper.selectByPrimaryKey(234L);
        Assert.assertNull(community);
    }

    @Test
    public void testBigDecimal() {
        BigDecimal bigDecimal = new BigDecimal("23.33");
        System.out.println(bigDecimal.toString());
    }

}

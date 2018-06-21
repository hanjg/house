package com.babyjuan.house.service.manager.impl;

import com.babyjuan.house.common.enums.RecordStatus;
import com.babyjuan.house.dao.entity.Community;
import com.babyjuan.house.dao.entity.CommunityExample;
import com.babyjuan.house.dao.entity.RentingHouse;
import com.babyjuan.house.dao.entity.RentingHouseExample;
import com.babyjuan.house.dao.mapper.CommunityMapper;
import com.babyjuan.house.dao.mapper.RentingHouseMapper;
import com.babyjuan.house.service.manager.RentingHouseService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: hjg
 * @Date: Create in 2018/6/21 17:37
 * @Description:
 */
@Service
public class RentingHouseServiceImpl implements RentingHouseService {

    @Autowired
    private RentingHouseMapper rentingHouseMapper;
    @Autowired
    private CommunityMapper communityMapper;

    @Override
    public List<RentingHouse> getLatestRelativeHouseList(String communityName, Date lastPushTime) {
        CommunityExample communityExample = new CommunityExample();
        CommunityExample.Criteria communityCriteria = communityExample.createCriteria();
        communityCriteria.andStatusNotEqualTo(RecordStatus.EXPIRED.getStatus());
        communityCriteria.andCommunityNameLike(modifyName(communityName));
        List<Community> communityList = communityMapper.selectByExample(communityExample);

        if (communityList.isEmpty()) {
            return new ArrayList<>();
        } else {
            RentingHouseExample houseExample = new RentingHouseExample();
            RentingHouseExample.Criteria houseCriteria = houseExample.createCriteria();
            houseCriteria.andStatusNotEqualTo(RecordStatus.EXPIRED.getStatus());
            houseCriteria.andCommunityInfoIdIn(getCommunityInfoId(communityList));
            houseCriteria.andFromTimeGreaterThan(lastPushTime);
            List<RentingHouse> list = rentingHouseMapper.selectByExample(houseExample);
            return list;
        }
    }

    private List<Long> getCommunityInfoId(List<Community> communityList) {
        List<Long> list = new ArrayList<>();
        for (Community community : communityList) {
            list.add(community.getInfoId());
        }
        return list;
    }

    private String modifyName(String name) {
        return "%" + name + "%";
    }
}

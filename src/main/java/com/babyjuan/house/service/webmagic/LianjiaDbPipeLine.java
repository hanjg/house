package com.babyjuan.house.service.webmagic;


import com.babyjuan.house.common.enums.HouseSource;
import com.babyjuan.house.dao.entity.Community;
import com.babyjuan.house.dao.entity.RentingHouse;
import com.babyjuan.house.dao.entity.RentingHouseKey;
import com.babyjuan.house.dao.mapper.CommunityMapper;
import com.babyjuan.house.dao.mapper.RentingHouseMapper;
import java.math.BigDecimal;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * @Author: hjg
 * @Date: Create in 2018/6/6 16:05
 * @Description:
 */
public class LianjiaDbPipeLine implements Pipeline {

    @Autowired
    private RentingHouseMapper rentingHouseMapper;
    @Autowired
    private CommunityMapper communityMapper;

    @Override
    public void process(ResultItems resultItems, Task task) {
        //插入小区相关信息
        processCommunity(resultItems);
        //插入住房相关信息
        processRentingHouse(resultItems);
    }

    private void processCommunity(ResultItems resultItems) {
        Long communityId = Long.valueOf(resultItems.get(LianjiaFieldInfo.COMMUNITY_ID));

        Community OldCommunity = communityMapper.selectByPrimaryKey(communityId);
        if (OldCommunity == null) {
            Community currentCommunity = getCurrentCommunity(resultItems);
            currentCommunity.setUpdateTime(new Date());
            currentCommunity.setCreateTime(new Date());
            communityMapper.insert(currentCommunity);
        } else {
            //存在相同的小区
            Community currentCommunity = getCurrentCommunity(resultItems);
            if (OldCommunity.getMd5().equals(currentCommunity.getMd5())) {
                //小区信息没有变化，只需更新时间
                Community community = new Community();
                community.setCommunityId(currentCommunity.getCommunityId());
                community.setUpdateTime(new Date());
                communityMapper.updateByPrimaryKeySelective(community);
            } else {
                //小区信息有变化，更新除了创建时间之外的所有
                currentCommunity.setUpdateTime(new Date());
                communityMapper.updateByPrimaryKeySelective(currentCommunity);
            }
        }
    }

    private void processRentingHouse(ResultItems resultItems) {
        RentingHouseKey key = new RentingHouseKey();
        key.setHouseSourceId(HouseSource.LIAN_JIA.getId());
        key.setHouseCode(resultItems.get(LianjiaFieldInfo.HOUSE_CODE));

        RentingHouse oldHouse = rentingHouseMapper.selectByPrimaryKey(key);
        if (oldHouse == null) {
            RentingHouse currentHouse = getCurrentRentHouse(resultItems);
            currentHouse.setCreateTime(new Date());
            currentHouse.setUpdateTime(new Date());
            currentHouse.setIsNew(true);
            rentingHouseMapper.insert(currentHouse);
        } else {
            RentingHouse currentHouse = getCurrentRentHouse(resultItems);
            if (oldHouse.getMd5().equals(currentHouse.getMd5())) {
                RentingHouse house = new RentingHouse();
                house.setHouseSourceId(currentHouse.getHouseSourceId());
                house.setHouseCode(currentHouse.getHouseCode());
                house.setUpdateTime(new Date());
                house.setIsNew(true);
                rentingHouseMapper.updateByPrimaryKeySelective(house);
            } else {
                currentHouse.setUpdateTime(new Date());
                currentHouse.setIsNew(true);
                rentingHouseMapper.updateByPrimaryKeySelective(currentHouse);
            }
        }

    }

    /**
     * 除了创建和更新时间之外的项目
     */
    private Community getCurrentCommunity(ResultItems resultItems) {
        Long communityId = Long.valueOf(resultItems.get(LianjiaFieldInfo.COMMUNITY_ID));
        String communityName = resultItems.get(LianjiaFieldInfo.COMMUNITY_NAME);
        String latitude = resultItems.get(LianjiaFieldInfo.LATITUDE);
        String longitude = resultItems.get(LianjiaFieldInfo.LONGITUDE);
        String city = resultItems.get(LianjiaFieldInfo.CITY);
        String district = resultItems.get(LianjiaFieldInfo.DISTRICT);
        String area = resultItems.get(LianjiaFieldInfo.AREA);

        Community community = new Community();
        community.setCommunityId(communityId);
        community.setCommunityName(communityName);
        community.setLatitude(new BigDecimal(latitude));
        community.setLongitude(new BigDecimal(longitude));
        community.setCity(city);
        community.setDistrict(district);
        community.setArea(area);
        community.setMd5(getMd5(community));

        return community;
    }

    private String getMd5(Community community) {
        String src = community.getCommunityId() + community.getCommunityName() + community.getLatitude() + community
                .getLongitude() + community.getCommunityName() + community.getDistrict() + community.getArea();
        return DigestUtils.md5DigestAsHex(src.getBytes());
    }

    /**
     * 除了除了创建和更新时间、是否最新之外的项目
     */
    private RentingHouse getCurrentRentHouse(ResultItems resultItems) {
        String houseCode = resultItems.get(LianjiaFieldInfo.HOUSE_CODE);
        String title = resultItems.get(LianjiaFieldInfo.TITLE);
        Byte bedRoomNum = Byte.valueOf(resultItems.get(LianjiaFieldInfo.BED_ROOM_NUM));
        Byte hallNum = Byte.valueOf(resultItems.get(LianjiaFieldInfo.HALL_NUM));
        String orientation = resultItems.get(LianjiaFieldInfo.ORIENTATION);
        Integer priceTotal = Integer.valueOf(resultItems.get(LianjiaFieldInfo.PRICE_TOTAL));
        String rentArea = resultItems.get(LianjiaFieldInfo.RENT_AREA);
        Long communityId = Long.valueOf(resultItems.get(LianjiaFieldInfo.COMMUNITY_ID));

        RentingHouse rentingHouse = new RentingHouse();
        rentingHouse.setHouseSourceId(HouseSource.LIAN_JIA.getId());
        rentingHouse.setHouseCode(houseCode);
        rentingHouse.setTitle(title);
        rentingHouse.setBedroomNum(bedRoomNum);
        rentingHouse.setHallNum(hallNum);
        rentingHouse.setOrientation(orientation);
        rentingHouse.setPriceTotal(priceTotal);
        rentingHouse.setRentArea(new BigDecimal(rentArea));
        rentingHouse.setCommunityId(communityId);
        rentingHouse.setMd5(getMd5(rentingHouse));

        return rentingHouse;
    }

    private String getMd5(RentingHouse rentingHouse) {
        String src =
                rentingHouse.getHouseSourceId() + rentingHouse.getHouseCode() + rentingHouse.getTitle() + rentingHouse
                        .getBedroomNum() + rentingHouse.getHallNum() + rentingHouse.getOrientation() + rentingHouse
                        .getPriceTotal() + rentingHouse.getRentArea() + rentingHouse.getCommunityId();
        return DigestUtils.md5DigestAsHex(src.getBytes());
    }

}

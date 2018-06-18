package com.babyjuan.house.service.webmagic;


import com.babyjuan.house.common.enums.HouseSource;
import com.babyjuan.house.common.enums.RecordStatus;
import com.babyjuan.house.dao.entity.Community;
import com.babyjuan.house.dao.entity.CommunityExample;
import com.babyjuan.house.dao.entity.CommunityExample.Criteria;
import com.babyjuan.house.dao.entity.RentingHouse;
import com.babyjuan.house.dao.entity.RentingHouseExample;
import com.babyjuan.house.dao.mapper.CommunityMapper;
import com.babyjuan.house.dao.mapper.RentingHouseMapper;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * @Author: hjg
 * @Date: Create in 2018/6/6 12:12
 * @Description:
 */
public class LianjiaDbPipeLine implements Pipeline {

    @Autowired
    private RentingHouseMapper rentingHouseMapper;
    @Autowired
    private CommunityMapper communityMapper;

    private int sourceId = HouseSource.LIAN_JIA.getId();

    @Override
    public void process(ResultItems resultItems, Task task) {
        //插入小区相关信息
        long communityInfoId = processCommunity(resultItems);
        //插入住房相关信息
        processRentingHouse(resultItems, communityInfoId);
    }

    private long processCommunity(ResultItems resultItems) {
        Community currentCommunity = getCurrentCommunity(resultItems);

        CommunityExample example = new CommunityExample();
        Criteria criteria = example.createCriteria();
        criteria.andSourceIdEqualTo(currentCommunity.getSourceId());
        criteria.andCommunityCodeEqualTo(currentCommunity.getCommunityCode());
        criteria.andStatusEqualTo(RecordStatus.LATEST.getStatus());

        List<Community> oldCommunityList = communityMapper.selectByExample(example);
        if (oldCommunityList.isEmpty()) {
            //不存在相同的小区
            return insertNew(currentCommunity);
        } else {
            //存在相同的小区
            Community oldCommunity = oldCommunityList.get(0);
            if (oldCommunity.getMd5().equals(currentCommunity.getMd5())) {
                //小区信息没有变化，只需更新时间和状态
                return updateOld(oldCommunity);
            } else {
                //小区信息有变化，重新插入数据
                return insertNew(currentCommunity);
            }
        }
    }

    private long updateOld(Community oldCommunity) {
        Community community = new Community();
        community.setInfoId(oldCommunity.getInfoId());
        community.setToTime(new Date());
        community.setStatus(RecordStatus.UPDATING.getStatus());
        communityMapper.updateByPrimaryKeySelective(community);
        return community.getInfoId();
    }

    private long insertNew(Community currentCommunity) {
        //日期使用默认值：当前时间
        currentCommunity.setStatus(RecordStatus.UPDATING.getStatus());
        communityMapper.insert(currentCommunity);
        return currentCommunity.getInfoId();
    }

    private long updateOld(RentingHouse oldHouse) {
        Community community = new Community();
        community.setInfoId(oldHouse.getInfoId());
        community.setToTime(new Date());
        community.setStatus(RecordStatus.UPDATING.getStatus());
        communityMapper.updateByPrimaryKeySelective(community);
        return community.getInfoId();
    }

    private long insertNew(RentingHouse currentHouse) {
        //日期使用默认值：当前时间
        currentHouse.setStatus(RecordStatus.UPDATING.getStatus());
        rentingHouseMapper.insert(currentHouse);
        return currentHouse.getInfoId();
    }


    private void processRentingHouse(ResultItems resultItems, long communityInfoId) {
        RentingHouse currentHouse = getCurrentRentHouse(resultItems, communityInfoId);

        RentingHouseExample example = new RentingHouseExample();
        RentingHouseExample.Criteria criteria = example.createCriteria();
        criteria.andSourceIdEqualTo(currentHouse.getSourceId());
        criteria.andHouseCodeEqualTo(currentHouse.getHouseCode());
        criteria.andStatusEqualTo(RecordStatus.LATEST.getStatus());

        List<RentingHouse> oldHouseList = rentingHouseMapper.selectByExample(example);
        if (oldHouseList.isEmpty()) {
            currentHouse.setStatus(RecordStatus.UPDATING.getStatus());
            rentingHouseMapper.insert(currentHouse);
        } else {
            RentingHouse oldHouse = oldHouseList.get(0);
            if (oldHouse.getMd5().equals(currentHouse.getMd5())) {
                updateOld(oldHouse);
            } else {
                insertNew(currentHouse);
            }
        }

    }

    /**
     * 除了创建和更新时间、记录状态之外的项目
     */
    private Community getCurrentCommunity(ResultItems resultItems) {
        String communityCode = resultItems.get(LianjiaFieldInfo.COMMUNITY_CODE);
        String communityName = resultItems.get(LianjiaFieldInfo.COMMUNITY_NAME);
        String latitude = resultItems.get(LianjiaFieldInfo.LATITUDE);
        String longitude = resultItems.get(LianjiaFieldInfo.LONGITUDE);
        String city = resultItems.get(LianjiaFieldInfo.CITY);
        String district = resultItems.get(LianjiaFieldInfo.DISTRICT);
        String block = resultItems.get(LianjiaFieldInfo.BLOCK);

        Community community = new Community();
        community.setSourceId(sourceId);
        community.setCommunityCode(communityCode);
        community.setCommunityName(communityName);
        community.setLatitude(new BigDecimal(latitude));
        community.setLongitude(new BigDecimal(longitude));
        community.setCity(city);
        community.setDistrict(district);
        community.setBlock(block);

        community.setMd5(getMd5(community));

        return community;
    }

    private String getMd5(Community community) {
        String src = community.getCommunityCode() + community.getCommunityName() + community.getLatitude() + community
                .getLongitude() + community.getCity() + community.getDistrict() + community.getBlock();
        return DigestUtils.md5DigestAsHex(src.getBytes());
    }

    /**
     * 除了创建和更新时间、记录状态之外的项目
     */
    private RentingHouse getCurrentRentHouse(ResultItems resultItems, long communityInfoId) {
        String houseCode = resultItems.get(LianjiaFieldInfo.HOUSE_CODE);
        String title = resultItems.get(LianjiaFieldInfo.TITLE);
        Byte bedRoomNum = Byte.valueOf(resultItems.get(LianjiaFieldInfo.BED_ROOM_NUM));
        Byte hallNum = Byte.valueOf(resultItems.get(LianjiaFieldInfo.HALL_NUM));
        String orientation = resultItems.get(LianjiaFieldInfo.ORIENTATION);
        Integer priceTotal = Integer.valueOf(resultItems.get(LianjiaFieldInfo.PRICE_TOTAL));
        String rentArea = resultItems.get(LianjiaFieldInfo.RENT_AREA);

        RentingHouse rentingHouse = new RentingHouse();
        rentingHouse.setSourceId(sourceId);
        rentingHouse.setHouseCode(houseCode);
        rentingHouse.setTitle(title);
        rentingHouse.setBedroomNum(bedRoomNum);
        rentingHouse.setHallNum(hallNum);
        rentingHouse.setOrientation(orientation);
        rentingHouse.setPriceTotal(priceTotal);
        rentingHouse.setRentArea(new BigDecimal(rentArea));
        rentingHouse.setCommunityInfoId(communityInfoId);

        rentingHouse.setMd5(getMd5(rentingHouse));

        return rentingHouse;
    }

    private String getMd5(RentingHouse rentingHouse) {
        String src =
                rentingHouse.getSourceId() + rentingHouse.getHouseCode() + rentingHouse.getTitle() + rentingHouse
                        .getBedroomNum() + rentingHouse.getHallNum() + rentingHouse.getOrientation() + rentingHouse
                        .getPriceTotal() + rentingHouse.getRentArea() + rentingHouse.getCommunityInfoId();
        return DigestUtils.md5DigestAsHex(src.getBytes());
    }

}

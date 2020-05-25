package com.babyjuan.house.task.spider.webmagic.pipeline;


import com.babyjuan.house.common.enums.HouseSource;
import com.babyjuan.house.common.enums.RecordStatus;
import com.babyjuan.house.repository.entity.Community;
import com.babyjuan.house.repository.entity.CommunityExample;
import com.babyjuan.house.repository.entity.CommunityExample.Criteria;
import com.babyjuan.house.repository.entity.RentingHouse;
import com.babyjuan.house.repository.entity.RentingHouseExample;
import com.babyjuan.house.repository.mapper.CommunityMapper;
import com.babyjuan.house.repository.mapper.RentingHouseMapper;
import com.babyjuan.house.task.spider.webmagic.LianjiaFieldInfo;
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
        criteria.andMd5EqualTo(currentCommunity.getMd5());
        //由sourceId和houseCode查找:
        //在不包括过期的数据中查找，某些数据由于网络原因不一定每次都能爬取到，会误认为过期
        //在包括过期的数据中查找，如果数据更新，每次的数据都和第一次过期的数据比较，会重复插入最新的数据
        //所以变更为md5查找，确保不会有重复插入

        List<Community> oldCommunityList = communityMapper.selectByExample(example);
        if (oldCommunityList.isEmpty()) {
            //不存在相同的小区或者相同小区信息有变化，重新插入数据
            return insertNew(currentCommunity);
        } else {
            //存在相同的小区并且无变化，只需更新时间和状态
            Community oldCommunity = oldCommunityList.get(0);
            return updateOld(oldCommunity);
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
        //日期使用默认值：当前时间。mysql5.5之前timestamp只有一个默认值，直接写入当前时间，不使用默认值
        currentCommunity.setStatus(RecordStatus.UPDATING.getStatus());
        currentCommunity.setFromTime(new Date());
        currentCommunity.setToTime(new Date());
        communityMapper.insert(currentCommunity);
        return currentCommunity.getInfoId();
    }

    private void updateOld(RentingHouse oldHouse) {
        RentingHouse house = new RentingHouse();
        house.setInfoId(oldHouse.getInfoId());
        house.setToTime(new Date());
        house.setStatus(RecordStatus.UPDATING.getStatus());
        rentingHouseMapper.updateByPrimaryKeySelective(house);
    }

    private void insertNew(RentingHouse currentHouse) {
        //日期使用默认值：当前时间
        currentHouse.setStatus(RecordStatus.UPDATING.getStatus());
        currentHouse.setFromTime(new Date());
        currentHouse.setToTime(new Date());
        rentingHouseMapper.insert(currentHouse);
    }


    private void processRentingHouse(ResultItems resultItems, long communityInfoId) {
        RentingHouse currentHouse = getCurrentRentHouse(resultItems, communityInfoId);

        RentingHouseExample example = new RentingHouseExample();
        RentingHouseExample.Criteria criteria = example.createCriteria();
        criteria.andMd5EqualTo(currentHouse.getMd5());

        List<RentingHouse> oldHouseList = rentingHouseMapper.selectByExample(example);
        if (oldHouseList.isEmpty()) {
            insertNew(currentHouse);
        } else {
            RentingHouse oldHouse = oldHouseList.get(0);
            updateOld(oldHouse);
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
        community.setLatitude(new BigDecimal(latitude == null ? "0" : latitude));
        community.setLongitude(new BigDecimal(longitude == null ? "0" : longitude));
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
        String rentArea = resultItems.get(LianjiaFieldInfo.AREA);

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

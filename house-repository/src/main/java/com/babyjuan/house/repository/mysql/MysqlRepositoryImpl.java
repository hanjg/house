package com.babyjuan.house.repository.mysql;

import com.babyjuan.house.common.enums.RecordStatus;
import com.babyjuan.house.repository.MysqlRepository;
import com.babyjuan.house.repository.mysql.entity.Community;
import com.babyjuan.house.repository.mysql.entity.CommunityExample;
import com.babyjuan.house.repository.mysql.entity.SecondHandHouse;
import com.babyjuan.house.repository.mysql.entity.SecondHandHouseExample;
import com.babyjuan.house.repository.mysql.entity.SecondHandHouseExample.Criteria;
import com.babyjuan.house.repository.mysql.entity.ShHouseDeal;
import com.babyjuan.house.repository.mysql.entity.ShHouseDealExample;
import com.babyjuan.house.repository.mysql.entity.ShHouseDistrictSummary;
import com.babyjuan.house.repository.mysql.entity.ShHouseDistrictSummaryExample;
import com.babyjuan.house.repository.mysql.mapper.CommunityMapper;
import com.babyjuan.house.repository.mysql.mapper.SecondHandHouseMapper;
import com.babyjuan.house.repository.mysql.mapper.ShHouseDealMapper;
import com.babyjuan.house.repository.mysql.mapper.ShHouseDistrictSummaryMapper;
import com.github.pagehelper.PageHelper;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author anxi
 * @version 2020/9/3 0:01
 */
@Repository
public class MysqlRepositoryImpl implements MysqlRepository {

    @Autowired
    private SecondHandHouseMapper secondHandHouseMapper;

    @Autowired
    private ShHouseDealMapper shHouseDealMapper;

    @Autowired
    private CommunityMapper communityMapper;

    @Autowired
    private ShHouseDistrictSummaryMapper shHouseDistrictSummaryMapper;

    @Override
    public List<SecondHandHouse> selectSecondHandhouse(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        SecondHandHouseExample example = new SecondHandHouseExample();
        example.createCriteria().andStatusNotEqualTo(RecordStatus.EXPIRED.getStatus());
        example.setOrderByClause("to_time desc");
        return secondHandHouseMapper.selectByExample(example);
    }

    @Override
    public List<SecondHandHouse> selectSecondHandhouse(RecordStatus status) {
        SecondHandHouseExample rentingHouseExample = new SecondHandHouseExample();
        Criteria renthouseCriteria = rentingHouseExample.createCriteria();
        renthouseCriteria.andStatusEqualTo(status.getStatus());
        return secondHandHouseMapper.selectByExample(rentingHouseExample);
    }

    @Override
    public List<SecondHandHouse> selectSecondHandhouse(String md5) {
        SecondHandHouseExample example = new SecondHandHouseExample();
        SecondHandHouseExample.Criteria criteria = example.createCriteria();
        criteria.andMd5EqualTo(md5);
        return secondHandHouseMapper.selectByExample(example);
    }

    @Override
    public void updateSecondHandhouse(SecondHandHouse house) {
        secondHandHouseMapper.updateByPrimaryKeySelective(house);
    }

    @Override
    public void insertSecondHandhouse(SecondHandHouse house) {
        secondHandHouseMapper.insert(house);
    }

    @Override
    public int updateSecondHandhouseStatus() {
        return secondHandHouseMapper.updateStatus();
    }

    @Override
    public List<ShHouseDeal> selectShHouseDeal(String houseCode) {
        ShHouseDealExample example = new ShHouseDealExample();
        ShHouseDealExample.Criteria criteria = example.createCriteria();
        criteria.andHouseCodeEqualTo(houseCode);
        return shHouseDealMapper.selectByExample(example);
    }

    @Override
    public void updateShHouseDeal(ShHouseDeal deal) {
        shHouseDealMapper.updateByPrimaryKeySelective(deal);
    }

    @Override
    public void insertShHouseDeal(ShHouseDeal deal) {
        shHouseDealMapper.insert(deal);
    }

    @Override
    public Community selectCommunity(Long infoId) {
        return communityMapper.selectByPrimaryKey(infoId);
    }

    @Override
    public List<Community> selectCommunity(RecordStatus status) {
        CommunityExample communityExample = new CommunityExample();
        CommunityExample.Criteria communityCriteria = communityExample.createCriteria();
        communityCriteria.andStatusEqualTo(status.getStatus());
        return communityMapper.selectByExample(communityExample);
    }

    @Override
    public List<Community> selectCommunity(String md5) {
        CommunityExample example = new CommunityExample();
        CommunityExample.Criteria criteria = example.createCriteria();
        criteria.andMd5EqualTo(md5);
        return communityMapper.selectByExample(example);
    }

    @Override
    public void updateCommunity(Community community) {
        communityMapper.updateByPrimaryKeySelective(community);
    }

    @Override
    public void insertCommunity(Community community) {
        communityMapper.insert(community);
    }

    @Override
    public int updateCommunityStatus() {
        return communityMapper.updateStatus();
    }

    @Override
    public List<String> queryAllDistricts() {
        return shHouseDistrictSummaryMapper.queryAllDistricts();
    }

    @Override
    public List<ShHouseDistrictSummary> selectSecondHouseSummaryList(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        ShHouseDistrictSummaryExample example = new ShHouseDistrictSummaryExample();
        example.setOrderByClause("info_time desc");
        return shHouseDistrictSummaryMapper.selectByExample(example);
    }

    @Override
    public List<ShHouseDistrictSummary> selectSecondHouseSummaryList(Date from, Date to) {
        ShHouseDistrictSummaryExample example = new ShHouseDistrictSummaryExample();
        example.createCriteria().andInfoTimeBetween(from, to);
        return shHouseDistrictSummaryMapper.selectByExample(example);
    }

    @Override
    public List<ShHouseDistrictSummary> selectSecondHouseSummaryList(Date from, Date to, List<String> districts) {
        ShHouseDistrictSummaryExample example = new ShHouseDistrictSummaryExample();
        example.createCriteria().andInfoTimeBetween(from, to).andDistrictIn(districts);
        return shHouseDistrictSummaryMapper.selectByExample(example);
    }

    @Override
    public List<ShHouseDistrictSummary> selectSecondHouseSummaryList(Date date, String district) {
        ShHouseDistrictSummaryExample example = new ShHouseDistrictSummaryExample();
        example.createCriteria().andInfoTimeEqualTo(date).andDistrictEqualTo(district);
        return shHouseDistrictSummaryMapper.selectByExample(example);
    }

    @Override
    public List<ShHouseDistrictSummary> summarySecondHouseDistrictSummary(Date date) {
        return secondHandHouseMapper.queryDistrictSummary(date);
    }

    @Override
    public void insertSecondHouseSummary(ShHouseDistrictSummary summary) {
        shHouseDistrictSummaryMapper.insert(summary);
    }
}

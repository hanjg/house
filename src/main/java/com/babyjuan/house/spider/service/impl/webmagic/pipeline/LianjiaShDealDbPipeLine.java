package com.babyjuan.house.spider.service.impl.webmagic.pipeline;


import com.babyjuan.house.common.enums.HouseSource;
import com.babyjuan.house.repository.ShHouseDealMapper;
import com.babyjuan.house.repository.entity.ShHouseDeal;
import com.babyjuan.house.repository.entity.ShHouseDealExample;
import com.babyjuan.house.repository.entity.ShHouseDealExample.Criteria;
import com.babyjuan.house.spider.service.impl.webmagic.LianjiaFieldInfo;
import java.util.List;
import java.util.Objects;
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
public class LianjiaShDealDbPipeLine implements Pipeline {

    @Autowired
    private ShHouseDealMapper shHouseDealMapper;

    private int sourceId = HouseSource.LIAN_JIA.getId();

    @Override
    public void process(ResultItems resultItems, Task task) {
        ShHouseDeal currentDeal = getCurrentDeal(resultItems);

        ShHouseDealExample example = new ShHouseDealExample();
        Criteria criteria = example.createCriteria();
        criteria.andHouseCodeEqualTo(currentDeal.getHouseCode());
        List<ShHouseDeal> oldDeals = shHouseDealMapper.selectByExample(example);
        if (oldDeals.isEmpty()) {
            insertNew(currentDeal);
        } else if (!Objects.equals(currentDeal.getMd5(), oldDeals.get(0).getMd5())) {
            updateOld(oldDeals.get(0));
        }
    }

    private void updateOld(ShHouseDeal oldDeal) {
        shHouseDealMapper.updateByPrimaryKeySelective(oldDeal);
    }

    private void insertNew(ShHouseDeal currentDeal) {
        shHouseDealMapper.insert(currentDeal);
    }

    /**
     * 除了创建和更新时间、记录状态之外的项目
     */
    private ShHouseDeal getCurrentDeal(ResultItems resultItems) {
        String houseCode = resultItems.get(LianjiaFieldInfo.HOUSE_CODE);
        Long originPrice = resultItems.get(LianjiaFieldInfo.ORIGIN_PRICE);
        Long finalPrice = resultItems.get(LianjiaFieldInfo.FINAL_PRICE);
        Long finalUnitPrice = resultItems.get(LianjiaFieldInfo.FINAL_UNIT_PRICE);
        Integer dealTime = resultItems.get(LianjiaFieldInfo.DEAL_TIME);
        Integer adjustCount = resultItems.get(LianjiaFieldInfo.ADJUST_COUNT);
        Integer lookCount = resultItems.get(LianjiaFieldInfo.LOOK_COUNT);
        Integer attentionCount = resultItems.get(LianjiaFieldInfo.ATTENTION_COUNT);

        ShHouseDeal shHouseDeal = new ShHouseDeal();
        shHouseDeal.setSourceId(sourceId);
        shHouseDeal.setHouseCode(houseCode);
        shHouseDeal.setOriginPrice(originPrice);
        shHouseDeal.setFinalPrice(finalPrice);
        shHouseDeal.setFinalUnitPrice(finalUnitPrice);
        shHouseDeal.setDealTime(dealTime);
        shHouseDeal.setAdjustCount(adjustCount);
        shHouseDeal.setLookCount(lookCount);
        shHouseDeal.setAttentionCount(attentionCount);
        shHouseDeal.setMd5(getMd5(shHouseDeal));
        return shHouseDeal;
    }

    private String getMd5(ShHouseDeal houseDeal) {
        String src = "" + houseDeal.getOriginPrice() + houseDeal.getFinalPrice() + houseDeal
                .getDealTime() + houseDeal.getAdjustCount() + houseDeal.getLookCount() + houseDeal.getAttentionCount();
        return DigestUtils.md5DigestAsHex(src.getBytes());
    }
}

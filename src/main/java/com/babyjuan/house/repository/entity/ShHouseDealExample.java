package com.babyjuan.house.repository.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShHouseDealExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShHouseDealExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andInfoIdIsNull() {
            addCriterion("info_id is null");
            return (Criteria) this;
        }

        public Criteria andInfoIdIsNotNull() {
            addCriterion("info_id is not null");
            return (Criteria) this;
        }

        public Criteria andInfoIdEqualTo(Long value) {
            addCriterion("info_id =", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdNotEqualTo(Long value) {
            addCriterion("info_id <>", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdGreaterThan(Long value) {
            addCriterion("info_id >", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdGreaterThanOrEqualTo(Long value) {
            addCriterion("info_id >=", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdLessThan(Long value) {
            addCriterion("info_id <", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdLessThanOrEqualTo(Long value) {
            addCriterion("info_id <=", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdIn(List<Long> values) {
            addCriterion("info_id in", values, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdNotIn(List<Long> values) {
            addCriterion("info_id not in", values, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdBetween(Long value1, Long value2) {
            addCriterion("info_id between", value1, value2, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdNotBetween(Long value1, Long value2) {
            addCriterion("info_id not between", value1, value2, "infoId");
            return (Criteria) this;
        }

        public Criteria andSourceIdIsNull() {
            addCriterion("source_id is null");
            return (Criteria) this;
        }

        public Criteria andSourceIdIsNotNull() {
            addCriterion("source_id is not null");
            return (Criteria) this;
        }

        public Criteria andSourceIdEqualTo(Integer value) {
            addCriterion("source_id =", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotEqualTo(Integer value) {
            addCriterion("source_id <>", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdGreaterThan(Integer value) {
            addCriterion("source_id >", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("source_id >=", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLessThan(Integer value) {
            addCriterion("source_id <", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLessThanOrEqualTo(Integer value) {
            addCriterion("source_id <=", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdIn(List<Integer> values) {
            addCriterion("source_id in", values, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotIn(List<Integer> values) {
            addCriterion("source_id not in", values, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdBetween(Integer value1, Integer value2) {
            addCriterion("source_id between", value1, value2, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("source_id not between", value1, value2, "sourceId");
            return (Criteria) this;
        }

        public Criteria andHouseCodeIsNull() {
            addCriterion("house_code is null");
            return (Criteria) this;
        }

        public Criteria andHouseCodeIsNotNull() {
            addCriterion("house_code is not null");
            return (Criteria) this;
        }

        public Criteria andHouseCodeEqualTo(String value) {
            addCriterion("house_code =", value, "houseCode");
            return (Criteria) this;
        }

        public Criteria andHouseCodeNotEqualTo(String value) {
            addCriterion("house_code <>", value, "houseCode");
            return (Criteria) this;
        }

        public Criteria andHouseCodeGreaterThan(String value) {
            addCriterion("house_code >", value, "houseCode");
            return (Criteria) this;
        }

        public Criteria andHouseCodeGreaterThanOrEqualTo(String value) {
            addCriterion("house_code >=", value, "houseCode");
            return (Criteria) this;
        }

        public Criteria andHouseCodeLessThan(String value) {
            addCriterion("house_code <", value, "houseCode");
            return (Criteria) this;
        }

        public Criteria andHouseCodeLessThanOrEqualTo(String value) {
            addCriterion("house_code <=", value, "houseCode");
            return (Criteria) this;
        }

        public Criteria andHouseCodeLike(String value) {
            addCriterion("house_code like", value, "houseCode");
            return (Criteria) this;
        }

        public Criteria andHouseCodeNotLike(String value) {
            addCriterion("house_code not like", value, "houseCode");
            return (Criteria) this;
        }

        public Criteria andHouseCodeIn(List<String> values) {
            addCriterion("house_code in", values, "houseCode");
            return (Criteria) this;
        }

        public Criteria andHouseCodeNotIn(List<String> values) {
            addCriterion("house_code not in", values, "houseCode");
            return (Criteria) this;
        }

        public Criteria andHouseCodeBetween(String value1, String value2) {
            addCriterion("house_code between", value1, value2, "houseCode");
            return (Criteria) this;
        }

        public Criteria andHouseCodeNotBetween(String value1, String value2) {
            addCriterion("house_code not between", value1, value2, "houseCode");
            return (Criteria) this;
        }

        public Criteria andOriginPriceIsNull() {
            addCriterion("origin_price is null");
            return (Criteria) this;
        }

        public Criteria andOriginPriceIsNotNull() {
            addCriterion("origin_price is not null");
            return (Criteria) this;
        }

        public Criteria andOriginPriceEqualTo(Long value) {
            addCriterion("origin_price =", value, "originPrice");
            return (Criteria) this;
        }

        public Criteria andOriginPriceNotEqualTo(Long value) {
            addCriterion("origin_price <>", value, "originPrice");
            return (Criteria) this;
        }

        public Criteria andOriginPriceGreaterThan(Long value) {
            addCriterion("origin_price >", value, "originPrice");
            return (Criteria) this;
        }

        public Criteria andOriginPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("origin_price >=", value, "originPrice");
            return (Criteria) this;
        }

        public Criteria andOriginPriceLessThan(Long value) {
            addCriterion("origin_price <", value, "originPrice");
            return (Criteria) this;
        }

        public Criteria andOriginPriceLessThanOrEqualTo(Long value) {
            addCriterion("origin_price <=", value, "originPrice");
            return (Criteria) this;
        }

        public Criteria andOriginPriceIn(List<Long> values) {
            addCriterion("origin_price in", values, "originPrice");
            return (Criteria) this;
        }

        public Criteria andOriginPriceNotIn(List<Long> values) {
            addCriterion("origin_price not in", values, "originPrice");
            return (Criteria) this;
        }

        public Criteria andOriginPriceBetween(Long value1, Long value2) {
            addCriterion("origin_price between", value1, value2, "originPrice");
            return (Criteria) this;
        }

        public Criteria andOriginPriceNotBetween(Long value1, Long value2) {
            addCriterion("origin_price not between", value1, value2, "originPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceIsNull() {
            addCriterion("final_price is null");
            return (Criteria) this;
        }

        public Criteria andFinalPriceIsNotNull() {
            addCriterion("final_price is not null");
            return (Criteria) this;
        }

        public Criteria andFinalPriceEqualTo(Long value) {
            addCriterion("final_price =", value, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceNotEqualTo(Long value) {
            addCriterion("final_price <>", value, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceGreaterThan(Long value) {
            addCriterion("final_price >", value, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("final_price >=", value, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceLessThan(Long value) {
            addCriterion("final_price <", value, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceLessThanOrEqualTo(Long value) {
            addCriterion("final_price <=", value, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceIn(List<Long> values) {
            addCriterion("final_price in", values, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceNotIn(List<Long> values) {
            addCriterion("final_price not in", values, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceBetween(Long value1, Long value2) {
            addCriterion("final_price between", value1, value2, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceNotBetween(Long value1, Long value2) {
            addCriterion("final_price not between", value1, value2, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalUnitPriceIsNull() {
            addCriterion("final_unit_price is null");
            return (Criteria) this;
        }

        public Criteria andFinalUnitPriceIsNotNull() {
            addCriterion("final_unit_price is not null");
            return (Criteria) this;
        }

        public Criteria andFinalUnitPriceEqualTo(Long value) {
            addCriterion("final_unit_price =", value, "finalUnitPrice");
            return (Criteria) this;
        }

        public Criteria andFinalUnitPriceNotEqualTo(Long value) {
            addCriterion("final_unit_price <>", value, "finalUnitPrice");
            return (Criteria) this;
        }

        public Criteria andFinalUnitPriceGreaterThan(Long value) {
            addCriterion("final_unit_price >", value, "finalUnitPrice");
            return (Criteria) this;
        }

        public Criteria andFinalUnitPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("final_unit_price >=", value, "finalUnitPrice");
            return (Criteria) this;
        }

        public Criteria andFinalUnitPriceLessThan(Long value) {
            addCriterion("final_unit_price <", value, "finalUnitPrice");
            return (Criteria) this;
        }

        public Criteria andFinalUnitPriceLessThanOrEqualTo(Long value) {
            addCriterion("final_unit_price <=", value, "finalUnitPrice");
            return (Criteria) this;
        }

        public Criteria andFinalUnitPriceIn(List<Long> values) {
            addCriterion("final_unit_price in", values, "finalUnitPrice");
            return (Criteria) this;
        }

        public Criteria andFinalUnitPriceNotIn(List<Long> values) {
            addCriterion("final_unit_price not in", values, "finalUnitPrice");
            return (Criteria) this;
        }

        public Criteria andFinalUnitPriceBetween(Long value1, Long value2) {
            addCriterion("final_unit_price between", value1, value2, "finalUnitPrice");
            return (Criteria) this;
        }

        public Criteria andFinalUnitPriceNotBetween(Long value1, Long value2) {
            addCriterion("final_unit_price not between", value1, value2, "finalUnitPrice");
            return (Criteria) this;
        }

        public Criteria andDealTimeIsNull() {
            addCriterion("deal_time is null");
            return (Criteria) this;
        }

        public Criteria andDealTimeIsNotNull() {
            addCriterion("deal_time is not null");
            return (Criteria) this;
        }

        public Criteria andDealTimeEqualTo(Integer value) {
            addCriterion("deal_time =", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotEqualTo(Integer value) {
            addCriterion("deal_time <>", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeGreaterThan(Integer value) {
            addCriterion("deal_time >", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("deal_time >=", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeLessThan(Integer value) {
            addCriterion("deal_time <", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeLessThanOrEqualTo(Integer value) {
            addCriterion("deal_time <=", value, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeIn(List<Integer> values) {
            addCriterion("deal_time in", values, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotIn(List<Integer> values) {
            addCriterion("deal_time not in", values, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeBetween(Integer value1, Integer value2) {
            addCriterion("deal_time between", value1, value2, "dealTime");
            return (Criteria) this;
        }

        public Criteria andDealTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("deal_time not between", value1, value2, "dealTime");
            return (Criteria) this;
        }

        public Criteria andAdjustCountIsNull() {
            addCriterion("adjust_count is null");
            return (Criteria) this;
        }

        public Criteria andAdjustCountIsNotNull() {
            addCriterion("adjust_count is not null");
            return (Criteria) this;
        }

        public Criteria andAdjustCountEqualTo(Integer value) {
            addCriterion("adjust_count =", value, "adjustCount");
            return (Criteria) this;
        }

        public Criteria andAdjustCountNotEqualTo(Integer value) {
            addCriterion("adjust_count <>", value, "adjustCount");
            return (Criteria) this;
        }

        public Criteria andAdjustCountGreaterThan(Integer value) {
            addCriterion("adjust_count >", value, "adjustCount");
            return (Criteria) this;
        }

        public Criteria andAdjustCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("adjust_count >=", value, "adjustCount");
            return (Criteria) this;
        }

        public Criteria andAdjustCountLessThan(Integer value) {
            addCriterion("adjust_count <", value, "adjustCount");
            return (Criteria) this;
        }

        public Criteria andAdjustCountLessThanOrEqualTo(Integer value) {
            addCriterion("adjust_count <=", value, "adjustCount");
            return (Criteria) this;
        }

        public Criteria andAdjustCountIn(List<Integer> values) {
            addCriterion("adjust_count in", values, "adjustCount");
            return (Criteria) this;
        }

        public Criteria andAdjustCountNotIn(List<Integer> values) {
            addCriterion("adjust_count not in", values, "adjustCount");
            return (Criteria) this;
        }

        public Criteria andAdjustCountBetween(Integer value1, Integer value2) {
            addCriterion("adjust_count between", value1, value2, "adjustCount");
            return (Criteria) this;
        }

        public Criteria andAdjustCountNotBetween(Integer value1, Integer value2) {
            addCriterion("adjust_count not between", value1, value2, "adjustCount");
            return (Criteria) this;
        }

        public Criteria andLookCountIsNull() {
            addCriterion("look_count is null");
            return (Criteria) this;
        }

        public Criteria andLookCountIsNotNull() {
            addCriterion("look_count is not null");
            return (Criteria) this;
        }

        public Criteria andLookCountEqualTo(Integer value) {
            addCriterion("look_count =", value, "lookCount");
            return (Criteria) this;
        }

        public Criteria andLookCountNotEqualTo(Integer value) {
            addCriterion("look_count <>", value, "lookCount");
            return (Criteria) this;
        }

        public Criteria andLookCountGreaterThan(Integer value) {
            addCriterion("look_count >", value, "lookCount");
            return (Criteria) this;
        }

        public Criteria andLookCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("look_count >=", value, "lookCount");
            return (Criteria) this;
        }

        public Criteria andLookCountLessThan(Integer value) {
            addCriterion("look_count <", value, "lookCount");
            return (Criteria) this;
        }

        public Criteria andLookCountLessThanOrEqualTo(Integer value) {
            addCriterion("look_count <=", value, "lookCount");
            return (Criteria) this;
        }

        public Criteria andLookCountIn(List<Integer> values) {
            addCriterion("look_count in", values, "lookCount");
            return (Criteria) this;
        }

        public Criteria andLookCountNotIn(List<Integer> values) {
            addCriterion("look_count not in", values, "lookCount");
            return (Criteria) this;
        }

        public Criteria andLookCountBetween(Integer value1, Integer value2) {
            addCriterion("look_count between", value1, value2, "lookCount");
            return (Criteria) this;
        }

        public Criteria andLookCountNotBetween(Integer value1, Integer value2) {
            addCriterion("look_count not between", value1, value2, "lookCount");
            return (Criteria) this;
        }

        public Criteria andAttentionCountIsNull() {
            addCriterion("attention_count is null");
            return (Criteria) this;
        }

        public Criteria andAttentionCountIsNotNull() {
            addCriterion("attention_count is not null");
            return (Criteria) this;
        }

        public Criteria andAttentionCountEqualTo(Integer value) {
            addCriterion("attention_count =", value, "attentionCount");
            return (Criteria) this;
        }

        public Criteria andAttentionCountNotEqualTo(Integer value) {
            addCriterion("attention_count <>", value, "attentionCount");
            return (Criteria) this;
        }

        public Criteria andAttentionCountGreaterThan(Integer value) {
            addCriterion("attention_count >", value, "attentionCount");
            return (Criteria) this;
        }

        public Criteria andAttentionCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("attention_count >=", value, "attentionCount");
            return (Criteria) this;
        }

        public Criteria andAttentionCountLessThan(Integer value) {
            addCriterion("attention_count <", value, "attentionCount");
            return (Criteria) this;
        }

        public Criteria andAttentionCountLessThanOrEqualTo(Integer value) {
            addCriterion("attention_count <=", value, "attentionCount");
            return (Criteria) this;
        }

        public Criteria andAttentionCountIn(List<Integer> values) {
            addCriterion("attention_count in", values, "attentionCount");
            return (Criteria) this;
        }

        public Criteria andAttentionCountNotIn(List<Integer> values) {
            addCriterion("attention_count not in", values, "attentionCount");
            return (Criteria) this;
        }

        public Criteria andAttentionCountBetween(Integer value1, Integer value2) {
            addCriterion("attention_count between", value1, value2, "attentionCount");
            return (Criteria) this;
        }

        public Criteria andAttentionCountNotBetween(Integer value1, Integer value2) {
            addCriterion("attention_count not between", value1, value2, "attentionCount");
            return (Criteria) this;
        }

        public Criteria andMd5IsNull() {
            addCriterion("md5 is null");
            return (Criteria) this;
        }

        public Criteria andMd5IsNotNull() {
            addCriterion("md5 is not null");
            return (Criteria) this;
        }

        public Criteria andMd5EqualTo(String value) {
            addCriterion("md5 =", value, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5NotEqualTo(String value) {
            addCriterion("md5 <>", value, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5GreaterThan(String value) {
            addCriterion("md5 >", value, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5GreaterThanOrEqualTo(String value) {
            addCriterion("md5 >=", value, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5LessThan(String value) {
            addCriterion("md5 <", value, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5LessThanOrEqualTo(String value) {
            addCriterion("md5 <=", value, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5Like(String value) {
            addCriterion("md5 like", value, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5NotLike(String value) {
            addCriterion("md5 not like", value, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5In(List<String> values) {
            addCriterion("md5 in", values, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5NotIn(List<String> values) {
            addCriterion("md5 not in", values, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5Between(String value1, String value2) {
            addCriterion("md5 between", value1, value2, "md5");
            return (Criteria) this;
        }

        public Criteria andMd5NotBetween(String value1, String value2) {
            addCriterion("md5 not between", value1, value2, "md5");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNull() {
            addCriterion("gmt_modified is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNotNull() {
            addCriterion("gmt_modified is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedEqualTo(Date value) {
            addCriterion("gmt_modified =", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotEqualTo(Date value) {
            addCriterion("gmt_modified <>", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(Date value) {
            addCriterion("gmt_modified >", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modified >=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(Date value) {
            addCriterion("gmt_modified <", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modified <=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIn(List<Date> values) {
            addCriterion("gmt_modified in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotIn(List<Date> values) {
            addCriterion("gmt_modified not in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedBetween(Date value1, Date value2) {
            addCriterion("gmt_modified between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_modified not between", value1, value2, "gmtModified");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
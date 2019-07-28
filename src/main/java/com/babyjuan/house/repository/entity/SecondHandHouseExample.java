package com.babyjuan.house.repository.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SecondHandHouseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SecondHandHouseExample() {
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andBedroomNumIsNull() {
            addCriterion("bedroom_num is null");
            return (Criteria) this;
        }

        public Criteria andBedroomNumIsNotNull() {
            addCriterion("bedroom_num is not null");
            return (Criteria) this;
        }

        public Criteria andBedroomNumEqualTo(Byte value) {
            addCriterion("bedroom_num =", value, "bedroomNum");
            return (Criteria) this;
        }

        public Criteria andBedroomNumNotEqualTo(Byte value) {
            addCriterion("bedroom_num <>", value, "bedroomNum");
            return (Criteria) this;
        }

        public Criteria andBedroomNumGreaterThan(Byte value) {
            addCriterion("bedroom_num >", value, "bedroomNum");
            return (Criteria) this;
        }

        public Criteria andBedroomNumGreaterThanOrEqualTo(Byte value) {
            addCriterion("bedroom_num >=", value, "bedroomNum");
            return (Criteria) this;
        }

        public Criteria andBedroomNumLessThan(Byte value) {
            addCriterion("bedroom_num <", value, "bedroomNum");
            return (Criteria) this;
        }

        public Criteria andBedroomNumLessThanOrEqualTo(Byte value) {
            addCriterion("bedroom_num <=", value, "bedroomNum");
            return (Criteria) this;
        }

        public Criteria andBedroomNumIn(List<Byte> values) {
            addCriterion("bedroom_num in", values, "bedroomNum");
            return (Criteria) this;
        }

        public Criteria andBedroomNumNotIn(List<Byte> values) {
            addCriterion("bedroom_num not in", values, "bedroomNum");
            return (Criteria) this;
        }

        public Criteria andBedroomNumBetween(Byte value1, Byte value2) {
            addCriterion("bedroom_num between", value1, value2, "bedroomNum");
            return (Criteria) this;
        }

        public Criteria andBedroomNumNotBetween(Byte value1, Byte value2) {
            addCriterion("bedroom_num not between", value1, value2, "bedroomNum");
            return (Criteria) this;
        }

        public Criteria andHallNumIsNull() {
            addCriterion("hall_num is null");
            return (Criteria) this;
        }

        public Criteria andHallNumIsNotNull() {
            addCriterion("hall_num is not null");
            return (Criteria) this;
        }

        public Criteria andHallNumEqualTo(Byte value) {
            addCriterion("hall_num =", value, "hallNum");
            return (Criteria) this;
        }

        public Criteria andHallNumNotEqualTo(Byte value) {
            addCriterion("hall_num <>", value, "hallNum");
            return (Criteria) this;
        }

        public Criteria andHallNumGreaterThan(Byte value) {
            addCriterion("hall_num >", value, "hallNum");
            return (Criteria) this;
        }

        public Criteria andHallNumGreaterThanOrEqualTo(Byte value) {
            addCriterion("hall_num >=", value, "hallNum");
            return (Criteria) this;
        }

        public Criteria andHallNumLessThan(Byte value) {
            addCriterion("hall_num <", value, "hallNum");
            return (Criteria) this;
        }

        public Criteria andHallNumLessThanOrEqualTo(Byte value) {
            addCriterion("hall_num <=", value, "hallNum");
            return (Criteria) this;
        }

        public Criteria andHallNumIn(List<Byte> values) {
            addCriterion("hall_num in", values, "hallNum");
            return (Criteria) this;
        }

        public Criteria andHallNumNotIn(List<Byte> values) {
            addCriterion("hall_num not in", values, "hallNum");
            return (Criteria) this;
        }

        public Criteria andHallNumBetween(Byte value1, Byte value2) {
            addCriterion("hall_num between", value1, value2, "hallNum");
            return (Criteria) this;
        }

        public Criteria andHallNumNotBetween(Byte value1, Byte value2) {
            addCriterion("hall_num not between", value1, value2, "hallNum");
            return (Criteria) this;
        }

        public Criteria andOrientationIsNull() {
            addCriterion("orientation is null");
            return (Criteria) this;
        }

        public Criteria andOrientationIsNotNull() {
            addCriterion("orientation is not null");
            return (Criteria) this;
        }

        public Criteria andOrientationEqualTo(String value) {
            addCriterion("orientation =", value, "orientation");
            return (Criteria) this;
        }

        public Criteria andOrientationNotEqualTo(String value) {
            addCriterion("orientation <>", value, "orientation");
            return (Criteria) this;
        }

        public Criteria andOrientationGreaterThan(String value) {
            addCriterion("orientation >", value, "orientation");
            return (Criteria) this;
        }

        public Criteria andOrientationGreaterThanOrEqualTo(String value) {
            addCriterion("orientation >=", value, "orientation");
            return (Criteria) this;
        }

        public Criteria andOrientationLessThan(String value) {
            addCriterion("orientation <", value, "orientation");
            return (Criteria) this;
        }

        public Criteria andOrientationLessThanOrEqualTo(String value) {
            addCriterion("orientation <=", value, "orientation");
            return (Criteria) this;
        }

        public Criteria andOrientationLike(String value) {
            addCriterion("orientation like", value, "orientation");
            return (Criteria) this;
        }

        public Criteria andOrientationNotLike(String value) {
            addCriterion("orientation not like", value, "orientation");
            return (Criteria) this;
        }

        public Criteria andOrientationIn(List<String> values) {
            addCriterion("orientation in", values, "orientation");
            return (Criteria) this;
        }

        public Criteria andOrientationNotIn(List<String> values) {
            addCriterion("orientation not in", values, "orientation");
            return (Criteria) this;
        }

        public Criteria andOrientationBetween(String value1, String value2) {
            addCriterion("orientation between", value1, value2, "orientation");
            return (Criteria) this;
        }

        public Criteria andOrientationNotBetween(String value1, String value2) {
            addCriterion("orientation not between", value1, value2, "orientation");
            return (Criteria) this;
        }

        public Criteria andPriceTotalIsNull() {
            addCriterion("price_total is null");
            return (Criteria) this;
        }

        public Criteria andPriceTotalIsNotNull() {
            addCriterion("price_total is not null");
            return (Criteria) this;
        }

        public Criteria andPriceTotalEqualTo(Integer value) {
            addCriterion("price_total =", value, "priceTotal");
            return (Criteria) this;
        }

        public Criteria andPriceTotalNotEqualTo(Integer value) {
            addCriterion("price_total <>", value, "priceTotal");
            return (Criteria) this;
        }

        public Criteria andPriceTotalGreaterThan(Integer value) {
            addCriterion("price_total >", value, "priceTotal");
            return (Criteria) this;
        }

        public Criteria andPriceTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("price_total >=", value, "priceTotal");
            return (Criteria) this;
        }

        public Criteria andPriceTotalLessThan(Integer value) {
            addCriterion("price_total <", value, "priceTotal");
            return (Criteria) this;
        }

        public Criteria andPriceTotalLessThanOrEqualTo(Integer value) {
            addCriterion("price_total <=", value, "priceTotal");
            return (Criteria) this;
        }

        public Criteria andPriceTotalIn(List<Integer> values) {
            addCriterion("price_total in", values, "priceTotal");
            return (Criteria) this;
        }

        public Criteria andPriceTotalNotIn(List<Integer> values) {
            addCriterion("price_total not in", values, "priceTotal");
            return (Criteria) this;
        }

        public Criteria andPriceTotalBetween(Integer value1, Integer value2) {
            addCriterion("price_total between", value1, value2, "priceTotal");
            return (Criteria) this;
        }

        public Criteria andPriceTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("price_total not between", value1, value2, "priceTotal");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIsNull() {
            addCriterion("unit_price is null");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIsNotNull() {
            addCriterion("unit_price is not null");
            return (Criteria) this;
        }

        public Criteria andUnitPriceEqualTo(Integer value) {
            addCriterion("unit_price =", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotEqualTo(Integer value) {
            addCriterion("unit_price <>", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceGreaterThan(Integer value) {
            addCriterion("unit_price >", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("unit_price >=", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceLessThan(Integer value) {
            addCriterion("unit_price <", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceLessThanOrEqualTo(Integer value) {
            addCriterion("unit_price <=", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIn(List<Integer> values) {
            addCriterion("unit_price in", values, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotIn(List<Integer> values) {
            addCriterion("unit_price not in", values, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceBetween(Integer value1, Integer value2) {
            addCriterion("unit_price between", value1, value2, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("unit_price not between", value1, value2, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(BigDecimal value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(BigDecimal value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(BigDecimal value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(BigDecimal value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<BigDecimal> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<BigDecimal> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andCommunityInfoIdIsNull() {
            addCriterion("community_info_id is null");
            return (Criteria) this;
        }

        public Criteria andCommunityInfoIdIsNotNull() {
            addCriterion("community_info_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommunityInfoIdEqualTo(Long value) {
            addCriterion("community_info_id =", value, "communityInfoId");
            return (Criteria) this;
        }

        public Criteria andCommunityInfoIdNotEqualTo(Long value) {
            addCriterion("community_info_id <>", value, "communityInfoId");
            return (Criteria) this;
        }

        public Criteria andCommunityInfoIdGreaterThan(Long value) {
            addCriterion("community_info_id >", value, "communityInfoId");
            return (Criteria) this;
        }

        public Criteria andCommunityInfoIdGreaterThanOrEqualTo(Long value) {
            addCriterion("community_info_id >=", value, "communityInfoId");
            return (Criteria) this;
        }

        public Criteria andCommunityInfoIdLessThan(Long value) {
            addCriterion("community_info_id <", value, "communityInfoId");
            return (Criteria) this;
        }

        public Criteria andCommunityInfoIdLessThanOrEqualTo(Long value) {
            addCriterion("community_info_id <=", value, "communityInfoId");
            return (Criteria) this;
        }

        public Criteria andCommunityInfoIdIn(List<Long> values) {
            addCriterion("community_info_id in", values, "communityInfoId");
            return (Criteria) this;
        }

        public Criteria andCommunityInfoIdNotIn(List<Long> values) {
            addCriterion("community_info_id not in", values, "communityInfoId");
            return (Criteria) this;
        }

        public Criteria andCommunityInfoIdBetween(Long value1, Long value2) {
            addCriterion("community_info_id between", value1, value2, "communityInfoId");
            return (Criteria) this;
        }

        public Criteria andCommunityInfoIdNotBetween(Long value1, Long value2) {
            addCriterion("community_info_id not between", value1, value2, "communityInfoId");
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

        public Criteria andFromTimeIsNull() {
            addCriterion("from_time is null");
            return (Criteria) this;
        }

        public Criteria andFromTimeIsNotNull() {
            addCriterion("from_time is not null");
            return (Criteria) this;
        }

        public Criteria andFromTimeEqualTo(Date value) {
            addCriterion("from_time =", value, "fromTime");
            return (Criteria) this;
        }

        public Criteria andFromTimeNotEqualTo(Date value) {
            addCriterion("from_time <>", value, "fromTime");
            return (Criteria) this;
        }

        public Criteria andFromTimeGreaterThan(Date value) {
            addCriterion("from_time >", value, "fromTime");
            return (Criteria) this;
        }

        public Criteria andFromTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("from_time >=", value, "fromTime");
            return (Criteria) this;
        }

        public Criteria andFromTimeLessThan(Date value) {
            addCriterion("from_time <", value, "fromTime");
            return (Criteria) this;
        }

        public Criteria andFromTimeLessThanOrEqualTo(Date value) {
            addCriterion("from_time <=", value, "fromTime");
            return (Criteria) this;
        }

        public Criteria andFromTimeIn(List<Date> values) {
            addCriterion("from_time in", values, "fromTime");
            return (Criteria) this;
        }

        public Criteria andFromTimeNotIn(List<Date> values) {
            addCriterion("from_time not in", values, "fromTime");
            return (Criteria) this;
        }

        public Criteria andFromTimeBetween(Date value1, Date value2) {
            addCriterion("from_time between", value1, value2, "fromTime");
            return (Criteria) this;
        }

        public Criteria andFromTimeNotBetween(Date value1, Date value2) {
            addCriterion("from_time not between", value1, value2, "fromTime");
            return (Criteria) this;
        }

        public Criteria andToTimeIsNull() {
            addCriterion("to_time is null");
            return (Criteria) this;
        }

        public Criteria andToTimeIsNotNull() {
            addCriterion("to_time is not null");
            return (Criteria) this;
        }

        public Criteria andToTimeEqualTo(Date value) {
            addCriterion("to_time =", value, "toTime");
            return (Criteria) this;
        }

        public Criteria andToTimeNotEqualTo(Date value) {
            addCriterion("to_time <>", value, "toTime");
            return (Criteria) this;
        }

        public Criteria andToTimeGreaterThan(Date value) {
            addCriterion("to_time >", value, "toTime");
            return (Criteria) this;
        }

        public Criteria andToTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("to_time >=", value, "toTime");
            return (Criteria) this;
        }

        public Criteria andToTimeLessThan(Date value) {
            addCriterion("to_time <", value, "toTime");
            return (Criteria) this;
        }

        public Criteria andToTimeLessThanOrEqualTo(Date value) {
            addCriterion("to_time <=", value, "toTime");
            return (Criteria) this;
        }

        public Criteria andToTimeIn(List<Date> values) {
            addCriterion("to_time in", values, "toTime");
            return (Criteria) this;
        }

        public Criteria andToTimeNotIn(List<Date> values) {
            addCriterion("to_time not in", values, "toTime");
            return (Criteria) this;
        }

        public Criteria andToTimeBetween(Date value1, Date value2) {
            addCriterion("to_time between", value1, value2, "toTime");
            return (Criteria) this;
        }

        public Criteria andToTimeNotBetween(Date value1, Date value2) {
            addCriterion("to_time not between", value1, value2, "toTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
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
package com.babyjuan.house.dao.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RentingHouseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RentingHouseExample() {
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

        public Criteria andHouseSourceIdIsNull() {
            addCriterion("house_source_id is null");
            return (Criteria) this;
        }

        public Criteria andHouseSourceIdIsNotNull() {
            addCriterion("house_source_id is not null");
            return (Criteria) this;
        }

        public Criteria andHouseSourceIdEqualTo(Integer value) {
            addCriterion("house_source_id =", value, "houseSourceId");
            return (Criteria) this;
        }

        public Criteria andHouseSourceIdNotEqualTo(Integer value) {
            addCriterion("house_source_id <>", value, "houseSourceId");
            return (Criteria) this;
        }

        public Criteria andHouseSourceIdGreaterThan(Integer value) {
            addCriterion("house_source_id >", value, "houseSourceId");
            return (Criteria) this;
        }

        public Criteria andHouseSourceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("house_source_id >=", value, "houseSourceId");
            return (Criteria) this;
        }

        public Criteria andHouseSourceIdLessThan(Integer value) {
            addCriterion("house_source_id <", value, "houseSourceId");
            return (Criteria) this;
        }

        public Criteria andHouseSourceIdLessThanOrEqualTo(Integer value) {
            addCriterion("house_source_id <=", value, "houseSourceId");
            return (Criteria) this;
        }

        public Criteria andHouseSourceIdIn(List<Integer> values) {
            addCriterion("house_source_id in", values, "houseSourceId");
            return (Criteria) this;
        }

        public Criteria andHouseSourceIdNotIn(List<Integer> values) {
            addCriterion("house_source_id not in", values, "houseSourceId");
            return (Criteria) this;
        }

        public Criteria andHouseSourceIdBetween(Integer value1, Integer value2) {
            addCriterion("house_source_id between", value1, value2, "houseSourceId");
            return (Criteria) this;
        }

        public Criteria andHouseSourceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("house_source_id not between", value1, value2, "houseSourceId");
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

        public Criteria andRentAreaIsNull() {
            addCriterion("rent_area is null");
            return (Criteria) this;
        }

        public Criteria andRentAreaIsNotNull() {
            addCriterion("rent_area is not null");
            return (Criteria) this;
        }

        public Criteria andRentAreaEqualTo(BigDecimal value) {
            addCriterion("rent_area =", value, "rentArea");
            return (Criteria) this;
        }

        public Criteria andRentAreaNotEqualTo(BigDecimal value) {
            addCriterion("rent_area <>", value, "rentArea");
            return (Criteria) this;
        }

        public Criteria andRentAreaGreaterThan(BigDecimal value) {
            addCriterion("rent_area >", value, "rentArea");
            return (Criteria) this;
        }

        public Criteria andRentAreaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rent_area >=", value, "rentArea");
            return (Criteria) this;
        }

        public Criteria andRentAreaLessThan(BigDecimal value) {
            addCriterion("rent_area <", value, "rentArea");
            return (Criteria) this;
        }

        public Criteria andRentAreaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rent_area <=", value, "rentArea");
            return (Criteria) this;
        }

        public Criteria andRentAreaIn(List<BigDecimal> values) {
            addCriterion("rent_area in", values, "rentArea");
            return (Criteria) this;
        }

        public Criteria andRentAreaNotIn(List<BigDecimal> values) {
            addCriterion("rent_area not in", values, "rentArea");
            return (Criteria) this;
        }

        public Criteria andRentAreaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rent_area between", value1, value2, "rentArea");
            return (Criteria) this;
        }

        public Criteria andRentAreaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rent_area not between", value1, value2, "rentArea");
            return (Criteria) this;
        }

        public Criteria andCommunityIdIsNull() {
            addCriterion("community_id is null");
            return (Criteria) this;
        }

        public Criteria andCommunityIdIsNotNull() {
            addCriterion("community_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommunityIdEqualTo(Long value) {
            addCriterion("community_id =", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdNotEqualTo(Long value) {
            addCriterion("community_id <>", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdGreaterThan(Long value) {
            addCriterion("community_id >", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdGreaterThanOrEqualTo(Long value) {
            addCriterion("community_id >=", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdLessThan(Long value) {
            addCriterion("community_id <", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdLessThanOrEqualTo(Long value) {
            addCriterion("community_id <=", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdIn(List<Long> values) {
            addCriterion("community_id in", values, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdNotIn(List<Long> values) {
            addCriterion("community_id not in", values, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdBetween(Long value1, Long value2) {
            addCriterion("community_id between", value1, value2, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdNotBetween(Long value1, Long value2) {
            addCriterion("community_id not between", value1, value2, "communityId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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

        public Criteria andIsNewIsNull() {
            addCriterion("is_new is null");
            return (Criteria) this;
        }

        public Criteria andIsNewIsNotNull() {
            addCriterion("is_new is not null");
            return (Criteria) this;
        }

        public Criteria andIsNewEqualTo(Boolean value) {
            addCriterion("is_new =", value, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewNotEqualTo(Boolean value) {
            addCriterion("is_new <>", value, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewGreaterThan(Boolean value) {
            addCriterion("is_new >", value, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_new >=", value, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewLessThan(Boolean value) {
            addCriterion("is_new <", value, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewLessThanOrEqualTo(Boolean value) {
            addCriterion("is_new <=", value, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewIn(List<Boolean> values) {
            addCriterion("is_new in", values, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewNotIn(List<Boolean> values) {
            addCriterion("is_new not in", values, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewBetween(Boolean value1, Boolean value2) {
            addCriterion("is_new between", value1, value2, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_new not between", value1, value2, "isNew");
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
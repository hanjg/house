package com.babyjuan.house.repository.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommunityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommunityExample() {
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

        public Criteria andCommunityCodeIsNull() {
            addCriterion("community_code is null");
            return (Criteria) this;
        }

        public Criteria andCommunityCodeIsNotNull() {
            addCriterion("community_code is not null");
            return (Criteria) this;
        }

        public Criteria andCommunityCodeEqualTo(String value) {
            addCriterion("community_code =", value, "communityCode");
            return (Criteria) this;
        }

        public Criteria andCommunityCodeNotEqualTo(String value) {
            addCriterion("community_code <>", value, "communityCode");
            return (Criteria) this;
        }

        public Criteria andCommunityCodeGreaterThan(String value) {
            addCriterion("community_code >", value, "communityCode");
            return (Criteria) this;
        }

        public Criteria andCommunityCodeGreaterThanOrEqualTo(String value) {
            addCriterion("community_code >=", value, "communityCode");
            return (Criteria) this;
        }

        public Criteria andCommunityCodeLessThan(String value) {
            addCriterion("community_code <", value, "communityCode");
            return (Criteria) this;
        }

        public Criteria andCommunityCodeLessThanOrEqualTo(String value) {
            addCriterion("community_code <=", value, "communityCode");
            return (Criteria) this;
        }

        public Criteria andCommunityCodeLike(String value) {
            addCriterion("community_code like", value, "communityCode");
            return (Criteria) this;
        }

        public Criteria andCommunityCodeNotLike(String value) {
            addCriterion("community_code not like", value, "communityCode");
            return (Criteria) this;
        }

        public Criteria andCommunityCodeIn(List<String> values) {
            addCriterion("community_code in", values, "communityCode");
            return (Criteria) this;
        }

        public Criteria andCommunityCodeNotIn(List<String> values) {
            addCriterion("community_code not in", values, "communityCode");
            return (Criteria) this;
        }

        public Criteria andCommunityCodeBetween(String value1, String value2) {
            addCriterion("community_code between", value1, value2, "communityCode");
            return (Criteria) this;
        }

        public Criteria andCommunityCodeNotBetween(String value1, String value2) {
            addCriterion("community_code not between", value1, value2, "communityCode");
            return (Criteria) this;
        }

        public Criteria andCommunityNameIsNull() {
            addCriterion("community_name is null");
            return (Criteria) this;
        }

        public Criteria andCommunityNameIsNotNull() {
            addCriterion("community_name is not null");
            return (Criteria) this;
        }

        public Criteria andCommunityNameEqualTo(String value) {
            addCriterion("community_name =", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameNotEqualTo(String value) {
            addCriterion("community_name <>", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameGreaterThan(String value) {
            addCriterion("community_name >", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameGreaterThanOrEqualTo(String value) {
            addCriterion("community_name >=", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameLessThan(String value) {
            addCriterion("community_name <", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameLessThanOrEqualTo(String value) {
            addCriterion("community_name <=", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameLike(String value) {
            addCriterion("community_name like", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameNotLike(String value) {
            addCriterion("community_name not like", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameIn(List<String> values) {
            addCriterion("community_name in", values, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameNotIn(List<String> values) {
            addCriterion("community_name not in", values, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameBetween(String value1, String value2) {
            addCriterion("community_name between", value1, value2, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameNotBetween(String value1, String value2) {
            addCriterion("community_name not between", value1, value2, "communityName");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(BigDecimal value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(BigDecimal value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(BigDecimal value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(BigDecimal value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<BigDecimal> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<BigDecimal> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("longitude is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("longitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(BigDecimal value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(BigDecimal value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(BigDecimal value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(BigDecimal value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<BigDecimal> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<BigDecimal> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andDistrictIsNull() {
            addCriterion("district is null");
            return (Criteria) this;
        }

        public Criteria andDistrictIsNotNull() {
            addCriterion("district is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictEqualTo(String value) {
            addCriterion("district =", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotEqualTo(String value) {
            addCriterion("district <>", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictGreaterThan(String value) {
            addCriterion("district >", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictGreaterThanOrEqualTo(String value) {
            addCriterion("district >=", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLessThan(String value) {
            addCriterion("district <", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLessThanOrEqualTo(String value) {
            addCriterion("district <=", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLike(String value) {
            addCriterion("district like", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotLike(String value) {
            addCriterion("district not like", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictIn(List<String> values) {
            addCriterion("district in", values, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotIn(List<String> values) {
            addCriterion("district not in", values, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictBetween(String value1, String value2) {
            addCriterion("district between", value1, value2, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotBetween(String value1, String value2) {
            addCriterion("district not between", value1, value2, "district");
            return (Criteria) this;
        }

        public Criteria andBlockIsNull() {
            addCriterion("block is null");
            return (Criteria) this;
        }

        public Criteria andBlockIsNotNull() {
            addCriterion("block is not null");
            return (Criteria) this;
        }

        public Criteria andBlockEqualTo(String value) {
            addCriterion("block =", value, "block");
            return (Criteria) this;
        }

        public Criteria andBlockNotEqualTo(String value) {
            addCriterion("block <>", value, "block");
            return (Criteria) this;
        }

        public Criteria andBlockGreaterThan(String value) {
            addCriterion("block >", value, "block");
            return (Criteria) this;
        }

        public Criteria andBlockGreaterThanOrEqualTo(String value) {
            addCriterion("block >=", value, "block");
            return (Criteria) this;
        }

        public Criteria andBlockLessThan(String value) {
            addCriterion("block <", value, "block");
            return (Criteria) this;
        }

        public Criteria andBlockLessThanOrEqualTo(String value) {
            addCriterion("block <=", value, "block");
            return (Criteria) this;
        }

        public Criteria andBlockLike(String value) {
            addCriterion("block like", value, "block");
            return (Criteria) this;
        }

        public Criteria andBlockNotLike(String value) {
            addCriterion("block not like", value, "block");
            return (Criteria) this;
        }

        public Criteria andBlockIn(List<String> values) {
            addCriterion("block in", values, "block");
            return (Criteria) this;
        }

        public Criteria andBlockNotIn(List<String> values) {
            addCriterion("block not in", values, "block");
            return (Criteria) this;
        }

        public Criteria andBlockBetween(String value1, String value2) {
            addCriterion("block between", value1, value2, "block");
            return (Criteria) this;
        }

        public Criteria andBlockNotBetween(String value1, String value2) {
            addCriterion("block not between", value1, value2, "block");
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
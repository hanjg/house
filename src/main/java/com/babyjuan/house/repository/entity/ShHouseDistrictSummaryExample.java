package com.babyjuan.house.repository.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShHouseDistrictSummaryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShHouseDistrictSummaryExample() {
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

        public Criteria andAvgTotalPriceIsNull() {
            addCriterion("avg_total_price is null");
            return (Criteria) this;
        }

        public Criteria andAvgTotalPriceIsNotNull() {
            addCriterion("avg_total_price is not null");
            return (Criteria) this;
        }

        public Criteria andAvgTotalPriceEqualTo(BigDecimal value) {
            addCriterion("avg_total_price =", value, "avgTotalPrice");
            return (Criteria) this;
        }

        public Criteria andAvgTotalPriceNotEqualTo(BigDecimal value) {
            addCriterion("avg_total_price <>", value, "avgTotalPrice");
            return (Criteria) this;
        }

        public Criteria andAvgTotalPriceGreaterThan(BigDecimal value) {
            addCriterion("avg_total_price >", value, "avgTotalPrice");
            return (Criteria) this;
        }

        public Criteria andAvgTotalPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("avg_total_price >=", value, "avgTotalPrice");
            return (Criteria) this;
        }

        public Criteria andAvgTotalPriceLessThan(BigDecimal value) {
            addCriterion("avg_total_price <", value, "avgTotalPrice");
            return (Criteria) this;
        }

        public Criteria andAvgTotalPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("avg_total_price <=", value, "avgTotalPrice");
            return (Criteria) this;
        }

        public Criteria andAvgTotalPriceIn(List<BigDecimal> values) {
            addCriterion("avg_total_price in", values, "avgTotalPrice");
            return (Criteria) this;
        }

        public Criteria andAvgTotalPriceNotIn(List<BigDecimal> values) {
            addCriterion("avg_total_price not in", values, "avgTotalPrice");
            return (Criteria) this;
        }

        public Criteria andAvgTotalPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("avg_total_price between", value1, value2, "avgTotalPrice");
            return (Criteria) this;
        }

        public Criteria andAvgTotalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("avg_total_price not between", value1, value2, "avgTotalPrice");
            return (Criteria) this;
        }

        public Criteria andAvgUnitPriceIsNull() {
            addCriterion("avg_unit_price is null");
            return (Criteria) this;
        }

        public Criteria andAvgUnitPriceIsNotNull() {
            addCriterion("avg_unit_price is not null");
            return (Criteria) this;
        }

        public Criteria andAvgUnitPriceEqualTo(BigDecimal value) {
            addCriterion("avg_unit_price =", value, "avgUnitPrice");
            return (Criteria) this;
        }

        public Criteria andAvgUnitPriceNotEqualTo(BigDecimal value) {
            addCriterion("avg_unit_price <>", value, "avgUnitPrice");
            return (Criteria) this;
        }

        public Criteria andAvgUnitPriceGreaterThan(BigDecimal value) {
            addCriterion("avg_unit_price >", value, "avgUnitPrice");
            return (Criteria) this;
        }

        public Criteria andAvgUnitPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("avg_unit_price >=", value, "avgUnitPrice");
            return (Criteria) this;
        }

        public Criteria andAvgUnitPriceLessThan(BigDecimal value) {
            addCriterion("avg_unit_price <", value, "avgUnitPrice");
            return (Criteria) this;
        }

        public Criteria andAvgUnitPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("avg_unit_price <=", value, "avgUnitPrice");
            return (Criteria) this;
        }

        public Criteria andAvgUnitPriceIn(List<BigDecimal> values) {
            addCriterion("avg_unit_price in", values, "avgUnitPrice");
            return (Criteria) this;
        }

        public Criteria andAvgUnitPriceNotIn(List<BigDecimal> values) {
            addCriterion("avg_unit_price not in", values, "avgUnitPrice");
            return (Criteria) this;
        }

        public Criteria andAvgUnitPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("avg_unit_price between", value1, value2, "avgUnitPrice");
            return (Criteria) this;
        }

        public Criteria andAvgUnitPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("avg_unit_price not between", value1, value2, "avgUnitPrice");
            return (Criteria) this;
        }

        public Criteria andTotalHouseCountIsNull() {
            addCriterion("total_house_count is null");
            return (Criteria) this;
        }

        public Criteria andTotalHouseCountIsNotNull() {
            addCriterion("total_house_count is not null");
            return (Criteria) this;
        }

        public Criteria andTotalHouseCountEqualTo(String value) {
            addCriterion("total_house_count =", value, "totalHouseCount");
            return (Criteria) this;
        }

        public Criteria andTotalHouseCountNotEqualTo(String value) {
            addCriterion("total_house_count <>", value, "totalHouseCount");
            return (Criteria) this;
        }

        public Criteria andTotalHouseCountGreaterThan(String value) {
            addCriterion("total_house_count >", value, "totalHouseCount");
            return (Criteria) this;
        }

        public Criteria andTotalHouseCountGreaterThanOrEqualTo(String value) {
            addCriterion("total_house_count >=", value, "totalHouseCount");
            return (Criteria) this;
        }

        public Criteria andTotalHouseCountLessThan(String value) {
            addCriterion("total_house_count <", value, "totalHouseCount");
            return (Criteria) this;
        }

        public Criteria andTotalHouseCountLessThanOrEqualTo(String value) {
            addCriterion("total_house_count <=", value, "totalHouseCount");
            return (Criteria) this;
        }

        public Criteria andTotalHouseCountLike(String value) {
            addCriterion("total_house_count like", value, "totalHouseCount");
            return (Criteria) this;
        }

        public Criteria andTotalHouseCountNotLike(String value) {
            addCriterion("total_house_count not like", value, "totalHouseCount");
            return (Criteria) this;
        }

        public Criteria andTotalHouseCountIn(List<String> values) {
            addCriterion("total_house_count in", values, "totalHouseCount");
            return (Criteria) this;
        }

        public Criteria andTotalHouseCountNotIn(List<String> values) {
            addCriterion("total_house_count not in", values, "totalHouseCount");
            return (Criteria) this;
        }

        public Criteria andTotalHouseCountBetween(String value1, String value2) {
            addCriterion("total_house_count between", value1, value2, "totalHouseCount");
            return (Criteria) this;
        }

        public Criteria andTotalHouseCountNotBetween(String value1, String value2) {
            addCriterion("total_house_count not between", value1, value2, "totalHouseCount");
            return (Criteria) this;
        }

        public Criteria andInfoTimeIsNull() {
            addCriterion("info_time is null");
            return (Criteria) this;
        }

        public Criteria andInfoTimeIsNotNull() {
            addCriterion("info_time is not null");
            return (Criteria) this;
        }

        public Criteria andInfoTimeEqualTo(Date value) {
            addCriterion("info_time =", value, "infoTime");
            return (Criteria) this;
        }

        public Criteria andInfoTimeNotEqualTo(Date value) {
            addCriterion("info_time <>", value, "infoTime");
            return (Criteria) this;
        }

        public Criteria andInfoTimeGreaterThan(Date value) {
            addCriterion("info_time >", value, "infoTime");
            return (Criteria) this;
        }

        public Criteria andInfoTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("info_time >=", value, "infoTime");
            return (Criteria) this;
        }

        public Criteria andInfoTimeLessThan(Date value) {
            addCriterion("info_time <", value, "infoTime");
            return (Criteria) this;
        }

        public Criteria andInfoTimeLessThanOrEqualTo(Date value) {
            addCriterion("info_time <=", value, "infoTime");
            return (Criteria) this;
        }

        public Criteria andInfoTimeIn(List<Date> values) {
            addCriterion("info_time in", values, "infoTime");
            return (Criteria) this;
        }

        public Criteria andInfoTimeNotIn(List<Date> values) {
            addCriterion("info_time not in", values, "infoTime");
            return (Criteria) this;
        }

        public Criteria andInfoTimeBetween(Date value1, Date value2) {
            addCriterion("info_time between", value1, value2, "infoTime");
            return (Criteria) this;
        }

        public Criteria andInfoTimeNotBetween(Date value1, Date value2) {
            addCriterion("info_time not between", value1, value2, "infoTime");
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
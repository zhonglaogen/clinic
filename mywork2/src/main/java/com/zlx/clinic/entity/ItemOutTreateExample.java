package com.zlx.clinic.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ItemOutTreateExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table item_out_treate
     *
     * @mbggenerated Sun Jul 07 13:22:00 CST 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table item_out_treate
     *
     * @mbggenerated Sun Jul 07 13:22:00 CST 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table item_out_treate
     *
     * @mbggenerated Sun Jul 07 13:22:00 CST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_out_treate
     *
     * @mbggenerated Sun Jul 07 13:22:00 CST 2019
     */
    public ItemOutTreateExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_out_treate
     *
     * @mbggenerated Sun Jul 07 13:22:00 CST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_out_treate
     *
     * @mbggenerated Sun Jul 07 13:22:00 CST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_out_treate
     *
     * @mbggenerated Sun Jul 07 13:22:00 CST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_out_treate
     *
     * @mbggenerated Sun Jul 07 13:22:00 CST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_out_treate
     *
     * @mbggenerated Sun Jul 07 13:22:00 CST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_out_treate
     *
     * @mbggenerated Sun Jul 07 13:22:00 CST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_out_treate
     *
     * @mbggenerated Sun Jul 07 13:22:00 CST 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_out_treate
     *
     * @mbggenerated Sun Jul 07 13:22:00 CST 2019
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_out_treate
     *
     * @mbggenerated Sun Jul 07 13:22:00 CST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_out_treate
     *
     * @mbggenerated Sun Jul 07 13:22:00 CST 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table item_out_treate
     *
     * @mbggenerated Sun Jul 07 13:22:00 CST 2019
     */
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIIdIsNull() {
            addCriterion("i_id is null");
            return (Criteria) this;
        }

        public Criteria andIIdIsNotNull() {
            addCriterion("i_id is not null");
            return (Criteria) this;
        }

        public Criteria andIIdEqualTo(Integer value) {
            addCriterion("i_id =", value, "iId");
            return (Criteria) this;
        }

        public Criteria andIIdNotEqualTo(Integer value) {
            addCriterion("i_id <>", value, "iId");
            return (Criteria) this;
        }

        public Criteria andIIdGreaterThan(Integer value) {
            addCriterion("i_id >", value, "iId");
            return (Criteria) this;
        }

        public Criteria andIIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("i_id >=", value, "iId");
            return (Criteria) this;
        }

        public Criteria andIIdLessThan(Integer value) {
            addCriterion("i_id <", value, "iId");
            return (Criteria) this;
        }

        public Criteria andIIdLessThanOrEqualTo(Integer value) {
            addCriterion("i_id <=", value, "iId");
            return (Criteria) this;
        }

        public Criteria andIIdIn(List<Integer> values) {
            addCriterion("i_id in", values, "iId");
            return (Criteria) this;
        }

        public Criteria andIIdNotIn(List<Integer> values) {
            addCriterion("i_id not in", values, "iId");
            return (Criteria) this;
        }

        public Criteria andIIdBetween(Integer value1, Integer value2) {
            addCriterion("i_id between", value1, value2, "iId");
            return (Criteria) this;
        }

        public Criteria andIIdNotBetween(Integer value1, Integer value2) {
            addCriterion("i_id not between", value1, value2, "iId");
            return (Criteria) this;
        }

        public Criteria andDIdIsNull() {
            addCriterion("d_id is null");
            return (Criteria) this;
        }

        public Criteria andDIdIsNotNull() {
            addCriterion("d_id is not null");
            return (Criteria) this;
        }

        public Criteria andDIdEqualTo(Integer value) {
            addCriterion("d_id =", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdNotEqualTo(Integer value) {
            addCriterion("d_id <>", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdGreaterThan(Integer value) {
            addCriterion("d_id >", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("d_id >=", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdLessThan(Integer value) {
            addCriterion("d_id <", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdLessThanOrEqualTo(Integer value) {
            addCriterion("d_id <=", value, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdIn(List<Integer> values) {
            addCriterion("d_id in", values, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdNotIn(List<Integer> values) {
            addCriterion("d_id not in", values, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdBetween(Integer value1, Integer value2) {
            addCriterion("d_id between", value1, value2, "dId");
            return (Criteria) this;
        }

        public Criteria andDIdNotBetween(Integer value1, Integer value2) {
            addCriterion("d_id not between", value1, value2, "dId");
            return (Criteria) this;
        }

        public Criteria andDCountIsNull() {
            addCriterion("d_count is null");
            return (Criteria) this;
        }

        public Criteria andDCountIsNotNull() {
            addCriterion("d_count is not null");
            return (Criteria) this;
        }

        public Criteria andDCountEqualTo(Integer value) {
            addCriterion("d_count =", value, "dCount");
            return (Criteria) this;
        }

        public Criteria andDCountNotEqualTo(Integer value) {
            addCriterion("d_count <>", value, "dCount");
            return (Criteria) this;
        }

        public Criteria andDCountGreaterThan(Integer value) {
            addCriterion("d_count >", value, "dCount");
            return (Criteria) this;
        }

        public Criteria andDCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("d_count >=", value, "dCount");
            return (Criteria) this;
        }

        public Criteria andDCountLessThan(Integer value) {
            addCriterion("d_count <", value, "dCount");
            return (Criteria) this;
        }

        public Criteria andDCountLessThanOrEqualTo(Integer value) {
            addCriterion("d_count <=", value, "dCount");
            return (Criteria) this;
        }

        public Criteria andDCountIn(List<Integer> values) {
            addCriterion("d_count in", values, "dCount");
            return (Criteria) this;
        }

        public Criteria andDCountNotIn(List<Integer> values) {
            addCriterion("d_count not in", values, "dCount");
            return (Criteria) this;
        }

        public Criteria andDCountBetween(Integer value1, Integer value2) {
            addCriterion("d_count between", value1, value2, "dCount");
            return (Criteria) this;
        }

        public Criteria andDCountNotBetween(Integer value1, Integer value2) {
            addCriterion("d_count not between", value1, value2, "dCount");
            return (Criteria) this;
        }

        public Criteria andDAllCountIsNull() {
            addCriterion("d_all_count is null");
            return (Criteria) this;
        }

        public Criteria andDAllCountIsNotNull() {
            addCriterion("d_all_count is not null");
            return (Criteria) this;
        }

        public Criteria andDAllCountEqualTo(Integer value) {
            addCriterion("d_all_count =", value, "dAllCount");
            return (Criteria) this;
        }

        public Criteria andDAllCountNotEqualTo(Integer value) {
            addCriterion("d_all_count <>", value, "dAllCount");
            return (Criteria) this;
        }

        public Criteria andDAllCountGreaterThan(Integer value) {
            addCriterion("d_all_count >", value, "dAllCount");
            return (Criteria) this;
        }

        public Criteria andDAllCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("d_all_count >=", value, "dAllCount");
            return (Criteria) this;
        }

        public Criteria andDAllCountLessThan(Integer value) {
            addCriterion("d_all_count <", value, "dAllCount");
            return (Criteria) this;
        }

        public Criteria andDAllCountLessThanOrEqualTo(Integer value) {
            addCriterion("d_all_count <=", value, "dAllCount");
            return (Criteria) this;
        }

        public Criteria andDAllCountIn(List<Integer> values) {
            addCriterion("d_all_count in", values, "dAllCount");
            return (Criteria) this;
        }

        public Criteria andDAllCountNotIn(List<Integer> values) {
            addCriterion("d_all_count not in", values, "dAllCount");
            return (Criteria) this;
        }

        public Criteria andDAllCountBetween(Integer value1, Integer value2) {
            addCriterion("d_all_count between", value1, value2, "dAllCount");
            return (Criteria) this;
        }

        public Criteria andDAllCountNotBetween(Integer value1, Integer value2) {
            addCriterion("d_all_count not between", value1, value2, "dAllCount");
            return (Criteria) this;
        }

        public Criteria andOIdIsNull() {
            addCriterion("o_id is null");
            return (Criteria) this;
        }

        public Criteria andOIdIsNotNull() {
            addCriterion("o_id is not null");
            return (Criteria) this;
        }

        public Criteria andOIdEqualTo(Integer value) {
            addCriterion("o_id =", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdNotEqualTo(Integer value) {
            addCriterion("o_id <>", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdGreaterThan(Integer value) {
            addCriterion("o_id >", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("o_id >=", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdLessThan(Integer value) {
            addCriterion("o_id <", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdLessThanOrEqualTo(Integer value) {
            addCriterion("o_id <=", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdIn(List<Integer> values) {
            addCriterion("o_id in", values, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdNotIn(List<Integer> values) {
            addCriterion("o_id not in", values, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdBetween(Integer value1, Integer value2) {
            addCriterion("o_id between", value1, value2, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdNotBetween(Integer value1, Integer value2) {
            addCriterion("o_id not between", value1, value2, "oId");
            return (Criteria) this;
        }

        public Criteria andIDateIsNull() {
            addCriterion("i_date is null");
            return (Criteria) this;
        }

        public Criteria andIDateIsNotNull() {
            addCriterion("i_date is not null");
            return (Criteria) this;
        }

        public Criteria andIDateEqualTo(Date value) {
            addCriterionForJDBCDate("i_date =", value, "iDate");
            return (Criteria) this;
        }

        public Criteria andIDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("i_date <>", value, "iDate");
            return (Criteria) this;
        }

        public Criteria andIDateGreaterThan(Date value) {
            addCriterionForJDBCDate("i_date >", value, "iDate");
            return (Criteria) this;
        }

        public Criteria andIDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("i_date >=", value, "iDate");
            return (Criteria) this;
        }

        public Criteria andIDateLessThan(Date value) {
            addCriterionForJDBCDate("i_date <", value, "iDate");
            return (Criteria) this;
        }

        public Criteria andIDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("i_date <=", value, "iDate");
            return (Criteria) this;
        }

        public Criteria andIDateIn(List<Date> values) {
            addCriterionForJDBCDate("i_date in", values, "iDate");
            return (Criteria) this;
        }

        public Criteria andIDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("i_date not in", values, "iDate");
            return (Criteria) this;
        }

        public Criteria andIDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("i_date between", value1, value2, "iDate");
            return (Criteria) this;
        }

        public Criteria andIDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("i_date not between", value1, value2, "iDate");
            return (Criteria) this;
        }

        public Criteria andIUpDownIsNull() {
            addCriterion("i_up_down is null");
            return (Criteria) this;
        }

        public Criteria andIUpDownIsNotNull() {
            addCriterion("i_up_down is not null");
            return (Criteria) this;
        }

        public Criteria andIUpDownEqualTo(String value) {
            addCriterion("i_up_down =", value, "iUpDown");
            return (Criteria) this;
        }

        public Criteria andIUpDownNotEqualTo(String value) {
            addCriterion("i_up_down <>", value, "iUpDown");
            return (Criteria) this;
        }

        public Criteria andIUpDownGreaterThan(String value) {
            addCriterion("i_up_down >", value, "iUpDown");
            return (Criteria) this;
        }

        public Criteria andIUpDownGreaterThanOrEqualTo(String value) {
            addCriterion("i_up_down >=", value, "iUpDown");
            return (Criteria) this;
        }

        public Criteria andIUpDownLessThan(String value) {
            addCriterion("i_up_down <", value, "iUpDown");
            return (Criteria) this;
        }

        public Criteria andIUpDownLessThanOrEqualTo(String value) {
            addCriterion("i_up_down <=", value, "iUpDown");
            return (Criteria) this;
        }

        public Criteria andIUpDownLike(String value) {
            addCriterion("i_up_down like", value, "iUpDown");
            return (Criteria) this;
        }

        public Criteria andIUpDownNotLike(String value) {
            addCriterion("i_up_down not like", value, "iUpDown");
            return (Criteria) this;
        }

        public Criteria andIUpDownIn(List<String> values) {
            addCriterion("i_up_down in", values, "iUpDown");
            return (Criteria) this;
        }

        public Criteria andIUpDownNotIn(List<String> values) {
            addCriterion("i_up_down not in", values, "iUpDown");
            return (Criteria) this;
        }

        public Criteria andIUpDownBetween(String value1, String value2) {
            addCriterion("i_up_down between", value1, value2, "iUpDown");
            return (Criteria) this;
        }

        public Criteria andIUpDownNotBetween(String value1, String value2) {
            addCriterion("i_up_down not between", value1, value2, "iUpDown");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table item_out_treate
     *
     * @mbggenerated do_not_delete_during_merge Sun Jul 07 13:22:00 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table item_out_treate
     *
     * @mbggenerated Sun Jul 07 13:22:00 CST 2019
     */
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
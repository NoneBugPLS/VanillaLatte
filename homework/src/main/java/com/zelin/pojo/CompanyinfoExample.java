package com.zelin.pojo;

import java.util.ArrayList;
import java.util.List;

public class CompanyinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompanyinfoExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andCidIsNull() {
            addCriterion("cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(Integer value) {
            addCriterion("cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(Integer value) {
            addCriterion("cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(Integer value) {
            addCriterion("cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(Integer value) {
            addCriterion("cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(Integer value) {
            addCriterion("cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<Integer> values) {
            addCriterion("cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<Integer> values) {
            addCriterion("cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(Integer value1, Integer value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(Integer value1, Integer value2) {
            addCriterion("cid not between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCompnameIsNull() {
            addCriterion("compName is null");
            return (Criteria) this;
        }

        public Criteria andCompnameIsNotNull() {
            addCriterion("compName is not null");
            return (Criteria) this;
        }

        public Criteria andCompnameEqualTo(String value) {
            addCriterion("compName =", value, "compname");
            return (Criteria) this;
        }

        public Criteria andCompnameNotEqualTo(String value) {
            addCriterion("compName <>", value, "compname");
            return (Criteria) this;
        }

        public Criteria andCompnameGreaterThan(String value) {
            addCriterion("compName >", value, "compname");
            return (Criteria) this;
        }

        public Criteria andCompnameGreaterThanOrEqualTo(String value) {
            addCriterion("compName >=", value, "compname");
            return (Criteria) this;
        }

        public Criteria andCompnameLessThan(String value) {
            addCriterion("compName <", value, "compname");
            return (Criteria) this;
        }

        public Criteria andCompnameLessThanOrEqualTo(String value) {
            addCriterion("compName <=", value, "compname");
            return (Criteria) this;
        }

        public Criteria andCompnameLike(String value) {
            addCriterion("compName like", value, "compname");
            return (Criteria) this;
        }

        public Criteria andCompnameNotLike(String value) {
            addCriterion("compName not like", value, "compname");
            return (Criteria) this;
        }

        public Criteria andCompnameIn(List<String> values) {
            addCriterion("compName in", values, "compname");
            return (Criteria) this;
        }

        public Criteria andCompnameNotIn(List<String> values) {
            addCriterion("compName not in", values, "compname");
            return (Criteria) this;
        }

        public Criteria andCompnameBetween(String value1, String value2) {
            addCriterion("compName between", value1, value2, "compname");
            return (Criteria) this;
        }

        public Criteria andCompnameNotBetween(String value1, String value2) {
            addCriterion("compName not between", value1, value2, "compname");
            return (Criteria) this;
        }

        public Criteria andOwnernameIsNull() {
            addCriterion("ownerName is null");
            return (Criteria) this;
        }

        public Criteria andOwnernameIsNotNull() {
            addCriterion("ownerName is not null");
            return (Criteria) this;
        }

        public Criteria andOwnernameEqualTo(String value) {
            addCriterion("ownerName =", value, "ownername");
            return (Criteria) this;
        }

        public Criteria andOwnernameNotEqualTo(String value) {
            addCriterion("ownerName <>", value, "ownername");
            return (Criteria) this;
        }

        public Criteria andOwnernameGreaterThan(String value) {
            addCriterion("ownerName >", value, "ownername");
            return (Criteria) this;
        }

        public Criteria andOwnernameGreaterThanOrEqualTo(String value) {
            addCriterion("ownerName >=", value, "ownername");
            return (Criteria) this;
        }

        public Criteria andOwnernameLessThan(String value) {
            addCriterion("ownerName <", value, "ownername");
            return (Criteria) this;
        }

        public Criteria andOwnernameLessThanOrEqualTo(String value) {
            addCriterion("ownerName <=", value, "ownername");
            return (Criteria) this;
        }

        public Criteria andOwnernameLike(String value) {
            addCriterion("ownerName like", value, "ownername");
            return (Criteria) this;
        }

        public Criteria andOwnernameNotLike(String value) {
            addCriterion("ownerName not like", value, "ownername");
            return (Criteria) this;
        }

        public Criteria andOwnernameIn(List<String> values) {
            addCriterion("ownerName in", values, "ownername");
            return (Criteria) this;
        }

        public Criteria andOwnernameNotIn(List<String> values) {
            addCriterion("ownerName not in", values, "ownername");
            return (Criteria) this;
        }

        public Criteria andOwnernameBetween(String value1, String value2) {
            addCriterion("ownerName between", value1, value2, "ownername");
            return (Criteria) this;
        }

        public Criteria andOwnernameNotBetween(String value1, String value2) {
            addCriterion("ownerName not between", value1, value2, "ownername");
            return (Criteria) this;
        }

        public Criteria andOwnertelIsNull() {
            addCriterion("ownerTel is null");
            return (Criteria) this;
        }

        public Criteria andOwnertelIsNotNull() {
            addCriterion("ownerTel is not null");
            return (Criteria) this;
        }

        public Criteria andOwnertelEqualTo(String value) {
            addCriterion("ownerTel =", value, "ownertel");
            return (Criteria) this;
        }

        public Criteria andOwnertelNotEqualTo(String value) {
            addCriterion("ownerTel <>", value, "ownertel");
            return (Criteria) this;
        }

        public Criteria andOwnertelGreaterThan(String value) {
            addCriterion("ownerTel >", value, "ownertel");
            return (Criteria) this;
        }

        public Criteria andOwnertelGreaterThanOrEqualTo(String value) {
            addCriterion("ownerTel >=", value, "ownertel");
            return (Criteria) this;
        }

        public Criteria andOwnertelLessThan(String value) {
            addCriterion("ownerTel <", value, "ownertel");
            return (Criteria) this;
        }

        public Criteria andOwnertelLessThanOrEqualTo(String value) {
            addCriterion("ownerTel <=", value, "ownertel");
            return (Criteria) this;
        }

        public Criteria andOwnertelLike(String value) {
            addCriterion("ownerTel like", value, "ownertel");
            return (Criteria) this;
        }

        public Criteria andOwnertelNotLike(String value) {
            addCriterion("ownerTel not like", value, "ownertel");
            return (Criteria) this;
        }

        public Criteria andOwnertelIn(List<String> values) {
            addCriterion("ownerTel in", values, "ownertel");
            return (Criteria) this;
        }

        public Criteria andOwnertelNotIn(List<String> values) {
            addCriterion("ownerTel not in", values, "ownertel");
            return (Criteria) this;
        }

        public Criteria andOwnertelBetween(String value1, String value2) {
            addCriterion("ownerTel between", value1, value2, "ownertel");
            return (Criteria) this;
        }

        public Criteria andOwnertelNotBetween(String value1, String value2) {
            addCriterion("ownerTel not between", value1, value2, "ownertel");
            return (Criteria) this;
        }

        public Criteria andCompinfoIsNull() {
            addCriterion("compInfo is null");
            return (Criteria) this;
        }

        public Criteria andCompinfoIsNotNull() {
            addCriterion("compInfo is not null");
            return (Criteria) this;
        }

        public Criteria andCompinfoEqualTo(String value) {
            addCriterion("compInfo =", value, "compinfo");
            return (Criteria) this;
        }

        public Criteria andCompinfoNotEqualTo(String value) {
            addCriterion("compInfo <>", value, "compinfo");
            return (Criteria) this;
        }

        public Criteria andCompinfoGreaterThan(String value) {
            addCriterion("compInfo >", value, "compinfo");
            return (Criteria) this;
        }

        public Criteria andCompinfoGreaterThanOrEqualTo(String value) {
            addCriterion("compInfo >=", value, "compinfo");
            return (Criteria) this;
        }

        public Criteria andCompinfoLessThan(String value) {
            addCriterion("compInfo <", value, "compinfo");
            return (Criteria) this;
        }

        public Criteria andCompinfoLessThanOrEqualTo(String value) {
            addCriterion("compInfo <=", value, "compinfo");
            return (Criteria) this;
        }

        public Criteria andCompinfoLike(String value) {
            addCriterion("compInfo like", value, "compinfo");
            return (Criteria) this;
        }

        public Criteria andCompinfoNotLike(String value) {
            addCriterion("compInfo not like", value, "compinfo");
            return (Criteria) this;
        }

        public Criteria andCompinfoIn(List<String> values) {
            addCriterion("compInfo in", values, "compinfo");
            return (Criteria) this;
        }

        public Criteria andCompinfoNotIn(List<String> values) {
            addCriterion("compInfo not in", values, "compinfo");
            return (Criteria) this;
        }

        public Criteria andCompinfoBetween(String value1, String value2) {
            addCriterion("compInfo between", value1, value2, "compinfo");
            return (Criteria) this;
        }

        public Criteria andCompinfoNotBetween(String value1, String value2) {
            addCriterion("compInfo not between", value1, value2, "compinfo");
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
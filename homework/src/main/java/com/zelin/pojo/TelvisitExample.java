package com.zelin.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TelvisitExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TelvisitExample() {
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

        public Criteria andTvidIsNull() {
            addCriterion("tvId is null");
            return (Criteria) this;
        }

        public Criteria andTvidIsNotNull() {
            addCriterion("tvId is not null");
            return (Criteria) this;
        }

        public Criteria andTvidEqualTo(Integer value) {
            addCriterion("tvId =", value, "tvid");
            return (Criteria) this;
        }

        public Criteria andTvidNotEqualTo(Integer value) {
            addCriterion("tvId <>", value, "tvid");
            return (Criteria) this;
        }

        public Criteria andTvidGreaterThan(Integer value) {
            addCriterion("tvId >", value, "tvid");
            return (Criteria) this;
        }

        public Criteria andTvidGreaterThanOrEqualTo(Integer value) {
            addCriterion("tvId >=", value, "tvid");
            return (Criteria) this;
        }

        public Criteria andTvidLessThan(Integer value) {
            addCriterion("tvId <", value, "tvid");
            return (Criteria) this;
        }

        public Criteria andTvidLessThanOrEqualTo(Integer value) {
            addCriterion("tvId <=", value, "tvid");
            return (Criteria) this;
        }

        public Criteria andTvidIn(List<Integer> values) {
            addCriterion("tvId in", values, "tvid");
            return (Criteria) this;
        }

        public Criteria andTvidNotIn(List<Integer> values) {
            addCriterion("tvId not in", values, "tvid");
            return (Criteria) this;
        }

        public Criteria andTvidBetween(Integer value1, Integer value2) {
            addCriterion("tvId between", value1, value2, "tvid");
            return (Criteria) this;
        }

        public Criteria andTvidNotBetween(Integer value1, Integer value2) {
            addCriterion("tvId not between", value1, value2, "tvid");
            return (Criteria) this;
        }

        public Criteria andTelnameIsNull() {
            addCriterion("telName is null");
            return (Criteria) this;
        }

        public Criteria andTelnameIsNotNull() {
            addCriterion("telName is not null");
            return (Criteria) this;
        }

        public Criteria andTelnameEqualTo(String value) {
            addCriterion("telName =", value, "telname");
            return (Criteria) this;
        }

        public Criteria andTelnameNotEqualTo(String value) {
            addCriterion("telName <>", value, "telname");
            return (Criteria) this;
        }

        public Criteria andTelnameGreaterThan(String value) {
            addCriterion("telName >", value, "telname");
            return (Criteria) this;
        }

        public Criteria andTelnameGreaterThanOrEqualTo(String value) {
            addCriterion("telName >=", value, "telname");
            return (Criteria) this;
        }

        public Criteria andTelnameLessThan(String value) {
            addCriterion("telName <", value, "telname");
            return (Criteria) this;
        }

        public Criteria andTelnameLessThanOrEqualTo(String value) {
            addCriterion("telName <=", value, "telname");
            return (Criteria) this;
        }

        public Criteria andTelnameLike(String value) {
            addCriterion("telName like", value, "telname");
            return (Criteria) this;
        }

        public Criteria andTelnameNotLike(String value) {
            addCriterion("telName not like", value, "telname");
            return (Criteria) this;
        }

        public Criteria andTelnameIn(List<String> values) {
            addCriterion("telName in", values, "telname");
            return (Criteria) this;
        }

        public Criteria andTelnameNotIn(List<String> values) {
            addCriterion("telName not in", values, "telname");
            return (Criteria) this;
        }

        public Criteria andTelnameBetween(String value1, String value2) {
            addCriterion("telName between", value1, value2, "telname");
            return (Criteria) this;
        }

        public Criteria andTelnameNotBetween(String value1, String value2) {
            addCriterion("telName not between", value1, value2, "telname");
            return (Criteria) this;
        }

        public Criteria andTeltimeIsNull() {
            addCriterion("telTime is null");
            return (Criteria) this;
        }

        public Criteria andTeltimeIsNotNull() {
            addCriterion("telTime is not null");
            return (Criteria) this;
        }

        public Criteria andTeltimeEqualTo(Date value) {
            addCriterion("telTime =", value, "teltime");
            return (Criteria) this;
        }

        public Criteria andTeltimeNotEqualTo(Date value) {
            addCriterion("telTime <>", value, "teltime");
            return (Criteria) this;
        }

        public Criteria andTeltimeGreaterThan(Date value) {
            addCriterion("telTime >", value, "teltime");
            return (Criteria) this;
        }

        public Criteria andTeltimeGreaterThanOrEqualTo(Date value) {
            addCriterion("telTime >=", value, "teltime");
            return (Criteria) this;
        }

        public Criteria andTeltimeLessThan(Date value) {
            addCriterion("telTime <", value, "teltime");
            return (Criteria) this;
        }

        public Criteria andTeltimeLessThanOrEqualTo(Date value) {
            addCriterion("telTime <=", value, "teltime");
            return (Criteria) this;
        }

        public Criteria andTeltimeIn(List<Date> values) {
            addCriterion("telTime in", values, "teltime");
            return (Criteria) this;
        }

        public Criteria andTeltimeNotIn(List<Date> values) {
            addCriterion("telTime not in", values, "teltime");
            return (Criteria) this;
        }

        public Criteria andTeltimeBetween(Date value1, Date value2) {
            addCriterion("telTime between", value1, value2, "teltime");
            return (Criteria) this;
        }

        public Criteria andTeltimeNotBetween(Date value1, Date value2) {
            addCriterion("telTime not between", value1, value2, "teltime");
            return (Criteria) this;
        }

        public Criteria andVisitreasonIsNull() {
            addCriterion("visitReason is null");
            return (Criteria) this;
        }

        public Criteria andVisitreasonIsNotNull() {
            addCriterion("visitReason is not null");
            return (Criteria) this;
        }

        public Criteria andVisitreasonEqualTo(String value) {
            addCriterion("visitReason =", value, "visitreason");
            return (Criteria) this;
        }

        public Criteria andVisitreasonNotEqualTo(String value) {
            addCriterion("visitReason <>", value, "visitreason");
            return (Criteria) this;
        }

        public Criteria andVisitreasonGreaterThan(String value) {
            addCriterion("visitReason >", value, "visitreason");
            return (Criteria) this;
        }

        public Criteria andVisitreasonGreaterThanOrEqualTo(String value) {
            addCriterion("visitReason >=", value, "visitreason");
            return (Criteria) this;
        }

        public Criteria andVisitreasonLessThan(String value) {
            addCriterion("visitReason <", value, "visitreason");
            return (Criteria) this;
        }

        public Criteria andVisitreasonLessThanOrEqualTo(String value) {
            addCriterion("visitReason <=", value, "visitreason");
            return (Criteria) this;
        }

        public Criteria andVisitreasonLike(String value) {
            addCriterion("visitReason like", value, "visitreason");
            return (Criteria) this;
        }

        public Criteria andVisitreasonNotLike(String value) {
            addCriterion("visitReason not like", value, "visitreason");
            return (Criteria) this;
        }

        public Criteria andVisitreasonIn(List<String> values) {
            addCriterion("visitReason in", values, "visitreason");
            return (Criteria) this;
        }

        public Criteria andVisitreasonNotIn(List<String> values) {
            addCriterion("visitReason not in", values, "visitreason");
            return (Criteria) this;
        }

        public Criteria andVisitreasonBetween(String value1, String value2) {
            addCriterion("visitReason between", value1, value2, "visitreason");
            return (Criteria) this;
        }

        public Criteria andVisitreasonNotBetween(String value1, String value2) {
            addCriterion("visitReason not between", value1, value2, "visitreason");
            return (Criteria) this;
        }

        public Criteria andVisitreturnIsNull() {
            addCriterion("visitReturn is null");
            return (Criteria) this;
        }

        public Criteria andVisitreturnIsNotNull() {
            addCriterion("visitReturn is not null");
            return (Criteria) this;
        }

        public Criteria andVisitreturnEqualTo(String value) {
            addCriterion("visitReturn =", value, "visitreturn");
            return (Criteria) this;
        }

        public Criteria andVisitreturnNotEqualTo(String value) {
            addCriterion("visitReturn <>", value, "visitreturn");
            return (Criteria) this;
        }

        public Criteria andVisitreturnGreaterThan(String value) {
            addCriterion("visitReturn >", value, "visitreturn");
            return (Criteria) this;
        }

        public Criteria andVisitreturnGreaterThanOrEqualTo(String value) {
            addCriterion("visitReturn >=", value, "visitreturn");
            return (Criteria) this;
        }

        public Criteria andVisitreturnLessThan(String value) {
            addCriterion("visitReturn <", value, "visitreturn");
            return (Criteria) this;
        }

        public Criteria andVisitreturnLessThanOrEqualTo(String value) {
            addCriterion("visitReturn <=", value, "visitreturn");
            return (Criteria) this;
        }

        public Criteria andVisitreturnLike(String value) {
            addCriterion("visitReturn like", value, "visitreturn");
            return (Criteria) this;
        }

        public Criteria andVisitreturnNotLike(String value) {
            addCriterion("visitReturn not like", value, "visitreturn");
            return (Criteria) this;
        }

        public Criteria andVisitreturnIn(List<String> values) {
            addCriterion("visitReturn in", values, "visitreturn");
            return (Criteria) this;
        }

        public Criteria andVisitreturnNotIn(List<String> values) {
            addCriterion("visitReturn not in", values, "visitreturn");
            return (Criteria) this;
        }

        public Criteria andVisitreturnBetween(String value1, String value2) {
            addCriterion("visitReturn between", value1, value2, "visitreturn");
            return (Criteria) this;
        }

        public Criteria andVisitreturnNotBetween(String value1, String value2) {
            addCriterion("visitReturn not between", value1, value2, "visitreturn");
            return (Criteria) this;
        }

        public Criteria andVisittypeIsNull() {
            addCriterion("visitType is null");
            return (Criteria) this;
        }

        public Criteria andVisittypeIsNotNull() {
            addCriterion("visitType is not null");
            return (Criteria) this;
        }

        public Criteria andVisittypeEqualTo(String value) {
            addCriterion("visitType =", value, "visittype");
            return (Criteria) this;
        }

        public Criteria andVisittypeNotEqualTo(String value) {
            addCriterion("visitType <>", value, "visittype");
            return (Criteria) this;
        }

        public Criteria andVisittypeGreaterThan(String value) {
            addCriterion("visitType >", value, "visittype");
            return (Criteria) this;
        }

        public Criteria andVisittypeGreaterThanOrEqualTo(String value) {
            addCriterion("visitType >=", value, "visittype");
            return (Criteria) this;
        }

        public Criteria andVisittypeLessThan(String value) {
            addCriterion("visitType <", value, "visittype");
            return (Criteria) this;
        }

        public Criteria andVisittypeLessThanOrEqualTo(String value) {
            addCriterion("visitType <=", value, "visittype");
            return (Criteria) this;
        }

        public Criteria andVisittypeLike(String value) {
            addCriterion("visitType like", value, "visittype");
            return (Criteria) this;
        }

        public Criteria andVisittypeNotLike(String value) {
            addCriterion("visitType not like", value, "visittype");
            return (Criteria) this;
        }

        public Criteria andVisittypeIn(List<String> values) {
            addCriterion("visitType in", values, "visittype");
            return (Criteria) this;
        }

        public Criteria andVisittypeNotIn(List<String> values) {
            addCriterion("visitType not in", values, "visittype");
            return (Criteria) this;
        }

        public Criteria andVisittypeBetween(String value1, String value2) {
            addCriterion("visitType between", value1, value2, "visittype");
            return (Criteria) this;
        }

        public Criteria andVisittypeNotBetween(String value1, String value2) {
            addCriterion("visitType not between", value1, value2, "visittype");
            return (Criteria) this;
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
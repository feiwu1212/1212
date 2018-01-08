package com.crfchina.cdg.basedb.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SystemStatusCodeMetadataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SystemStatusCodeMetadataExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCodeNoIsNull() {
            addCriterion("code_no is null");
            return (Criteria) this;
        }

        public Criteria andCodeNoIsNotNull() {
            addCriterion("code_no is not null");
            return (Criteria) this;
        }

        public Criteria andCodeNoEqualTo(String value) {
            addCriterion("code_no =", value, "codeNo");
            return (Criteria) this;
        }

        public Criteria andCodeNoNotEqualTo(String value) {
            addCriterion("code_no <>", value, "codeNo");
            return (Criteria) this;
        }

        public Criteria andCodeNoGreaterThan(String value) {
            addCriterion("code_no >", value, "codeNo");
            return (Criteria) this;
        }

        public Criteria andCodeNoGreaterThanOrEqualTo(String value) {
            addCriterion("code_no >=", value, "codeNo");
            return (Criteria) this;
        }

        public Criteria andCodeNoLessThan(String value) {
            addCriterion("code_no <", value, "codeNo");
            return (Criteria) this;
        }

        public Criteria andCodeNoLessThanOrEqualTo(String value) {
            addCriterion("code_no <=", value, "codeNo");
            return (Criteria) this;
        }

        public Criteria andCodeNoLike(String value) {
            addCriterion("code_no like", value, "codeNo");
            return (Criteria) this;
        }

        public Criteria andCodeNoNotLike(String value) {
            addCriterion("code_no not like", value, "codeNo");
            return (Criteria) this;
        }

        public Criteria andCodeNoIn(List<String> values) {
            addCriterion("code_no in", values, "codeNo");
            return (Criteria) this;
        }

        public Criteria andCodeNoNotIn(List<String> values) {
            addCriterion("code_no not in", values, "codeNo");
            return (Criteria) this;
        }

        public Criteria andCodeNoBetween(String value1, String value2) {
            addCriterion("code_no between", value1, value2, "codeNo");
            return (Criteria) this;
        }

        public Criteria andCodeNoNotBetween(String value1, String value2) {
            addCriterion("code_no not between", value1, value2, "codeNo");
            return (Criteria) this;
        }

        public Criteria andChannelInfoNoIsNull() {
            addCriterion("channel_info_no is null");
            return (Criteria) this;
        }

        public Criteria andChannelInfoNoIsNotNull() {
            addCriterion("channel_info_no is not null");
            return (Criteria) this;
        }

        public Criteria andChannelInfoNoEqualTo(String value) {
            addCriterion("channel_info_no =", value, "channelInfoNo");
            return (Criteria) this;
        }

        public Criteria andChannelInfoNoNotEqualTo(String value) {
            addCriterion("channel_info_no <>", value, "channelInfoNo");
            return (Criteria) this;
        }

        public Criteria andChannelInfoNoGreaterThan(String value) {
            addCriterion("channel_info_no >", value, "channelInfoNo");
            return (Criteria) this;
        }

        public Criteria andChannelInfoNoGreaterThanOrEqualTo(String value) {
            addCriterion("channel_info_no >=", value, "channelInfoNo");
            return (Criteria) this;
        }

        public Criteria andChannelInfoNoLessThan(String value) {
            addCriterion("channel_info_no <", value, "channelInfoNo");
            return (Criteria) this;
        }

        public Criteria andChannelInfoNoLessThanOrEqualTo(String value) {
            addCriterion("channel_info_no <=", value, "channelInfoNo");
            return (Criteria) this;
        }

        public Criteria andChannelInfoNoLike(String value) {
            addCriterion("channel_info_no like", value, "channelInfoNo");
            return (Criteria) this;
        }

        public Criteria andChannelInfoNoNotLike(String value) {
            addCriterion("channel_info_no not like", value, "channelInfoNo");
            return (Criteria) this;
        }

        public Criteria andChannelInfoNoIn(List<String> values) {
            addCriterion("channel_info_no in", values, "channelInfoNo");
            return (Criteria) this;
        }

        public Criteria andChannelInfoNoNotIn(List<String> values) {
            addCriterion("channel_info_no not in", values, "channelInfoNo");
            return (Criteria) this;
        }

        public Criteria andChannelInfoNoBetween(String value1, String value2) {
            addCriterion("channel_info_no between", value1, value2, "channelInfoNo");
            return (Criteria) this;
        }

        public Criteria andChannelInfoNoNotBetween(String value1, String value2) {
            addCriterion("channel_info_no not between", value1, value2, "channelInfoNo");
            return (Criteria) this;
        }

        public Criteria andStatusReportIsNull() {
            addCriterion("status_report is null");
            return (Criteria) this;
        }

        public Criteria andStatusReportIsNotNull() {
            addCriterion("status_report is not null");
            return (Criteria) this;
        }

        public Criteria andStatusReportEqualTo(String value) {
            addCriterion("status_report =", value, "statusReport");
            return (Criteria) this;
        }

        public Criteria andStatusReportNotEqualTo(String value) {
            addCriterion("status_report <>", value, "statusReport");
            return (Criteria) this;
        }

        public Criteria andStatusReportGreaterThan(String value) {
            addCriterion("status_report >", value, "statusReport");
            return (Criteria) this;
        }

        public Criteria andStatusReportGreaterThanOrEqualTo(String value) {
            addCriterion("status_report >=", value, "statusReport");
            return (Criteria) this;
        }

        public Criteria andStatusReportLessThan(String value) {
            addCriterion("status_report <", value, "statusReport");
            return (Criteria) this;
        }

        public Criteria andStatusReportLessThanOrEqualTo(String value) {
            addCriterion("status_report <=", value, "statusReport");
            return (Criteria) this;
        }

        public Criteria andStatusReportLike(String value) {
            addCriterion("status_report like", value, "statusReport");
            return (Criteria) this;
        }

        public Criteria andStatusReportNotLike(String value) {
            addCriterion("status_report not like", value, "statusReport");
            return (Criteria) this;
        }

        public Criteria andStatusReportIn(List<String> values) {
            addCriterion("status_report in", values, "statusReport");
            return (Criteria) this;
        }

        public Criteria andStatusReportNotIn(List<String> values) {
            addCriterion("status_report not in", values, "statusReport");
            return (Criteria) this;
        }

        public Criteria andStatusReportBetween(String value1, String value2) {
            addCriterion("status_report between", value1, value2, "statusReport");
            return (Criteria) this;
        }

        public Criteria andStatusReportNotBetween(String value1, String value2) {
            addCriterion("status_report not between", value1, value2, "statusReport");
            return (Criteria) this;
        }

        public Criteria andStatusReportExplainIsNull() {
            addCriterion("status_report_explain is null");
            return (Criteria) this;
        }

        public Criteria andStatusReportExplainIsNotNull() {
            addCriterion("status_report_explain is not null");
            return (Criteria) this;
        }

        public Criteria andStatusReportExplainEqualTo(String value) {
            addCriterion("status_report_explain =", value, "statusReportExplain");
            return (Criteria) this;
        }

        public Criteria andStatusReportExplainNotEqualTo(String value) {
            addCriterion("status_report_explain <>", value, "statusReportExplain");
            return (Criteria) this;
        }

        public Criteria andStatusReportExplainGreaterThan(String value) {
            addCriterion("status_report_explain >", value, "statusReportExplain");
            return (Criteria) this;
        }

        public Criteria andStatusReportExplainGreaterThanOrEqualTo(String value) {
            addCriterion("status_report_explain >=", value, "statusReportExplain");
            return (Criteria) this;
        }

        public Criteria andStatusReportExplainLessThan(String value) {
            addCriterion("status_report_explain <", value, "statusReportExplain");
            return (Criteria) this;
        }

        public Criteria andStatusReportExplainLessThanOrEqualTo(String value) {
            addCriterion("status_report_explain <=", value, "statusReportExplain");
            return (Criteria) this;
        }

        public Criteria andStatusReportExplainLike(String value) {
            addCriterion("status_report_explain like", value, "statusReportExplain");
            return (Criteria) this;
        }

        public Criteria andStatusReportExplainNotLike(String value) {
            addCriterion("status_report_explain not like", value, "statusReportExplain");
            return (Criteria) this;
        }

        public Criteria andStatusReportExplainIn(List<String> values) {
            addCriterion("status_report_explain in", values, "statusReportExplain");
            return (Criteria) this;
        }

        public Criteria andStatusReportExplainNotIn(List<String> values) {
            addCriterion("status_report_explain not in", values, "statusReportExplain");
            return (Criteria) this;
        }

        public Criteria andStatusReportExplainBetween(String value1, String value2) {
            addCriterion("status_report_explain between", value1, value2, "statusReportExplain");
            return (Criteria) this;
        }

        public Criteria andStatusReportExplainNotBetween(String value1, String value2) {
            addCriterion("status_report_explain not between", value1, value2, "statusReportExplain");
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
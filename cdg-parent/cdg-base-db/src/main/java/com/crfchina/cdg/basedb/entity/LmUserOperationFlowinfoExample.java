package com.crfchina.cdg.basedb.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LmUserOperationFlowinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LmUserOperationFlowinfoExample() {
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

        public Criteria andIdEqualTo(Boolean value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Boolean value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Boolean value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Boolean value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Boolean value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Boolean value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Boolean> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Boolean> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Boolean value1, Boolean value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Boolean value1, Boolean value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFcpTrxNoIsNull() {
            addCriterion("fcp_trx_no is null");
            return (Criteria) this;
        }

        public Criteria andFcpTrxNoIsNotNull() {
            addCriterion("fcp_trx_no is not null");
            return (Criteria) this;
        }

        public Criteria andFcpTrxNoEqualTo(String value) {
            addCriterion("fcp_trx_no =", value, "fcpTrxNo");
            return (Criteria) this;
        }

        public Criteria andFcpTrxNoNotEqualTo(String value) {
            addCriterion("fcp_trx_no <>", value, "fcpTrxNo");
            return (Criteria) this;
        }

        public Criteria andFcpTrxNoGreaterThan(String value) {
            addCriterion("fcp_trx_no >", value, "fcpTrxNo");
            return (Criteria) this;
        }

        public Criteria andFcpTrxNoGreaterThanOrEqualTo(String value) {
            addCriterion("fcp_trx_no >=", value, "fcpTrxNo");
            return (Criteria) this;
        }

        public Criteria andFcpTrxNoLessThan(String value) {
            addCriterion("fcp_trx_no <", value, "fcpTrxNo");
            return (Criteria) this;
        }

        public Criteria andFcpTrxNoLessThanOrEqualTo(String value) {
            addCriterion("fcp_trx_no <=", value, "fcpTrxNo");
            return (Criteria) this;
        }

        public Criteria andFcpTrxNoLike(String value) {
            addCriterion("fcp_trx_no like", value, "fcpTrxNo");
            return (Criteria) this;
        }

        public Criteria andFcpTrxNoNotLike(String value) {
            addCriterion("fcp_trx_no not like", value, "fcpTrxNo");
            return (Criteria) this;
        }

        public Criteria andFcpTrxNoIn(List<String> values) {
            addCriterion("fcp_trx_no in", values, "fcpTrxNo");
            return (Criteria) this;
        }

        public Criteria andFcpTrxNoNotIn(List<String> values) {
            addCriterion("fcp_trx_no not in", values, "fcpTrxNo");
            return (Criteria) this;
        }

        public Criteria andFcpTrxNoBetween(String value1, String value2) {
            addCriterion("fcp_trx_no between", value1, value2, "fcpTrxNo");
            return (Criteria) this;
        }

        public Criteria andFcpTrxNoNotBetween(String value1, String value2) {
            addCriterion("fcp_trx_no not between", value1, value2, "fcpTrxNo");
            return (Criteria) this;
        }

        public Criteria andRequestRefNoIsNull() {
            addCriterion("request_ref_no is null");
            return (Criteria) this;
        }

        public Criteria andRequestRefNoIsNotNull() {
            addCriterion("request_ref_no is not null");
            return (Criteria) this;
        }

        public Criteria andRequestRefNoEqualTo(String value) {
            addCriterion("request_ref_no =", value, "requestRefNo");
            return (Criteria) this;
        }

        public Criteria andRequestRefNoNotEqualTo(String value) {
            addCriterion("request_ref_no <>", value, "requestRefNo");
            return (Criteria) this;
        }

        public Criteria andRequestRefNoGreaterThan(String value) {
            addCriterion("request_ref_no >", value, "requestRefNo");
            return (Criteria) this;
        }

        public Criteria andRequestRefNoGreaterThanOrEqualTo(String value) {
            addCriterion("request_ref_no >=", value, "requestRefNo");
            return (Criteria) this;
        }

        public Criteria andRequestRefNoLessThan(String value) {
            addCriterion("request_ref_no <", value, "requestRefNo");
            return (Criteria) this;
        }

        public Criteria andRequestRefNoLessThanOrEqualTo(String value) {
            addCriterion("request_ref_no <=", value, "requestRefNo");
            return (Criteria) this;
        }

        public Criteria andRequestRefNoLike(String value) {
            addCriterion("request_ref_no like", value, "requestRefNo");
            return (Criteria) this;
        }

        public Criteria andRequestRefNoNotLike(String value) {
            addCriterion("request_ref_no not like", value, "requestRefNo");
            return (Criteria) this;
        }

        public Criteria andRequestRefNoIn(List<String> values) {
            addCriterion("request_ref_no in", values, "requestRefNo");
            return (Criteria) this;
        }

        public Criteria andRequestRefNoNotIn(List<String> values) {
            addCriterion("request_ref_no not in", values, "requestRefNo");
            return (Criteria) this;
        }

        public Criteria andRequestRefNoBetween(String value1, String value2) {
            addCriterion("request_ref_no between", value1, value2, "requestRefNo");
            return (Criteria) this;
        }

        public Criteria andRequestRefNoNotBetween(String value1, String value2) {
            addCriterion("request_ref_no not between", value1, value2, "requestRefNo");
            return (Criteria) this;
        }

        public Criteria andRequestTimeIsNull() {
            addCriterion("request_time is null");
            return (Criteria) this;
        }

        public Criteria andRequestTimeIsNotNull() {
            addCriterion("request_time is not null");
            return (Criteria) this;
        }

        public Criteria andRequestTimeEqualTo(Date value) {
            addCriterion("request_time =", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeNotEqualTo(Date value) {
            addCriterion("request_time <>", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeGreaterThan(Date value) {
            addCriterion("request_time >", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("request_time >=", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeLessThan(Date value) {
            addCriterion("request_time <", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeLessThanOrEqualTo(Date value) {
            addCriterion("request_time <=", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeIn(List<Date> values) {
            addCriterion("request_time in", values, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeNotIn(List<Date> values) {
            addCriterion("request_time not in", values, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeBetween(Date value1, Date value2) {
            addCriterion("request_time between", value1, value2, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeNotBetween(Date value1, Date value2) {
            addCriterion("request_time not between", value1, value2, "requestTime");
            return (Criteria) this;
        }

        public Criteria andSystemNoIsNull() {
            addCriterion("system_no is null");
            return (Criteria) this;
        }

        public Criteria andSystemNoIsNotNull() {
            addCriterion("system_no is not null");
            return (Criteria) this;
        }

        public Criteria andSystemNoEqualTo(String value) {
            addCriterion("system_no =", value, "systemNo");
            return (Criteria) this;
        }

        public Criteria andSystemNoNotEqualTo(String value) {
            addCriterion("system_no <>", value, "systemNo");
            return (Criteria) this;
        }

        public Criteria andSystemNoGreaterThan(String value) {
            addCriterion("system_no >", value, "systemNo");
            return (Criteria) this;
        }

        public Criteria andSystemNoGreaterThanOrEqualTo(String value) {
            addCriterion("system_no >=", value, "systemNo");
            return (Criteria) this;
        }

        public Criteria andSystemNoLessThan(String value) {
            addCriterion("system_no <", value, "systemNo");
            return (Criteria) this;
        }

        public Criteria andSystemNoLessThanOrEqualTo(String value) {
            addCriterion("system_no <=", value, "systemNo");
            return (Criteria) this;
        }

        public Criteria andSystemNoLike(String value) {
            addCriterion("system_no like", value, "systemNo");
            return (Criteria) this;
        }

        public Criteria andSystemNoNotLike(String value) {
            addCriterion("system_no not like", value, "systemNo");
            return (Criteria) this;
        }

        public Criteria andSystemNoIn(List<String> values) {
            addCriterion("system_no in", values, "systemNo");
            return (Criteria) this;
        }

        public Criteria andSystemNoNotIn(List<String> values) {
            addCriterion("system_no not in", values, "systemNo");
            return (Criteria) this;
        }

        public Criteria andSystemNoBetween(String value1, String value2) {
            addCriterion("system_no between", value1, value2, "systemNo");
            return (Criteria) this;
        }

        public Criteria andSystemNoNotBetween(String value1, String value2) {
            addCriterion("system_no not between", value1, value2, "systemNo");
            return (Criteria) this;
        }

        public Criteria andOperTypeIsNull() {
            addCriterion("oper_type is null");
            return (Criteria) this;
        }

        public Criteria andOperTypeIsNotNull() {
            addCriterion("oper_type is not null");
            return (Criteria) this;
        }

        public Criteria andOperTypeEqualTo(Byte value) {
            addCriterion("oper_type =", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeNotEqualTo(Byte value) {
            addCriterion("oper_type <>", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeGreaterThan(Byte value) {
            addCriterion("oper_type >", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("oper_type >=", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeLessThan(Byte value) {
            addCriterion("oper_type <", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeLessThanOrEqualTo(Byte value) {
            addCriterion("oper_type <=", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeIn(List<Byte> values) {
            addCriterion("oper_type in", values, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeNotIn(List<Byte> values) {
            addCriterion("oper_type not in", values, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeBetween(Byte value1, Byte value2) {
            addCriterion("oper_type between", value1, value2, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("oper_type not between", value1, value2, "operType");
            return (Criteria) this;
        }

        public Criteria andPlatformUserIdIsNull() {
            addCriterion("platform_user_id is null");
            return (Criteria) this;
        }

        public Criteria andPlatformUserIdIsNotNull() {
            addCriterion("platform_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformUserIdEqualTo(String value) {
            addCriterion("platform_user_id =", value, "platformUserId");
            return (Criteria) this;
        }

        public Criteria andPlatformUserIdNotEqualTo(String value) {
            addCriterion("platform_user_id <>", value, "platformUserId");
            return (Criteria) this;
        }

        public Criteria andPlatformUserIdGreaterThan(String value) {
            addCriterion("platform_user_id >", value, "platformUserId");
            return (Criteria) this;
        }

        public Criteria andPlatformUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("platform_user_id >=", value, "platformUserId");
            return (Criteria) this;
        }

        public Criteria andPlatformUserIdLessThan(String value) {
            addCriterion("platform_user_id <", value, "platformUserId");
            return (Criteria) this;
        }

        public Criteria andPlatformUserIdLessThanOrEqualTo(String value) {
            addCriterion("platform_user_id <=", value, "platformUserId");
            return (Criteria) this;
        }

        public Criteria andPlatformUserIdLike(String value) {
            addCriterion("platform_user_id like", value, "platformUserId");
            return (Criteria) this;
        }

        public Criteria andPlatformUserIdNotLike(String value) {
            addCriterion("platform_user_id not like", value, "platformUserId");
            return (Criteria) this;
        }

        public Criteria andPlatformUserIdIn(List<String> values) {
            addCriterion("platform_user_id in", values, "platformUserId");
            return (Criteria) this;
        }

        public Criteria andPlatformUserIdNotIn(List<String> values) {
            addCriterion("platform_user_id not in", values, "platformUserId");
            return (Criteria) this;
        }

        public Criteria andPlatformUserIdBetween(String value1, String value2) {
            addCriterion("platform_user_id between", value1, value2, "platformUserId");
            return (Criteria) this;
        }

        public Criteria andPlatformUserIdNotBetween(String value1, String value2) {
            addCriterion("platform_user_id not between", value1, value2, "platformUserId");
            return (Criteria) this;
        }

        public Criteria andIsSkipIsNull() {
            addCriterion("is_skip is null");
            return (Criteria) this;
        }

        public Criteria andIsSkipIsNotNull() {
            addCriterion("is_skip is not null");
            return (Criteria) this;
        }

        public Criteria andIsSkipEqualTo(Boolean value) {
            addCriterion("is_skip =", value, "isSkip");
            return (Criteria) this;
        }

        public Criteria andIsSkipNotEqualTo(Boolean value) {
            addCriterion("is_skip <>", value, "isSkip");
            return (Criteria) this;
        }

        public Criteria andIsSkipGreaterThan(Boolean value) {
            addCriterion("is_skip >", value, "isSkip");
            return (Criteria) this;
        }

        public Criteria andIsSkipGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_skip >=", value, "isSkip");
            return (Criteria) this;
        }

        public Criteria andIsSkipLessThan(Boolean value) {
            addCriterion("is_skip <", value, "isSkip");
            return (Criteria) this;
        }

        public Criteria andIsSkipLessThanOrEqualTo(Boolean value) {
            addCriterion("is_skip <=", value, "isSkip");
            return (Criteria) this;
        }

        public Criteria andIsSkipIn(List<Boolean> values) {
            addCriterion("is_skip in", values, "isSkip");
            return (Criteria) this;
        }

        public Criteria andIsSkipNotIn(List<Boolean> values) {
            addCriterion("is_skip not in", values, "isSkip");
            return (Criteria) this;
        }

        public Criteria andIsSkipBetween(Boolean value1, Boolean value2) {
            addCriterion("is_skip between", value1, value2, "isSkip");
            return (Criteria) this;
        }

        public Criteria andIsSkipNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_skip not between", value1, value2, "isSkip");
            return (Criteria) this;
        }

        public Criteria andBizTypeDescIsNull() {
            addCriterion("biz_type_desc is null");
            return (Criteria) this;
        }

        public Criteria andBizTypeDescIsNotNull() {
            addCriterion("biz_type_desc is not null");
            return (Criteria) this;
        }

        public Criteria andBizTypeDescEqualTo(String value) {
            addCriterion("biz_type_desc =", value, "bizTypeDesc");
            return (Criteria) this;
        }

        public Criteria andBizTypeDescNotEqualTo(String value) {
            addCriterion("biz_type_desc <>", value, "bizTypeDesc");
            return (Criteria) this;
        }

        public Criteria andBizTypeDescGreaterThan(String value) {
            addCriterion("biz_type_desc >", value, "bizTypeDesc");
            return (Criteria) this;
        }

        public Criteria andBizTypeDescGreaterThanOrEqualTo(String value) {
            addCriterion("biz_type_desc >=", value, "bizTypeDesc");
            return (Criteria) this;
        }

        public Criteria andBizTypeDescLessThan(String value) {
            addCriterion("biz_type_desc <", value, "bizTypeDesc");
            return (Criteria) this;
        }

        public Criteria andBizTypeDescLessThanOrEqualTo(String value) {
            addCriterion("biz_type_desc <=", value, "bizTypeDesc");
            return (Criteria) this;
        }

        public Criteria andBizTypeDescLike(String value) {
            addCriterion("biz_type_desc like", value, "bizTypeDesc");
            return (Criteria) this;
        }

        public Criteria andBizTypeDescNotLike(String value) {
            addCriterion("biz_type_desc not like", value, "bizTypeDesc");
            return (Criteria) this;
        }

        public Criteria andBizTypeDescIn(List<String> values) {
            addCriterion("biz_type_desc in", values, "bizTypeDesc");
            return (Criteria) this;
        }

        public Criteria andBizTypeDescNotIn(List<String> values) {
            addCriterion("biz_type_desc not in", values, "bizTypeDesc");
            return (Criteria) this;
        }

        public Criteria andBizTypeDescBetween(String value1, String value2) {
            addCriterion("biz_type_desc between", value1, value2, "bizTypeDesc");
            return (Criteria) this;
        }

        public Criteria andBizTypeDescNotBetween(String value1, String value2) {
            addCriterion("biz_type_desc not between", value1, value2, "bizTypeDesc");
            return (Criteria) this;
        }

        public Criteria andAuthListIsNull() {
            addCriterion("auth_list is null");
            return (Criteria) this;
        }

        public Criteria andAuthListIsNotNull() {
            addCriterion("auth_list is not null");
            return (Criteria) this;
        }

        public Criteria andAuthListEqualTo(String value) {
            addCriterion("auth_list =", value, "authList");
            return (Criteria) this;
        }

        public Criteria andAuthListNotEqualTo(String value) {
            addCriterion("auth_list <>", value, "authList");
            return (Criteria) this;
        }

        public Criteria andAuthListGreaterThan(String value) {
            addCriterion("auth_list >", value, "authList");
            return (Criteria) this;
        }

        public Criteria andAuthListGreaterThanOrEqualTo(String value) {
            addCriterion("auth_list >=", value, "authList");
            return (Criteria) this;
        }

        public Criteria andAuthListLessThan(String value) {
            addCriterion("auth_list <", value, "authList");
            return (Criteria) this;
        }

        public Criteria andAuthListLessThanOrEqualTo(String value) {
            addCriterion("auth_list <=", value, "authList");
            return (Criteria) this;
        }

        public Criteria andAuthListLike(String value) {
            addCriterion("auth_list like", value, "authList");
            return (Criteria) this;
        }

        public Criteria andAuthListNotLike(String value) {
            addCriterion("auth_list not like", value, "authList");
            return (Criteria) this;
        }

        public Criteria andAuthListIn(List<String> values) {
            addCriterion("auth_list in", values, "authList");
            return (Criteria) this;
        }

        public Criteria andAuthListNotIn(List<String> values) {
            addCriterion("auth_list not in", values, "authList");
            return (Criteria) this;
        }

        public Criteria andAuthListBetween(String value1, String value2) {
            addCriterion("auth_list between", value1, value2, "authList");
            return (Criteria) this;
        }

        public Criteria andAuthListNotBetween(String value1, String value2) {
            addCriterion("auth_list not between", value1, value2, "authList");
            return (Criteria) this;
        }

        public Criteria andCheckTypeIsNull() {
            addCriterion("check_type is null");
            return (Criteria) this;
        }

        public Criteria andCheckTypeIsNotNull() {
            addCriterion("check_type is not null");
            return (Criteria) this;
        }

        public Criteria andCheckTypeEqualTo(Boolean value) {
            addCriterion("check_type =", value, "checkType");
            return (Criteria) this;
        }

        public Criteria andCheckTypeNotEqualTo(Boolean value) {
            addCriterion("check_type <>", value, "checkType");
            return (Criteria) this;
        }

        public Criteria andCheckTypeGreaterThan(Boolean value) {
            addCriterion("check_type >", value, "checkType");
            return (Criteria) this;
        }

        public Criteria andCheckTypeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("check_type >=", value, "checkType");
            return (Criteria) this;
        }

        public Criteria andCheckTypeLessThan(Boolean value) {
            addCriterion("check_type <", value, "checkType");
            return (Criteria) this;
        }

        public Criteria andCheckTypeLessThanOrEqualTo(Boolean value) {
            addCriterion("check_type <=", value, "checkType");
            return (Criteria) this;
        }

        public Criteria andCheckTypeIn(List<Boolean> values) {
            addCriterion("check_type in", values, "checkType");
            return (Criteria) this;
        }

        public Criteria andCheckTypeNotIn(List<Boolean> values) {
            addCriterion("check_type not in", values, "checkType");
            return (Criteria) this;
        }

        public Criteria andCheckTypeBetween(Boolean value1, Boolean value2) {
            addCriterion("check_type between", value1, value2, "checkType");
            return (Criteria) this;
        }

        public Criteria andCheckTypeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("check_type not between", value1, value2, "checkType");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlIsNull() {
            addCriterion("callback_url is null");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlIsNotNull() {
            addCriterion("callback_url is not null");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlEqualTo(String value) {
            addCriterion("callback_url =", value, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlNotEqualTo(String value) {
            addCriterion("callback_url <>", value, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlGreaterThan(String value) {
            addCriterion("callback_url >", value, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlGreaterThanOrEqualTo(String value) {
            addCriterion("callback_url >=", value, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlLessThan(String value) {
            addCriterion("callback_url <", value, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlLessThanOrEqualTo(String value) {
            addCriterion("callback_url <=", value, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlLike(String value) {
            addCriterion("callback_url like", value, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlNotLike(String value) {
            addCriterion("callback_url not like", value, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlIn(List<String> values) {
            addCriterion("callback_url in", values, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlNotIn(List<String> values) {
            addCriterion("callback_url not in", values, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlBetween(String value1, String value2) {
            addCriterion("callback_url between", value1, value2, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlNotBetween(String value1, String value2) {
            addCriterion("callback_url not between", value1, value2, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIsNull() {
            addCriterion("notify_url is null");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIsNotNull() {
            addCriterion("notify_url is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlEqualTo(String value) {
            addCriterion("notify_url =", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotEqualTo(String value) {
            addCriterion("notify_url <>", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlGreaterThan(String value) {
            addCriterion("notify_url >", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlGreaterThanOrEqualTo(String value) {
            addCriterion("notify_url >=", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLessThan(String value) {
            addCriterion("notify_url <", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLessThanOrEqualTo(String value) {
            addCriterion("notify_url <=", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLike(String value) {
            addCriterion("notify_url like", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotLike(String value) {
            addCriterion("notify_url not like", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIn(List<String> values) {
            addCriterion("notify_url in", values, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotIn(List<String> values) {
            addCriterion("notify_url not in", values, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlBetween(String value1, String value2) {
            addCriterion("notify_url between", value1, value2, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotBetween(String value1, String value2) {
            addCriterion("notify_url not between", value1, value2, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andResultIsNull() {
            addCriterion("result is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("result is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(String value) {
            addCriterion("result =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(String value) {
            addCriterion("result <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(String value) {
            addCriterion("result >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(String value) {
            addCriterion("result >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(String value) {
            addCriterion("result <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(String value) {
            addCriterion("result <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLike(String value) {
            addCriterion("result like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotLike(String value) {
            addCriterion("result not like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<String> values) {
            addCriterion("result in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<String> values) {
            addCriterion("result not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(String value1, String value2) {
            addCriterion("result between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(String value1, String value2) {
            addCriterion("result not between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andFailCodeIsNull() {
            addCriterion("fail_code is null");
            return (Criteria) this;
        }

        public Criteria andFailCodeIsNotNull() {
            addCriterion("fail_code is not null");
            return (Criteria) this;
        }

        public Criteria andFailCodeEqualTo(String value) {
            addCriterion("fail_code =", value, "failCode");
            return (Criteria) this;
        }

        public Criteria andFailCodeNotEqualTo(String value) {
            addCriterion("fail_code <>", value, "failCode");
            return (Criteria) this;
        }

        public Criteria andFailCodeGreaterThan(String value) {
            addCriterion("fail_code >", value, "failCode");
            return (Criteria) this;
        }

        public Criteria andFailCodeGreaterThanOrEqualTo(String value) {
            addCriterion("fail_code >=", value, "failCode");
            return (Criteria) this;
        }

        public Criteria andFailCodeLessThan(String value) {
            addCriterion("fail_code <", value, "failCode");
            return (Criteria) this;
        }

        public Criteria andFailCodeLessThanOrEqualTo(String value) {
            addCriterion("fail_code <=", value, "failCode");
            return (Criteria) this;
        }

        public Criteria andFailCodeLike(String value) {
            addCriterion("fail_code like", value, "failCode");
            return (Criteria) this;
        }

        public Criteria andFailCodeNotLike(String value) {
            addCriterion("fail_code not like", value, "failCode");
            return (Criteria) this;
        }

        public Criteria andFailCodeIn(List<String> values) {
            addCriterion("fail_code in", values, "failCode");
            return (Criteria) this;
        }

        public Criteria andFailCodeNotIn(List<String> values) {
            addCriterion("fail_code not in", values, "failCode");
            return (Criteria) this;
        }

        public Criteria andFailCodeBetween(String value1, String value2) {
            addCriterion("fail_code between", value1, value2, "failCode");
            return (Criteria) this;
        }

        public Criteria andFailCodeNotBetween(String value1, String value2) {
            addCriterion("fail_code not between", value1, value2, "failCode");
            return (Criteria) this;
        }

        public Criteria andFailReasonIsNull() {
            addCriterion("fail_reason is null");
            return (Criteria) this;
        }

        public Criteria andFailReasonIsNotNull() {
            addCriterion("fail_reason is not null");
            return (Criteria) this;
        }

        public Criteria andFailReasonEqualTo(String value) {
            addCriterion("fail_reason =", value, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonNotEqualTo(String value) {
            addCriterion("fail_reason <>", value, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonGreaterThan(String value) {
            addCriterion("fail_reason >", value, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonGreaterThanOrEqualTo(String value) {
            addCriterion("fail_reason >=", value, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonLessThan(String value) {
            addCriterion("fail_reason <", value, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonLessThanOrEqualTo(String value) {
            addCriterion("fail_reason <=", value, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonLike(String value) {
            addCriterion("fail_reason like", value, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonNotLike(String value) {
            addCriterion("fail_reason not like", value, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonIn(List<String> values) {
            addCriterion("fail_reason in", values, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonNotIn(List<String> values) {
            addCriterion("fail_reason not in", values, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonBetween(String value1, String value2) {
            addCriterion("fail_reason between", value1, value2, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonNotBetween(String value1, String value2) {
            addCriterion("fail_reason not between", value1, value2, "failReason");
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

        public Criteria andPartitionDateIsNull() {
            addCriterion("partition_date is null");
            return (Criteria) this;
        }

        public Criteria andPartitionDateIsNotNull() {
            addCriterion("partition_date is not null");
            return (Criteria) this;
        }

        public Criteria andPartitionDateEqualTo(Integer value) {
            addCriterion("partition_date =", value, "partitionDate");
            return (Criteria) this;
        }

        public Criteria andPartitionDateNotEqualTo(Integer value) {
            addCriterion("partition_date <>", value, "partitionDate");
            return (Criteria) this;
        }

        public Criteria andPartitionDateGreaterThan(Integer value) {
            addCriterion("partition_date >", value, "partitionDate");
            return (Criteria) this;
        }

        public Criteria andPartitionDateGreaterThanOrEqualTo(Integer value) {
            addCriterion("partition_date >=", value, "partitionDate");
            return (Criteria) this;
        }

        public Criteria andPartitionDateLessThan(Integer value) {
            addCriterion("partition_date <", value, "partitionDate");
            return (Criteria) this;
        }

        public Criteria andPartitionDateLessThanOrEqualTo(Integer value) {
            addCriterion("partition_date <=", value, "partitionDate");
            return (Criteria) this;
        }

        public Criteria andPartitionDateIn(List<Integer> values) {
            addCriterion("partition_date in", values, "partitionDate");
            return (Criteria) this;
        }

        public Criteria andPartitionDateNotIn(List<Integer> values) {
            addCriterion("partition_date not in", values, "partitionDate");
            return (Criteria) this;
        }

        public Criteria andPartitionDateBetween(Integer value1, Integer value2) {
            addCriterion("partition_date between", value1, value2, "partitionDate");
            return (Criteria) this;
        }

        public Criteria andPartitionDateNotBetween(Integer value1, Integer value2) {
            addCriterion("partition_date not between", value1, value2, "partitionDate");
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
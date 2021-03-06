package com.crfchina.cdg.basedb.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LmBindCardListExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LmBindCardListExample() {
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

        public Criteria andUserRealNameIsNull() {
            addCriterion("user_real_name is null");
            return (Criteria) this;
        }

        public Criteria andUserRealNameIsNotNull() {
            addCriterion("user_real_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserRealNameEqualTo(String value) {
            addCriterion("user_real_name =", value, "userRealName");
            return (Criteria) this;
        }

        public Criteria andUserRealNameNotEqualTo(String value) {
            addCriterion("user_real_name <>", value, "userRealName");
            return (Criteria) this;
        }

        public Criteria andUserRealNameGreaterThan(String value) {
            addCriterion("user_real_name >", value, "userRealName");
            return (Criteria) this;
        }

        public Criteria andUserRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_real_name >=", value, "userRealName");
            return (Criteria) this;
        }

        public Criteria andUserRealNameLessThan(String value) {
            addCriterion("user_real_name <", value, "userRealName");
            return (Criteria) this;
        }

        public Criteria andUserRealNameLessThanOrEqualTo(String value) {
            addCriterion("user_real_name <=", value, "userRealName");
            return (Criteria) this;
        }

        public Criteria andUserRealNameLike(String value) {
            addCriterion("user_real_name like", value, "userRealName");
            return (Criteria) this;
        }

        public Criteria andUserRealNameNotLike(String value) {
            addCriterion("user_real_name not like", value, "userRealName");
            return (Criteria) this;
        }

        public Criteria andUserRealNameIn(List<String> values) {
            addCriterion("user_real_name in", values, "userRealName");
            return (Criteria) this;
        }

        public Criteria andUserRealNameNotIn(List<String> values) {
            addCriterion("user_real_name not in", values, "userRealName");
            return (Criteria) this;
        }

        public Criteria andUserRealNameBetween(String value1, String value2) {
            addCriterion("user_real_name between", value1, value2, "userRealName");
            return (Criteria) this;
        }

        public Criteria andUserRealNameNotBetween(String value1, String value2) {
            addCriterion("user_real_name not between", value1, value2, "userRealName");
            return (Criteria) this;
        }

        public Criteria andBankcardNoIsNull() {
            addCriterion("bankcard_no is null");
            return (Criteria) this;
        }

        public Criteria andBankcardNoIsNotNull() {
            addCriterion("bankcard_no is not null");
            return (Criteria) this;
        }

        public Criteria andBankcardNoEqualTo(String value) {
            addCriterion("bankcard_no =", value, "bankcardNo");
            return (Criteria) this;
        }

        public Criteria andBankcardNoNotEqualTo(String value) {
            addCriterion("bankcard_no <>", value, "bankcardNo");
            return (Criteria) this;
        }

        public Criteria andBankcardNoGreaterThan(String value) {
            addCriterion("bankcard_no >", value, "bankcardNo");
            return (Criteria) this;
        }

        public Criteria andBankcardNoGreaterThanOrEqualTo(String value) {
            addCriterion("bankcard_no >=", value, "bankcardNo");
            return (Criteria) this;
        }

        public Criteria andBankcardNoLessThan(String value) {
            addCriterion("bankcard_no <", value, "bankcardNo");
            return (Criteria) this;
        }

        public Criteria andBankcardNoLessThanOrEqualTo(String value) {
            addCriterion("bankcard_no <=", value, "bankcardNo");
            return (Criteria) this;
        }

        public Criteria andBankcardNoLike(String value) {
            addCriterion("bankcard_no like", value, "bankcardNo");
            return (Criteria) this;
        }

        public Criteria andBankcardNoNotLike(String value) {
            addCriterion("bankcard_no not like", value, "bankcardNo");
            return (Criteria) this;
        }

        public Criteria andBankcardNoIn(List<String> values) {
            addCriterion("bankcard_no in", values, "bankcardNo");
            return (Criteria) this;
        }

        public Criteria andBankcardNoNotIn(List<String> values) {
            addCriterion("bankcard_no not in", values, "bankcardNo");
            return (Criteria) this;
        }

        public Criteria andBankcardNoBetween(String value1, String value2) {
            addCriterion("bankcard_no between", value1, value2, "bankcardNo");
            return (Criteria) this;
        }

        public Criteria andBankcardNoNotBetween(String value1, String value2) {
            addCriterion("bankcard_no not between", value1, value2, "bankcardNo");
            return (Criteria) this;
        }

        public Criteria andBankCodeIsNull() {
            addCriterion("bank_code is null");
            return (Criteria) this;
        }

        public Criteria andBankCodeIsNotNull() {
            addCriterion("bank_code is not null");
            return (Criteria) this;
        }

        public Criteria andBankCodeEqualTo(String value) {
            addCriterion("bank_code =", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotEqualTo(String value) {
            addCriterion("bank_code <>", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeGreaterThan(String value) {
            addCriterion("bank_code >", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeGreaterThanOrEqualTo(String value) {
            addCriterion("bank_code >=", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeLessThan(String value) {
            addCriterion("bank_code <", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeLessThanOrEqualTo(String value) {
            addCriterion("bank_code <=", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeLike(String value) {
            addCriterion("bank_code like", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotLike(String value) {
            addCriterion("bank_code not like", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeIn(List<String> values) {
            addCriterion("bank_code in", values, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotIn(List<String> values) {
            addCriterion("bank_code not in", values, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeBetween(String value1, String value2) {
            addCriterion("bank_code between", value1, value2, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotBetween(String value1, String value2) {
            addCriterion("bank_code not between", value1, value2, "bankCode");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andIdNoIsNull() {
            addCriterion("id_no is null");
            return (Criteria) this;
        }

        public Criteria andIdNoIsNotNull() {
            addCriterion("id_no is not null");
            return (Criteria) this;
        }

        public Criteria andIdNoEqualTo(String value) {
            addCriterion("id_no =", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoNotEqualTo(String value) {
            addCriterion("id_no <>", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoGreaterThan(String value) {
            addCriterion("id_no >", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoGreaterThanOrEqualTo(String value) {
            addCriterion("id_no >=", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoLessThan(String value) {
            addCriterion("id_no <", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoLessThanOrEqualTo(String value) {
            addCriterion("id_no <=", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoLike(String value) {
            addCriterion("id_no like", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoNotLike(String value) {
            addCriterion("id_no not like", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoIn(List<String> values) {
            addCriterion("id_no in", values, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoNotIn(List<String> values) {
            addCriterion("id_no not in", values, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoBetween(String value1, String value2) {
            addCriterion("id_no between", value1, value2, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoNotBetween(String value1, String value2) {
            addCriterion("id_no not between", value1, value2, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdTypeIsNull() {
            addCriterion("id_type is null");
            return (Criteria) this;
        }

        public Criteria andIdTypeIsNotNull() {
            addCriterion("id_type is not null");
            return (Criteria) this;
        }

        public Criteria andIdTypeEqualTo(Byte value) {
            addCriterion("id_type =", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeNotEqualTo(Byte value) {
            addCriterion("id_type <>", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeGreaterThan(Byte value) {
            addCriterion("id_type >", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("id_type >=", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeLessThan(Byte value) {
            addCriterion("id_type <", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeLessThanOrEqualTo(Byte value) {
            addCriterion("id_type <=", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeIn(List<Byte> values) {
            addCriterion("id_type in", values, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeNotIn(List<Byte> values) {
            addCriterion("id_type not in", values, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeBetween(Byte value1, Byte value2) {
            addCriterion("id_type between", value1, value2, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("id_type not between", value1, value2, "idType");
            return (Criteria) this;
        }

        public Criteria andBindcardTimeIsNull() {
            addCriterion("bindcard_time is null");
            return (Criteria) this;
        }

        public Criteria andBindcardTimeIsNotNull() {
            addCriterion("bindcard_time is not null");
            return (Criteria) this;
        }

        public Criteria andBindcardTimeEqualTo(Date value) {
            addCriterion("bindcard_time =", value, "bindcardTime");
            return (Criteria) this;
        }

        public Criteria andBindcardTimeNotEqualTo(Date value) {
            addCriterion("bindcard_time <>", value, "bindcardTime");
            return (Criteria) this;
        }

        public Criteria andBindcardTimeGreaterThan(Date value) {
            addCriterion("bindcard_time >", value, "bindcardTime");
            return (Criteria) this;
        }

        public Criteria andBindcardTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("bindcard_time >=", value, "bindcardTime");
            return (Criteria) this;
        }

        public Criteria andBindcardTimeLessThan(Date value) {
            addCriterion("bindcard_time <", value, "bindcardTime");
            return (Criteria) this;
        }

        public Criteria andBindcardTimeLessThanOrEqualTo(Date value) {
            addCriterion("bindcard_time <=", value, "bindcardTime");
            return (Criteria) this;
        }

        public Criteria andBindcardTimeIn(List<Date> values) {
            addCriterion("bindcard_time in", values, "bindcardTime");
            return (Criteria) this;
        }

        public Criteria andBindcardTimeNotIn(List<Date> values) {
            addCriterion("bindcard_time not in", values, "bindcardTime");
            return (Criteria) this;
        }

        public Criteria andBindcardTimeBetween(Date value1, Date value2) {
            addCriterion("bindcard_time between", value1, value2, "bindcardTime");
            return (Criteria) this;
        }

        public Criteria andBindcardTimeNotBetween(Date value1, Date value2) {
            addCriterion("bindcard_time not between", value1, value2, "bindcardTime");
            return (Criteria) this;
        }

        public Criteria andUserRoleIsNull() {
            addCriterion("user_role is null");
            return (Criteria) this;
        }

        public Criteria andUserRoleIsNotNull() {
            addCriterion("user_role is not null");
            return (Criteria) this;
        }

        public Criteria andUserRoleEqualTo(String value) {
            addCriterion("user_role =", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleNotEqualTo(String value) {
            addCriterion("user_role <>", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleGreaterThan(String value) {
            addCriterion("user_role >", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleGreaterThanOrEqualTo(String value) {
            addCriterion("user_role >=", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleLessThan(String value) {
            addCriterion("user_role <", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleLessThanOrEqualTo(String value) {
            addCriterion("user_role <=", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleLike(String value) {
            addCriterion("user_role like", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleNotLike(String value) {
            addCriterion("user_role not like", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleIn(List<String> values) {
            addCriterion("user_role in", values, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleNotIn(List<String> values) {
            addCriterion("user_role not in", values, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleBetween(String value1, String value2) {
            addCriterion("user_role between", value1, value2, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleNotBetween(String value1, String value2) {
            addCriterion("user_role not between", value1, value2, "userRole");
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

        public Criteria andUserLimitTypeIsNull() {
            addCriterion("user_limit_type is null");
            return (Criteria) this;
        }

        public Criteria andUserLimitTypeIsNotNull() {
            addCriterion("user_limit_type is not null");
            return (Criteria) this;
        }

        public Criteria andUserLimitTypeEqualTo(Boolean value) {
            addCriterion("user_limit_type =", value, "userLimitType");
            return (Criteria) this;
        }

        public Criteria andUserLimitTypeNotEqualTo(Boolean value) {
            addCriterion("user_limit_type <>", value, "userLimitType");
            return (Criteria) this;
        }

        public Criteria andUserLimitTypeGreaterThan(Boolean value) {
            addCriterion("user_limit_type >", value, "userLimitType");
            return (Criteria) this;
        }

        public Criteria andUserLimitTypeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("user_limit_type >=", value, "userLimitType");
            return (Criteria) this;
        }

        public Criteria andUserLimitTypeLessThan(Boolean value) {
            addCriterion("user_limit_type <", value, "userLimitType");
            return (Criteria) this;
        }

        public Criteria andUserLimitTypeLessThanOrEqualTo(Boolean value) {
            addCriterion("user_limit_type <=", value, "userLimitType");
            return (Criteria) this;
        }

        public Criteria andUserLimitTypeIn(List<Boolean> values) {
            addCriterion("user_limit_type in", values, "userLimitType");
            return (Criteria) this;
        }

        public Criteria andUserLimitTypeNotIn(List<Boolean> values) {
            addCriterion("user_limit_type not in", values, "userLimitType");
            return (Criteria) this;
        }

        public Criteria andUserLimitTypeBetween(Boolean value1, Boolean value2) {
            addCriterion("user_limit_type between", value1, value2, "userLimitType");
            return (Criteria) this;
        }

        public Criteria andUserLimitTypeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("user_limit_type not between", value1, value2, "userLimitType");
            return (Criteria) this;
        }

        public Criteria andAccessTypeIsNull() {
            addCriterion("access_type is null");
            return (Criteria) this;
        }

        public Criteria andAccessTypeIsNotNull() {
            addCriterion("access_type is not null");
            return (Criteria) this;
        }

        public Criteria andAccessTypeEqualTo(Boolean value) {
            addCriterion("access_type =", value, "accessType");
            return (Criteria) this;
        }

        public Criteria andAccessTypeNotEqualTo(Boolean value) {
            addCriterion("access_type <>", value, "accessType");
            return (Criteria) this;
        }

        public Criteria andAccessTypeGreaterThan(Boolean value) {
            addCriterion("access_type >", value, "accessType");
            return (Criteria) this;
        }

        public Criteria andAccessTypeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("access_type >=", value, "accessType");
            return (Criteria) this;
        }

        public Criteria andAccessTypeLessThan(Boolean value) {
            addCriterion("access_type <", value, "accessType");
            return (Criteria) this;
        }

        public Criteria andAccessTypeLessThanOrEqualTo(Boolean value) {
            addCriterion("access_type <=", value, "accessType");
            return (Criteria) this;
        }

        public Criteria andAccessTypeIn(List<Boolean> values) {
            addCriterion("access_type in", values, "accessType");
            return (Criteria) this;
        }

        public Criteria andAccessTypeNotIn(List<Boolean> values) {
            addCriterion("access_type not in", values, "accessType");
            return (Criteria) this;
        }

        public Criteria andAccessTypeBetween(Boolean value1, Boolean value2) {
            addCriterion("access_type between", value1, value2, "accessType");
            return (Criteria) this;
        }

        public Criteria andAccessTypeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("access_type not between", value1, value2, "accessType");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIsNull() {
            addCriterion("audit_status is null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIsNotNull() {
            addCriterion("audit_status is not null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusEqualTo(Boolean value) {
            addCriterion("audit_status =", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotEqualTo(Boolean value) {
            addCriterion("audit_status <>", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThan(Boolean value) {
            addCriterion("audit_status >", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("audit_status >=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThan(Boolean value) {
            addCriterion("audit_status <", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("audit_status <=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIn(List<Boolean> values) {
            addCriterion("audit_status in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotIn(List<Boolean> values) {
            addCriterion("audit_status not in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("audit_status between", value1, value2, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("audit_status not between", value1, value2, "auditStatus");
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

        public Criteria andStatusEqualTo(Boolean value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Boolean value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Boolean value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Boolean value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Boolean> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Boolean> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("status not between", value1, value2, "status");
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
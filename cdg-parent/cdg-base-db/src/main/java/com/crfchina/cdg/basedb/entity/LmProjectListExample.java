package com.crfchina.cdg.basedb.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LmProjectListExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LmProjectListExample() {
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

        public Criteria andProjectNoIsNull() {
            addCriterion("project_no is null");
            return (Criteria) this;
        }

        public Criteria andProjectNoIsNotNull() {
            addCriterion("project_no is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNoEqualTo(String value) {
            addCriterion("project_no =", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoNotEqualTo(String value) {
            addCriterion("project_no <>", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoGreaterThan(String value) {
            addCriterion("project_no >", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoGreaterThanOrEqualTo(String value) {
            addCriterion("project_no >=", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoLessThan(String value) {
            addCriterion("project_no <", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoLessThanOrEqualTo(String value) {
            addCriterion("project_no <=", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoLike(String value) {
            addCriterion("project_no like", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoNotLike(String value) {
            addCriterion("project_no not like", value, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoIn(List<String> values) {
            addCriterion("project_no in", values, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoNotIn(List<String> values) {
            addCriterion("project_no not in", values, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoBetween(String value1, String value2) {
            addCriterion("project_no between", value1, value2, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectNoNotBetween(String value1, String value2) {
            addCriterion("project_no not between", value1, value2, "projectNo");
            return (Criteria) this;
        }

        public Criteria andProjectAmountIsNull() {
            addCriterion("project_amount is null");
            return (Criteria) this;
        }

        public Criteria andProjectAmountIsNotNull() {
            addCriterion("project_amount is not null");
            return (Criteria) this;
        }

        public Criteria andProjectAmountEqualTo(String value) {
            addCriterion("project_amount =", value, "projectAmount");
            return (Criteria) this;
        }

        public Criteria andProjectAmountNotEqualTo(String value) {
            addCriterion("project_amount <>", value, "projectAmount");
            return (Criteria) this;
        }

        public Criteria andProjectAmountGreaterThan(String value) {
            addCriterion("project_amount >", value, "projectAmount");
            return (Criteria) this;
        }

        public Criteria andProjectAmountGreaterThanOrEqualTo(String value) {
            addCriterion("project_amount >=", value, "projectAmount");
            return (Criteria) this;
        }

        public Criteria andProjectAmountLessThan(String value) {
            addCriterion("project_amount <", value, "projectAmount");
            return (Criteria) this;
        }

        public Criteria andProjectAmountLessThanOrEqualTo(String value) {
            addCriterion("project_amount <=", value, "projectAmount");
            return (Criteria) this;
        }

        public Criteria andProjectAmountLike(String value) {
            addCriterion("project_amount like", value, "projectAmount");
            return (Criteria) this;
        }

        public Criteria andProjectAmountNotLike(String value) {
            addCriterion("project_amount not like", value, "projectAmount");
            return (Criteria) this;
        }

        public Criteria andProjectAmountIn(List<String> values) {
            addCriterion("project_amount in", values, "projectAmount");
            return (Criteria) this;
        }

        public Criteria andProjectAmountNotIn(List<String> values) {
            addCriterion("project_amount not in", values, "projectAmount");
            return (Criteria) this;
        }

        public Criteria andProjectAmountBetween(String value1, String value2) {
            addCriterion("project_amount between", value1, value2, "projectAmount");
            return (Criteria) this;
        }

        public Criteria andProjectAmountNotBetween(String value1, String value2) {
            addCriterion("project_amount not between", value1, value2, "projectAmount");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNull() {
            addCriterion("project_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("project_name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("project_name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("project_name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("project_name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("project_name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("project_name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("project_name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("project_name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("project_name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("project_name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("project_name not between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectDescIsNull() {
            addCriterion("project_desc is null");
            return (Criteria) this;
        }

        public Criteria andProjectDescIsNotNull() {
            addCriterion("project_desc is not null");
            return (Criteria) this;
        }

        public Criteria andProjectDescEqualTo(String value) {
            addCriterion("project_desc =", value, "projectDesc");
            return (Criteria) this;
        }

        public Criteria andProjectDescNotEqualTo(String value) {
            addCriterion("project_desc <>", value, "projectDesc");
            return (Criteria) this;
        }

        public Criteria andProjectDescGreaterThan(String value) {
            addCriterion("project_desc >", value, "projectDesc");
            return (Criteria) this;
        }

        public Criteria andProjectDescGreaterThanOrEqualTo(String value) {
            addCriterion("project_desc >=", value, "projectDesc");
            return (Criteria) this;
        }

        public Criteria andProjectDescLessThan(String value) {
            addCriterion("project_desc <", value, "projectDesc");
            return (Criteria) this;
        }

        public Criteria andProjectDescLessThanOrEqualTo(String value) {
            addCriterion("project_desc <=", value, "projectDesc");
            return (Criteria) this;
        }

        public Criteria andProjectDescLike(String value) {
            addCriterion("project_desc like", value, "projectDesc");
            return (Criteria) this;
        }

        public Criteria andProjectDescNotLike(String value) {
            addCriterion("project_desc not like", value, "projectDesc");
            return (Criteria) this;
        }

        public Criteria andProjectDescIn(List<String> values) {
            addCriterion("project_desc in", values, "projectDesc");
            return (Criteria) this;
        }

        public Criteria andProjectDescNotIn(List<String> values) {
            addCriterion("project_desc not in", values, "projectDesc");
            return (Criteria) this;
        }

        public Criteria andProjectDescBetween(String value1, String value2) {
            addCriterion("project_desc between", value1, value2, "projectDesc");
            return (Criteria) this;
        }

        public Criteria andProjectDescNotBetween(String value1, String value2) {
            addCriterion("project_desc not between", value1, value2, "projectDesc");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIsNull() {
            addCriterion("project_type is null");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIsNotNull() {
            addCriterion("project_type is not null");
            return (Criteria) this;
        }

        public Criteria andProjectTypeEqualTo(Boolean value) {
            addCriterion("project_type =", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotEqualTo(Boolean value) {
            addCriterion("project_type <>", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeGreaterThan(Boolean value) {
            addCriterion("project_type >", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("project_type >=", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeLessThan(Boolean value) {
            addCriterion("project_type <", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeLessThanOrEqualTo(Boolean value) {
            addCriterion("project_type <=", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIn(List<Boolean> values) {
            addCriterion("project_type in", values, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotIn(List<Boolean> values) {
            addCriterion("project_type not in", values, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeBetween(Boolean value1, Boolean value2) {
            addCriterion("project_type between", value1, value2, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("project_type not between", value1, value2, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectPeriodIsNull() {
            addCriterion("project_period is null");
            return (Criteria) this;
        }

        public Criteria andProjectPeriodIsNotNull() {
            addCriterion("project_period is not null");
            return (Criteria) this;
        }

        public Criteria andProjectPeriodEqualTo(Integer value) {
            addCriterion("project_period =", value, "projectPeriod");
            return (Criteria) this;
        }

        public Criteria andProjectPeriodNotEqualTo(Integer value) {
            addCriterion("project_period <>", value, "projectPeriod");
            return (Criteria) this;
        }

        public Criteria andProjectPeriodGreaterThan(Integer value) {
            addCriterion("project_period >", value, "projectPeriod");
            return (Criteria) this;
        }

        public Criteria andProjectPeriodGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_period >=", value, "projectPeriod");
            return (Criteria) this;
        }

        public Criteria andProjectPeriodLessThan(Integer value) {
            addCriterion("project_period <", value, "projectPeriod");
            return (Criteria) this;
        }

        public Criteria andProjectPeriodLessThanOrEqualTo(Integer value) {
            addCriterion("project_period <=", value, "projectPeriod");
            return (Criteria) this;
        }

        public Criteria andProjectPeriodIn(List<Integer> values) {
            addCriterion("project_period in", values, "projectPeriod");
            return (Criteria) this;
        }

        public Criteria andProjectPeriodNotIn(List<Integer> values) {
            addCriterion("project_period not in", values, "projectPeriod");
            return (Criteria) this;
        }

        public Criteria andProjectPeriodBetween(Integer value1, Integer value2) {
            addCriterion("project_period between", value1, value2, "projectPeriod");
            return (Criteria) this;
        }

        public Criteria andProjectPeriodNotBetween(Integer value1, Integer value2) {
            addCriterion("project_period not between", value1, value2, "projectPeriod");
            return (Criteria) this;
        }

        public Criteria andInterestRateIsNull() {
            addCriterion("interest_rate is null");
            return (Criteria) this;
        }

        public Criteria andInterestRateIsNotNull() {
            addCriterion("interest_rate is not null");
            return (Criteria) this;
        }

        public Criteria andInterestRateEqualTo(String value) {
            addCriterion("interest_rate =", value, "interestRate");
            return (Criteria) this;
        }

        public Criteria andInterestRateNotEqualTo(String value) {
            addCriterion("interest_rate <>", value, "interestRate");
            return (Criteria) this;
        }

        public Criteria andInterestRateGreaterThan(String value) {
            addCriterion("interest_rate >", value, "interestRate");
            return (Criteria) this;
        }

        public Criteria andInterestRateGreaterThanOrEqualTo(String value) {
            addCriterion("interest_rate >=", value, "interestRate");
            return (Criteria) this;
        }

        public Criteria andInterestRateLessThan(String value) {
            addCriterion("interest_rate <", value, "interestRate");
            return (Criteria) this;
        }

        public Criteria andInterestRateLessThanOrEqualTo(String value) {
            addCriterion("interest_rate <=", value, "interestRate");
            return (Criteria) this;
        }

        public Criteria andInterestRateLike(String value) {
            addCriterion("interest_rate like", value, "interestRate");
            return (Criteria) this;
        }

        public Criteria andInterestRateNotLike(String value) {
            addCriterion("interest_rate not like", value, "interestRate");
            return (Criteria) this;
        }

        public Criteria andInterestRateIn(List<String> values) {
            addCriterion("interest_rate in", values, "interestRate");
            return (Criteria) this;
        }

        public Criteria andInterestRateNotIn(List<String> values) {
            addCriterion("interest_rate not in", values, "interestRate");
            return (Criteria) this;
        }

        public Criteria andInterestRateBetween(String value1, String value2) {
            addCriterion("interest_rate between", value1, value2, "interestRate");
            return (Criteria) this;
        }

        public Criteria andInterestRateNotBetween(String value1, String value2) {
            addCriterion("interest_rate not between", value1, value2, "interestRate");
            return (Criteria) this;
        }

        public Criteria andRepaymentWayIsNull() {
            addCriterion("repayment_way is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentWayIsNotNull() {
            addCriterion("repayment_way is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentWayEqualTo(Boolean value) {
            addCriterion("repayment_way =", value, "repaymentWay");
            return (Criteria) this;
        }

        public Criteria andRepaymentWayNotEqualTo(Boolean value) {
            addCriterion("repayment_way <>", value, "repaymentWay");
            return (Criteria) this;
        }

        public Criteria andRepaymentWayGreaterThan(Boolean value) {
            addCriterion("repayment_way >", value, "repaymentWay");
            return (Criteria) this;
        }

        public Criteria andRepaymentWayGreaterThanOrEqualTo(Boolean value) {
            addCriterion("repayment_way >=", value, "repaymentWay");
            return (Criteria) this;
        }

        public Criteria andRepaymentWayLessThan(Boolean value) {
            addCriterion("repayment_way <", value, "repaymentWay");
            return (Criteria) this;
        }

        public Criteria andRepaymentWayLessThanOrEqualTo(Boolean value) {
            addCriterion("repayment_way <=", value, "repaymentWay");
            return (Criteria) this;
        }

        public Criteria andRepaymentWayIn(List<Boolean> values) {
            addCriterion("repayment_way in", values, "repaymentWay");
            return (Criteria) this;
        }

        public Criteria andRepaymentWayNotIn(List<Boolean> values) {
            addCriterion("repayment_way not in", values, "repaymentWay");
            return (Criteria) this;
        }

        public Criteria andRepaymentWayBetween(Boolean value1, Boolean value2) {
            addCriterion("repayment_way between", value1, value2, "repaymentWay");
            return (Criteria) this;
        }

        public Criteria andRepaymentWayNotBetween(Boolean value1, Boolean value2) {
            addCriterion("repayment_way not between", value1, value2, "repaymentWay");
            return (Criteria) this;
        }

        public Criteria andExtendIsNull() {
            addCriterion("extend is null");
            return (Criteria) this;
        }

        public Criteria andExtendIsNotNull() {
            addCriterion("extend is not null");
            return (Criteria) this;
        }

        public Criteria andExtendEqualTo(String value) {
            addCriterion("extend =", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotEqualTo(String value) {
            addCriterion("extend <>", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendGreaterThan(String value) {
            addCriterion("extend >", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendGreaterThanOrEqualTo(String value) {
            addCriterion("extend >=", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendLessThan(String value) {
            addCriterion("extend <", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendLessThanOrEqualTo(String value) {
            addCriterion("extend <=", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendLike(String value) {
            addCriterion("extend like", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotLike(String value) {
            addCriterion("extend not like", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendIn(List<String> values) {
            addCriterion("extend in", values, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotIn(List<String> values) {
            addCriterion("extend not in", values, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendBetween(String value1, String value2) {
            addCriterion("extend between", value1, value2, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotBetween(String value1, String value2) {
            addCriterion("extend not between", value1, value2, "extend");
            return (Criteria) this;
        }

        public Criteria andProjectStatusIsNull() {
            addCriterion("project_status is null");
            return (Criteria) this;
        }

        public Criteria andProjectStatusIsNotNull() {
            addCriterion("project_status is not null");
            return (Criteria) this;
        }

        public Criteria andProjectStatusEqualTo(Byte value) {
            addCriterion("project_status =", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusNotEqualTo(Byte value) {
            addCriterion("project_status <>", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusGreaterThan(Byte value) {
            addCriterion("project_status >", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("project_status >=", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusLessThan(Byte value) {
            addCriterion("project_status <", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusLessThanOrEqualTo(Byte value) {
            addCriterion("project_status <=", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusIn(List<Byte> values) {
            addCriterion("project_status in", values, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusNotIn(List<Byte> values) {
            addCriterion("project_status not in", values, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusBetween(Byte value1, Byte value2) {
            addCriterion("project_status between", value1, value2, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("project_status not between", value1, value2, "projectStatus");
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
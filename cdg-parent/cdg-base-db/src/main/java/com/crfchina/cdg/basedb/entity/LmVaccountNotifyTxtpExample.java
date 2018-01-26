package com.crfchina.cdg.basedb.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LmVaccountNotifyTxtpExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LmVaccountNotifyTxtpExample() {
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

        public Criteria andLmReturnTrxNoIsNull() {
            addCriterion("lm_return_trx_no is null");
            return (Criteria) this;
        }

        public Criteria andLmReturnTrxNoIsNotNull() {
            addCriterion("lm_return_trx_no is not null");
            return (Criteria) this;
        }

        public Criteria andLmReturnTrxNoEqualTo(String value) {
            addCriterion("lm_return_trx_no =", value, "lmReturnTrxNo");
            return (Criteria) this;
        }

        public Criteria andLmReturnTrxNoNotEqualTo(String value) {
            addCriterion("lm_return_trx_no <>", value, "lmReturnTrxNo");
            return (Criteria) this;
        }

        public Criteria andLmReturnTrxNoGreaterThan(String value) {
            addCriterion("lm_return_trx_no >", value, "lmReturnTrxNo");
            return (Criteria) this;
        }

        public Criteria andLmReturnTrxNoGreaterThanOrEqualTo(String value) {
            addCriterion("lm_return_trx_no >=", value, "lmReturnTrxNo");
            return (Criteria) this;
        }

        public Criteria andLmReturnTrxNoLessThan(String value) {
            addCriterion("lm_return_trx_no <", value, "lmReturnTrxNo");
            return (Criteria) this;
        }

        public Criteria andLmReturnTrxNoLessThanOrEqualTo(String value) {
            addCriterion("lm_return_trx_no <=", value, "lmReturnTrxNo");
            return (Criteria) this;
        }

        public Criteria andLmReturnTrxNoLike(String value) {
            addCriterion("lm_return_trx_no like", value, "lmReturnTrxNo");
            return (Criteria) this;
        }

        public Criteria andLmReturnTrxNoNotLike(String value) {
            addCriterion("lm_return_trx_no not like", value, "lmReturnTrxNo");
            return (Criteria) this;
        }

        public Criteria andLmReturnTrxNoIn(List<String> values) {
            addCriterion("lm_return_trx_no in", values, "lmReturnTrxNo");
            return (Criteria) this;
        }

        public Criteria andLmReturnTrxNoNotIn(List<String> values) {
            addCriterion("lm_return_trx_no not in", values, "lmReturnTrxNo");
            return (Criteria) this;
        }

        public Criteria andLmReturnTrxNoBetween(String value1, String value2) {
            addCriterion("lm_return_trx_no between", value1, value2, "lmReturnTrxNo");
            return (Criteria) this;
        }

        public Criteria andLmReturnTrxNoNotBetween(String value1, String value2) {
            addCriterion("lm_return_trx_no not between", value1, value2, "lmReturnTrxNo");
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

        public Criteria andRollbackAmountIsNull() {
            addCriterion("rollback_amount is null");
            return (Criteria) this;
        }

        public Criteria andRollbackAmountIsNotNull() {
            addCriterion("rollback_amount is not null");
            return (Criteria) this;
        }

        public Criteria andRollbackAmountEqualTo(String value) {
            addCriterion("rollback_amount =", value, "rollbackAmount");
            return (Criteria) this;
        }

        public Criteria andRollbackAmountNotEqualTo(String value) {
            addCriterion("rollback_amount <>", value, "rollbackAmount");
            return (Criteria) this;
        }

        public Criteria andRollbackAmountGreaterThan(String value) {
            addCriterion("rollback_amount >", value, "rollbackAmount");
            return (Criteria) this;
        }

        public Criteria andRollbackAmountGreaterThanOrEqualTo(String value) {
            addCriterion("rollback_amount >=", value, "rollbackAmount");
            return (Criteria) this;
        }

        public Criteria andRollbackAmountLessThan(String value) {
            addCriterion("rollback_amount <", value, "rollbackAmount");
            return (Criteria) this;
        }

        public Criteria andRollbackAmountLessThanOrEqualTo(String value) {
            addCriterion("rollback_amount <=", value, "rollbackAmount");
            return (Criteria) this;
        }

        public Criteria andRollbackAmountLike(String value) {
            addCriterion("rollback_amount like", value, "rollbackAmount");
            return (Criteria) this;
        }

        public Criteria andRollbackAmountNotLike(String value) {
            addCriterion("rollback_amount not like", value, "rollbackAmount");
            return (Criteria) this;
        }

        public Criteria andRollbackAmountIn(List<String> values) {
            addCriterion("rollback_amount in", values, "rollbackAmount");
            return (Criteria) this;
        }

        public Criteria andRollbackAmountNotIn(List<String> values) {
            addCriterion("rollback_amount not in", values, "rollbackAmount");
            return (Criteria) this;
        }

        public Criteria andRollbackAmountBetween(String value1, String value2) {
            addCriterion("rollback_amount between", value1, value2, "rollbackAmount");
            return (Criteria) this;
        }

        public Criteria andRollbackAmountNotBetween(String value1, String value2) {
            addCriterion("rollback_amount not between", value1, value2, "rollbackAmount");
            return (Criteria) this;
        }

        public Criteria andRollbackCommAmountIsNull() {
            addCriterion("rollback_comm_amount is null");
            return (Criteria) this;
        }

        public Criteria andRollbackCommAmountIsNotNull() {
            addCriterion("rollback_comm_amount is not null");
            return (Criteria) this;
        }

        public Criteria andRollbackCommAmountEqualTo(String value) {
            addCriterion("rollback_comm_amount =", value, "rollbackCommAmount");
            return (Criteria) this;
        }

        public Criteria andRollbackCommAmountNotEqualTo(String value) {
            addCriterion("rollback_comm_amount <>", value, "rollbackCommAmount");
            return (Criteria) this;
        }

        public Criteria andRollbackCommAmountGreaterThan(String value) {
            addCriterion("rollback_comm_amount >", value, "rollbackCommAmount");
            return (Criteria) this;
        }

        public Criteria andRollbackCommAmountGreaterThanOrEqualTo(String value) {
            addCriterion("rollback_comm_amount >=", value, "rollbackCommAmount");
            return (Criteria) this;
        }

        public Criteria andRollbackCommAmountLessThan(String value) {
            addCriterion("rollback_comm_amount <", value, "rollbackCommAmount");
            return (Criteria) this;
        }

        public Criteria andRollbackCommAmountLessThanOrEqualTo(String value) {
            addCriterion("rollback_comm_amount <=", value, "rollbackCommAmount");
            return (Criteria) this;
        }

        public Criteria andRollbackCommAmountLike(String value) {
            addCriterion("rollback_comm_amount like", value, "rollbackCommAmount");
            return (Criteria) this;
        }

        public Criteria andRollbackCommAmountNotLike(String value) {
            addCriterion("rollback_comm_amount not like", value, "rollbackCommAmount");
            return (Criteria) this;
        }

        public Criteria andRollbackCommAmountIn(List<String> values) {
            addCriterion("rollback_comm_amount in", values, "rollbackCommAmount");
            return (Criteria) this;
        }

        public Criteria andRollbackCommAmountNotIn(List<String> values) {
            addCriterion("rollback_comm_amount not in", values, "rollbackCommAmount");
            return (Criteria) this;
        }

        public Criteria andRollbackCommAmountBetween(String value1, String value2) {
            addCriterion("rollback_comm_amount between", value1, value2, "rollbackCommAmount");
            return (Criteria) this;
        }

        public Criteria andRollbackCommAmountNotBetween(String value1, String value2) {
            addCriterion("rollback_comm_amount not between", value1, value2, "rollbackCommAmount");
            return (Criteria) this;
        }

        public Criteria andCompletedTimeIsNull() {
            addCriterion("completed_time is null");
            return (Criteria) this;
        }

        public Criteria andCompletedTimeIsNotNull() {
            addCriterion("completed_time is not null");
            return (Criteria) this;
        }

        public Criteria andCompletedTimeEqualTo(Date value) {
            addCriterion("completed_time =", value, "completedTime");
            return (Criteria) this;
        }

        public Criteria andCompletedTimeNotEqualTo(Date value) {
            addCriterion("completed_time <>", value, "completedTime");
            return (Criteria) this;
        }

        public Criteria andCompletedTimeGreaterThan(Date value) {
            addCriterion("completed_time >", value, "completedTime");
            return (Criteria) this;
        }

        public Criteria andCompletedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("completed_time >=", value, "completedTime");
            return (Criteria) this;
        }

        public Criteria andCompletedTimeLessThan(Date value) {
            addCriterion("completed_time <", value, "completedTime");
            return (Criteria) this;
        }

        public Criteria andCompletedTimeLessThanOrEqualTo(Date value) {
            addCriterion("completed_time <=", value, "completedTime");
            return (Criteria) this;
        }

        public Criteria andCompletedTimeIn(List<Date> values) {
            addCriterion("completed_time in", values, "completedTime");
            return (Criteria) this;
        }

        public Criteria andCompletedTimeNotIn(List<Date> values) {
            addCriterion("completed_time not in", values, "completedTime");
            return (Criteria) this;
        }

        public Criteria andCompletedTimeBetween(Date value1, Date value2) {
            addCriterion("completed_time between", value1, value2, "completedTime");
            return (Criteria) this;
        }

        public Criteria andCompletedTimeNotBetween(Date value1, Date value2) {
            addCriterion("completed_time not between", value1, value2, "completedTime");
            return (Criteria) this;
        }

        public Criteria andRollbackStatusIsNull() {
            addCriterion("rollback_status is null");
            return (Criteria) this;
        }

        public Criteria andRollbackStatusIsNotNull() {
            addCriterion("rollback_status is not null");
            return (Criteria) this;
        }

        public Criteria andRollbackStatusEqualTo(String value) {
            addCriterion("rollback_status =", value, "rollbackStatus");
            return (Criteria) this;
        }

        public Criteria andRollbackStatusNotEqualTo(String value) {
            addCriterion("rollback_status <>", value, "rollbackStatus");
            return (Criteria) this;
        }

        public Criteria andRollbackStatusGreaterThan(String value) {
            addCriterion("rollback_status >", value, "rollbackStatus");
            return (Criteria) this;
        }

        public Criteria andRollbackStatusGreaterThanOrEqualTo(String value) {
            addCriterion("rollback_status >=", value, "rollbackStatus");
            return (Criteria) this;
        }

        public Criteria andRollbackStatusLessThan(String value) {
            addCriterion("rollback_status <", value, "rollbackStatus");
            return (Criteria) this;
        }

        public Criteria andRollbackStatusLessThanOrEqualTo(String value) {
            addCriterion("rollback_status <=", value, "rollbackStatus");
            return (Criteria) this;
        }

        public Criteria andRollbackStatusLike(String value) {
            addCriterion("rollback_status like", value, "rollbackStatus");
            return (Criteria) this;
        }

        public Criteria andRollbackStatusNotLike(String value) {
            addCriterion("rollback_status not like", value, "rollbackStatus");
            return (Criteria) this;
        }

        public Criteria andRollbackStatusIn(List<String> values) {
            addCriterion("rollback_status in", values, "rollbackStatus");
            return (Criteria) this;
        }

        public Criteria andRollbackStatusNotIn(List<String> values) {
            addCriterion("rollback_status not in", values, "rollbackStatus");
            return (Criteria) this;
        }

        public Criteria andRollbackStatusBetween(String value1, String value2) {
            addCriterion("rollback_status between", value1, value2, "rollbackStatus");
            return (Criteria) this;
        }

        public Criteria andRollbackStatusNotBetween(String value1, String value2) {
            addCriterion("rollback_status not between", value1, value2, "rollbackStatus");
            return (Criteria) this;
        }

        public Criteria andRollbackTypeIsNull() {
            addCriterion("rollback_type is null");
            return (Criteria) this;
        }

        public Criteria andRollbackTypeIsNotNull() {
            addCriterion("rollback_type is not null");
            return (Criteria) this;
        }

        public Criteria andRollbackTypeEqualTo(String value) {
            addCriterion("rollback_type =", value, "rollbackType");
            return (Criteria) this;
        }

        public Criteria andRollbackTypeNotEqualTo(String value) {
            addCriterion("rollback_type <>", value, "rollbackType");
            return (Criteria) this;
        }

        public Criteria andRollbackTypeGreaterThan(String value) {
            addCriterion("rollback_type >", value, "rollbackType");
            return (Criteria) this;
        }

        public Criteria andRollbackTypeGreaterThanOrEqualTo(String value) {
            addCriterion("rollback_type >=", value, "rollbackType");
            return (Criteria) this;
        }

        public Criteria andRollbackTypeLessThan(String value) {
            addCriterion("rollback_type <", value, "rollbackType");
            return (Criteria) this;
        }

        public Criteria andRollbackTypeLessThanOrEqualTo(String value) {
            addCriterion("rollback_type <=", value, "rollbackType");
            return (Criteria) this;
        }

        public Criteria andRollbackTypeLike(String value) {
            addCriterion("rollback_type like", value, "rollbackType");
            return (Criteria) this;
        }

        public Criteria andRollbackTypeNotLike(String value) {
            addCriterion("rollback_type not like", value, "rollbackType");
            return (Criteria) this;
        }

        public Criteria andRollbackTypeIn(List<String> values) {
            addCriterion("rollback_type in", values, "rollbackType");
            return (Criteria) this;
        }

        public Criteria andRollbackTypeNotIn(List<String> values) {
            addCriterion("rollback_type not in", values, "rollbackType");
            return (Criteria) this;
        }

        public Criteria andRollbackTypeBetween(String value1, String value2) {
            addCriterion("rollback_type between", value1, value2, "rollbackType");
            return (Criteria) this;
        }

        public Criteria andRollbackTypeNotBetween(String value1, String value2) {
            addCriterion("rollback_type not between", value1, value2, "rollbackType");
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

        public Criteria andDoneTimeIsNull() {
            addCriterion("done_time is null");
            return (Criteria) this;
        }

        public Criteria andDoneTimeIsNotNull() {
            addCriterion("done_time is not null");
            return (Criteria) this;
        }

        public Criteria andDoneTimeEqualTo(Date value) {
            addCriterion("done_time =", value, "doneTime");
            return (Criteria) this;
        }

        public Criteria andDoneTimeNotEqualTo(Date value) {
            addCriterion("done_time <>", value, "doneTime");
            return (Criteria) this;
        }

        public Criteria andDoneTimeGreaterThan(Date value) {
            addCriterion("done_time >", value, "doneTime");
            return (Criteria) this;
        }

        public Criteria andDoneTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("done_time >=", value, "doneTime");
            return (Criteria) this;
        }

        public Criteria andDoneTimeLessThan(Date value) {
            addCriterion("done_time <", value, "doneTime");
            return (Criteria) this;
        }

        public Criteria andDoneTimeLessThanOrEqualTo(Date value) {
            addCriterion("done_time <=", value, "doneTime");
            return (Criteria) this;
        }

        public Criteria andDoneTimeIn(List<Date> values) {
            addCriterion("done_time in", values, "doneTime");
            return (Criteria) this;
        }

        public Criteria andDoneTimeNotIn(List<Date> values) {
            addCriterion("done_time not in", values, "doneTime");
            return (Criteria) this;
        }

        public Criteria andDoneTimeBetween(Date value1, Date value2) {
            addCriterion("done_time between", value1, value2, "doneTime");
            return (Criteria) this;
        }

        public Criteria andDoneTimeNotBetween(Date value1, Date value2) {
            addCriterion("done_time not between", value1, value2, "doneTime");
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
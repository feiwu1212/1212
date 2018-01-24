package com.crfchina.cdg.basedb.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LmTransferReckonDtlExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LmTransferReckonDtlExample() {
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

        public Criteria andReckonIdIsNull() {
            addCriterion("reckon_id is null");
            return (Criteria) this;
        }

        public Criteria andReckonIdIsNotNull() {
            addCriterion("reckon_id is not null");
            return (Criteria) this;
        }

        public Criteria andReckonIdEqualTo(String value) {
            addCriterion("reckon_id =", value, "reckonId");
            return (Criteria) this;
        }

        public Criteria andReckonIdNotEqualTo(String value) {
            addCriterion("reckon_id <>", value, "reckonId");
            return (Criteria) this;
        }

        public Criteria andReckonIdGreaterThan(String value) {
            addCriterion("reckon_id >", value, "reckonId");
            return (Criteria) this;
        }

        public Criteria andReckonIdGreaterThanOrEqualTo(String value) {
            addCriterion("reckon_id >=", value, "reckonId");
            return (Criteria) this;
        }

        public Criteria andReckonIdLessThan(String value) {
            addCriterion("reckon_id <", value, "reckonId");
            return (Criteria) this;
        }

        public Criteria andReckonIdLessThanOrEqualTo(String value) {
            addCriterion("reckon_id <=", value, "reckonId");
            return (Criteria) this;
        }

        public Criteria andReckonIdLike(String value) {
            addCriterion("reckon_id like", value, "reckonId");
            return (Criteria) this;
        }

        public Criteria andReckonIdNotLike(String value) {
            addCriterion("reckon_id not like", value, "reckonId");
            return (Criteria) this;
        }

        public Criteria andReckonIdIn(List<String> values) {
            addCriterion("reckon_id in", values, "reckonId");
            return (Criteria) this;
        }

        public Criteria andReckonIdNotIn(List<String> values) {
            addCriterion("reckon_id not in", values, "reckonId");
            return (Criteria) this;
        }

        public Criteria andReckonIdBetween(String value1, String value2) {
            addCriterion("reckon_id between", value1, value2, "reckonId");
            return (Criteria) this;
        }

        public Criteria andReckonIdNotBetween(String value1, String value2) {
            addCriterion("reckon_id not between", value1, value2, "reckonId");
            return (Criteria) this;
        }

        public Criteria andReckonDateIsNull() {
            addCriterion("reckon_date is null");
            return (Criteria) this;
        }

        public Criteria andReckonDateIsNotNull() {
            addCriterion("reckon_date is not null");
            return (Criteria) this;
        }

        public Criteria andReckonDateEqualTo(String value) {
            addCriterion("reckon_date =", value, "reckonDate");
            return (Criteria) this;
        }

        public Criteria andReckonDateNotEqualTo(String value) {
            addCriterion("reckon_date <>", value, "reckonDate");
            return (Criteria) this;
        }

        public Criteria andReckonDateGreaterThan(String value) {
            addCriterion("reckon_date >", value, "reckonDate");
            return (Criteria) this;
        }

        public Criteria andReckonDateGreaterThanOrEqualTo(String value) {
            addCriterion("reckon_date >=", value, "reckonDate");
            return (Criteria) this;
        }

        public Criteria andReckonDateLessThan(String value) {
            addCriterion("reckon_date <", value, "reckonDate");
            return (Criteria) this;
        }

        public Criteria andReckonDateLessThanOrEqualTo(String value) {
            addCriterion("reckon_date <=", value, "reckonDate");
            return (Criteria) this;
        }

        public Criteria andReckonDateLike(String value) {
            addCriterion("reckon_date like", value, "reckonDate");
            return (Criteria) this;
        }

        public Criteria andReckonDateNotLike(String value) {
            addCriterion("reckon_date not like", value, "reckonDate");
            return (Criteria) this;
        }

        public Criteria andReckonDateIn(List<String> values) {
            addCriterion("reckon_date in", values, "reckonDate");
            return (Criteria) this;
        }

        public Criteria andReckonDateNotIn(List<String> values) {
            addCriterion("reckon_date not in", values, "reckonDate");
            return (Criteria) this;
        }

        public Criteria andReckonDateBetween(String value1, String value2) {
            addCriterion("reckon_date between", value1, value2, "reckonDate");
            return (Criteria) this;
        }

        public Criteria andReckonDateNotBetween(String value1, String value2) {
            addCriterion("reckon_date not between", value1, value2, "reckonDate");
            return (Criteria) this;
        }

        public Criteria andReckonTypeIsNull() {
            addCriterion("reckon_type is null");
            return (Criteria) this;
        }

        public Criteria andReckonTypeIsNotNull() {
            addCriterion("reckon_type is not null");
            return (Criteria) this;
        }

        public Criteria andReckonTypeEqualTo(String value) {
            addCriterion("reckon_type =", value, "reckonType");
            return (Criteria) this;
        }

        public Criteria andReckonTypeNotEqualTo(String value) {
            addCriterion("reckon_type <>", value, "reckonType");
            return (Criteria) this;
        }

        public Criteria andReckonTypeGreaterThan(String value) {
            addCriterion("reckon_type >", value, "reckonType");
            return (Criteria) this;
        }

        public Criteria andReckonTypeGreaterThanOrEqualTo(String value) {
            addCriterion("reckon_type >=", value, "reckonType");
            return (Criteria) this;
        }

        public Criteria andReckonTypeLessThan(String value) {
            addCriterion("reckon_type <", value, "reckonType");
            return (Criteria) this;
        }

        public Criteria andReckonTypeLessThanOrEqualTo(String value) {
            addCriterion("reckon_type <=", value, "reckonType");
            return (Criteria) this;
        }

        public Criteria andReckonTypeLike(String value) {
            addCriterion("reckon_type like", value, "reckonType");
            return (Criteria) this;
        }

        public Criteria andReckonTypeNotLike(String value) {
            addCriterion("reckon_type not like", value, "reckonType");
            return (Criteria) this;
        }

        public Criteria andReckonTypeIn(List<String> values) {
            addCriterion("reckon_type in", values, "reckonType");
            return (Criteria) this;
        }

        public Criteria andReckonTypeNotIn(List<String> values) {
            addCriterion("reckon_type not in", values, "reckonType");
            return (Criteria) this;
        }

        public Criteria andReckonTypeBetween(String value1, String value2) {
            addCriterion("reckon_type between", value1, value2, "reckonType");
            return (Criteria) this;
        }

        public Criteria andReckonTypeNotBetween(String value1, String value2) {
            addCriterion("reckon_type not between", value1, value2, "reckonType");
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

        public Criteria andLmOrderNoIsNull() {
            addCriterion("lm_order_no is null");
            return (Criteria) this;
        }

        public Criteria andLmOrderNoIsNotNull() {
            addCriterion("lm_order_no is not null");
            return (Criteria) this;
        }

        public Criteria andLmOrderNoEqualTo(String value) {
            addCriterion("lm_order_no =", value, "lmOrderNo");
            return (Criteria) this;
        }

        public Criteria andLmOrderNoNotEqualTo(String value) {
            addCriterion("lm_order_no <>", value, "lmOrderNo");
            return (Criteria) this;
        }

        public Criteria andLmOrderNoGreaterThan(String value) {
            addCriterion("lm_order_no >", value, "lmOrderNo");
            return (Criteria) this;
        }

        public Criteria andLmOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("lm_order_no >=", value, "lmOrderNo");
            return (Criteria) this;
        }

        public Criteria andLmOrderNoLessThan(String value) {
            addCriterion("lm_order_no <", value, "lmOrderNo");
            return (Criteria) this;
        }

        public Criteria andLmOrderNoLessThanOrEqualTo(String value) {
            addCriterion("lm_order_no <=", value, "lmOrderNo");
            return (Criteria) this;
        }

        public Criteria andLmOrderNoLike(String value) {
            addCriterion("lm_order_no like", value, "lmOrderNo");
            return (Criteria) this;
        }

        public Criteria andLmOrderNoNotLike(String value) {
            addCriterion("lm_order_no not like", value, "lmOrderNo");
            return (Criteria) this;
        }

        public Criteria andLmOrderNoIn(List<String> values) {
            addCriterion("lm_order_no in", values, "lmOrderNo");
            return (Criteria) this;
        }

        public Criteria andLmOrderNoNotIn(List<String> values) {
            addCriterion("lm_order_no not in", values, "lmOrderNo");
            return (Criteria) this;
        }

        public Criteria andLmOrderNoBetween(String value1, String value2) {
            addCriterion("lm_order_no between", value1, value2, "lmOrderNo");
            return (Criteria) this;
        }

        public Criteria andLmOrderNoNotBetween(String value1, String value2) {
            addCriterion("lm_order_no not between", value1, value2, "lmOrderNo");
            return (Criteria) this;
        }

        public Criteria andTransferAmountIsNull() {
            addCriterion("transfer_amount is null");
            return (Criteria) this;
        }

        public Criteria andTransferAmountIsNotNull() {
            addCriterion("transfer_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTransferAmountEqualTo(String value) {
            addCriterion("transfer_amount =", value, "transferAmount");
            return (Criteria) this;
        }

        public Criteria andTransferAmountNotEqualTo(String value) {
            addCriterion("transfer_amount <>", value, "transferAmount");
            return (Criteria) this;
        }

        public Criteria andTransferAmountGreaterThan(String value) {
            addCriterion("transfer_amount >", value, "transferAmount");
            return (Criteria) this;
        }

        public Criteria andTransferAmountGreaterThanOrEqualTo(String value) {
            addCriterion("transfer_amount >=", value, "transferAmount");
            return (Criteria) this;
        }

        public Criteria andTransferAmountLessThan(String value) {
            addCriterion("transfer_amount <", value, "transferAmount");
            return (Criteria) this;
        }

        public Criteria andTransferAmountLessThanOrEqualTo(String value) {
            addCriterion("transfer_amount <=", value, "transferAmount");
            return (Criteria) this;
        }

        public Criteria andTransferAmountLike(String value) {
            addCriterion("transfer_amount like", value, "transferAmount");
            return (Criteria) this;
        }

        public Criteria andTransferAmountNotLike(String value) {
            addCriterion("transfer_amount not like", value, "transferAmount");
            return (Criteria) this;
        }

        public Criteria andTransferAmountIn(List<String> values) {
            addCriterion("transfer_amount in", values, "transferAmount");
            return (Criteria) this;
        }

        public Criteria andTransferAmountNotIn(List<String> values) {
            addCriterion("transfer_amount not in", values, "transferAmount");
            return (Criteria) this;
        }

        public Criteria andTransferAmountBetween(String value1, String value2) {
            addCriterion("transfer_amount between", value1, value2, "transferAmount");
            return (Criteria) this;
        }

        public Criteria andTransferAmountNotBetween(String value1, String value2) {
            addCriterion("transfer_amount not between", value1, value2, "transferAmount");
            return (Criteria) this;
        }

        public Criteria andAccountDateIsNull() {
            addCriterion("account_date is null");
            return (Criteria) this;
        }

        public Criteria andAccountDateIsNotNull() {
            addCriterion("account_date is not null");
            return (Criteria) this;
        }

        public Criteria andAccountDateEqualTo(Date value) {
            addCriterion("account_date =", value, "accountDate");
            return (Criteria) this;
        }

        public Criteria andAccountDateNotEqualTo(Date value) {
            addCriterion("account_date <>", value, "accountDate");
            return (Criteria) this;
        }

        public Criteria andAccountDateGreaterThan(Date value) {
            addCriterion("account_date >", value, "accountDate");
            return (Criteria) this;
        }

        public Criteria andAccountDateGreaterThanOrEqualTo(Date value) {
            addCriterion("account_date >=", value, "accountDate");
            return (Criteria) this;
        }

        public Criteria andAccountDateLessThan(Date value) {
            addCriterion("account_date <", value, "accountDate");
            return (Criteria) this;
        }

        public Criteria andAccountDateLessThanOrEqualTo(Date value) {
            addCriterion("account_date <=", value, "accountDate");
            return (Criteria) this;
        }

        public Criteria andAccountDateIn(List<Date> values) {
            addCriterion("account_date in", values, "accountDate");
            return (Criteria) this;
        }

        public Criteria andAccountDateNotIn(List<Date> values) {
            addCriterion("account_date not in", values, "accountDate");
            return (Criteria) this;
        }

        public Criteria andAccountDateBetween(Date value1, Date value2) {
            addCriterion("account_date between", value1, value2, "accountDate");
            return (Criteria) this;
        }

        public Criteria andAccountDateNotBetween(Date value1, Date value2) {
            addCriterion("account_date not between", value1, value2, "accountDate");
            return (Criteria) this;
        }

        public Criteria andLmBizTypeIsNull() {
            addCriterion("lm_biz_type is null");
            return (Criteria) this;
        }

        public Criteria andLmBizTypeIsNotNull() {
            addCriterion("lm_biz_type is not null");
            return (Criteria) this;
        }

        public Criteria andLmBizTypeEqualTo(String value) {
            addCriterion("lm_biz_type =", value, "lmBizType");
            return (Criteria) this;
        }

        public Criteria andLmBizTypeNotEqualTo(String value) {
            addCriterion("lm_biz_type <>", value, "lmBizType");
            return (Criteria) this;
        }

        public Criteria andLmBizTypeGreaterThan(String value) {
            addCriterion("lm_biz_type >", value, "lmBizType");
            return (Criteria) this;
        }

        public Criteria andLmBizTypeGreaterThanOrEqualTo(String value) {
            addCriterion("lm_biz_type >=", value, "lmBizType");
            return (Criteria) this;
        }

        public Criteria andLmBizTypeLessThan(String value) {
            addCriterion("lm_biz_type <", value, "lmBizType");
            return (Criteria) this;
        }

        public Criteria andLmBizTypeLessThanOrEqualTo(String value) {
            addCriterion("lm_biz_type <=", value, "lmBizType");
            return (Criteria) this;
        }

        public Criteria andLmBizTypeLike(String value) {
            addCriterion("lm_biz_type like", value, "lmBizType");
            return (Criteria) this;
        }

        public Criteria andLmBizTypeNotLike(String value) {
            addCriterion("lm_biz_type not like", value, "lmBizType");
            return (Criteria) this;
        }

        public Criteria andLmBizTypeIn(List<String> values) {
            addCriterion("lm_biz_type in", values, "lmBizType");
            return (Criteria) this;
        }

        public Criteria andLmBizTypeNotIn(List<String> values) {
            addCriterion("lm_biz_type not in", values, "lmBizType");
            return (Criteria) this;
        }

        public Criteria andLmBizTypeBetween(String value1, String value2) {
            addCriterion("lm_biz_type between", value1, value2, "lmBizType");
            return (Criteria) this;
        }

        public Criteria andLmBizTypeNotBetween(String value1, String value2) {
            addCriterion("lm_biz_type not between", value1, value2, "lmBizType");
            return (Criteria) this;
        }

        public Criteria andCrfBizTypeIsNull() {
            addCriterion("crf_biz_type is null");
            return (Criteria) this;
        }

        public Criteria andCrfBizTypeIsNotNull() {
            addCriterion("crf_biz_type is not null");
            return (Criteria) this;
        }

        public Criteria andCrfBizTypeEqualTo(String value) {
            addCriterion("crf_biz_type =", value, "crfBizType");
            return (Criteria) this;
        }

        public Criteria andCrfBizTypeNotEqualTo(String value) {
            addCriterion("crf_biz_type <>", value, "crfBizType");
            return (Criteria) this;
        }

        public Criteria andCrfBizTypeGreaterThan(String value) {
            addCriterion("crf_biz_type >", value, "crfBizType");
            return (Criteria) this;
        }

        public Criteria andCrfBizTypeGreaterThanOrEqualTo(String value) {
            addCriterion("crf_biz_type >=", value, "crfBizType");
            return (Criteria) this;
        }

        public Criteria andCrfBizTypeLessThan(String value) {
            addCriterion("crf_biz_type <", value, "crfBizType");
            return (Criteria) this;
        }

        public Criteria andCrfBizTypeLessThanOrEqualTo(String value) {
            addCriterion("crf_biz_type <=", value, "crfBizType");
            return (Criteria) this;
        }

        public Criteria andCrfBizTypeLike(String value) {
            addCriterion("crf_biz_type like", value, "crfBizType");
            return (Criteria) this;
        }

        public Criteria andCrfBizTypeNotLike(String value) {
            addCriterion("crf_biz_type not like", value, "crfBizType");
            return (Criteria) this;
        }

        public Criteria andCrfBizTypeIn(List<String> values) {
            addCriterion("crf_biz_type in", values, "crfBizType");
            return (Criteria) this;
        }

        public Criteria andCrfBizTypeNotIn(List<String> values) {
            addCriterion("crf_biz_type not in", values, "crfBizType");
            return (Criteria) this;
        }

        public Criteria andCrfBizTypeBetween(String value1, String value2) {
            addCriterion("crf_biz_type between", value1, value2, "crfBizType");
            return (Criteria) this;
        }

        public Criteria andCrfBizTypeNotBetween(String value1, String value2) {
            addCriterion("crf_biz_type not between", value1, value2, "crfBizType");
            return (Criteria) this;
        }

        public Criteria andMiscIsNull() {
            addCriterion("misc is null");
            return (Criteria) this;
        }

        public Criteria andMiscIsNotNull() {
            addCriterion("misc is not null");
            return (Criteria) this;
        }

        public Criteria andMiscEqualTo(String value) {
            addCriterion("misc =", value, "misc");
            return (Criteria) this;
        }

        public Criteria andMiscNotEqualTo(String value) {
            addCriterion("misc <>", value, "misc");
            return (Criteria) this;
        }

        public Criteria andMiscGreaterThan(String value) {
            addCriterion("misc >", value, "misc");
            return (Criteria) this;
        }

        public Criteria andMiscGreaterThanOrEqualTo(String value) {
            addCriterion("misc >=", value, "misc");
            return (Criteria) this;
        }

        public Criteria andMiscLessThan(String value) {
            addCriterion("misc <", value, "misc");
            return (Criteria) this;
        }

        public Criteria andMiscLessThanOrEqualTo(String value) {
            addCriterion("misc <=", value, "misc");
            return (Criteria) this;
        }

        public Criteria andMiscLike(String value) {
            addCriterion("misc like", value, "misc");
            return (Criteria) this;
        }

        public Criteria andMiscNotLike(String value) {
            addCriterion("misc not like", value, "misc");
            return (Criteria) this;
        }

        public Criteria andMiscIn(List<String> values) {
            addCriterion("misc in", values, "misc");
            return (Criteria) this;
        }

        public Criteria andMiscNotIn(List<String> values) {
            addCriterion("misc not in", values, "misc");
            return (Criteria) this;
        }

        public Criteria andMiscBetween(String value1, String value2) {
            addCriterion("misc between", value1, value2, "misc");
            return (Criteria) this;
        }

        public Criteria andMiscNotBetween(String value1, String value2) {
            addCriterion("misc not between", value1, value2, "misc");
            return (Criteria) this;
        }

        public Criteria andStatueIsNull() {
            addCriterion("statue is null");
            return (Criteria) this;
        }

        public Criteria andStatueIsNotNull() {
            addCriterion("statue is not null");
            return (Criteria) this;
        }

        public Criteria andStatueEqualTo(Boolean value) {
            addCriterion("statue =", value, "statue");
            return (Criteria) this;
        }

        public Criteria andStatueNotEqualTo(Boolean value) {
            addCriterion("statue <>", value, "statue");
            return (Criteria) this;
        }

        public Criteria andStatueGreaterThan(Boolean value) {
            addCriterion("statue >", value, "statue");
            return (Criteria) this;
        }

        public Criteria andStatueGreaterThanOrEqualTo(Boolean value) {
            addCriterion("statue >=", value, "statue");
            return (Criteria) this;
        }

        public Criteria andStatueLessThan(Boolean value) {
            addCriterion("statue <", value, "statue");
            return (Criteria) this;
        }

        public Criteria andStatueLessThanOrEqualTo(Boolean value) {
            addCriterion("statue <=", value, "statue");
            return (Criteria) this;
        }

        public Criteria andStatueIn(List<Boolean> values) {
            addCriterion("statue in", values, "statue");
            return (Criteria) this;
        }

        public Criteria andStatueNotIn(List<Boolean> values) {
            addCriterion("statue not in", values, "statue");
            return (Criteria) this;
        }

        public Criteria andStatueBetween(Boolean value1, Boolean value2) {
            addCriterion("statue between", value1, value2, "statue");
            return (Criteria) this;
        }

        public Criteria andStatueNotBetween(Boolean value1, Boolean value2) {
            addCriterion("statue not between", value1, value2, "statue");
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
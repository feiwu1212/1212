package com.crfchina.cdg.basedb.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LmVaccountTransferInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LmVaccountTransferInfoExample() {
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

        public Criteria andBatchNoIsNull() {
            addCriterion("batch_no is null");
            return (Criteria) this;
        }

        public Criteria andBatchNoIsNotNull() {
            addCriterion("batch_no is not null");
            return (Criteria) this;
        }

        public Criteria andBatchNoEqualTo(String value) {
            addCriterion("batch_no =", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotEqualTo(String value) {
            addCriterion("batch_no <>", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoGreaterThan(String value) {
            addCriterion("batch_no >", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoGreaterThanOrEqualTo(String value) {
            addCriterion("batch_no >=", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLessThan(String value) {
            addCriterion("batch_no <", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLessThanOrEqualTo(String value) {
            addCriterion("batch_no <=", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLike(String value) {
            addCriterion("batch_no like", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotLike(String value) {
            addCriterion("batch_no not like", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoIn(List<String> values) {
            addCriterion("batch_no in", values, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotIn(List<String> values) {
            addCriterion("batch_no not in", values, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoBetween(String value1, String value2) {
            addCriterion("batch_no between", value1, value2, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotBetween(String value1, String value2) {
            addCriterion("batch_no not between", value1, value2, "batchNo");
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

        public Criteria andChannelFeeAmountIsNull() {
            addCriterion("channel_fee_amount is null");
            return (Criteria) this;
        }

        public Criteria andChannelFeeAmountIsNotNull() {
            addCriterion("channel_fee_amount is not null");
            return (Criteria) this;
        }

        public Criteria andChannelFeeAmountEqualTo(String value) {
            addCriterion("channel_fee_amount =", value, "channelFeeAmount");
            return (Criteria) this;
        }

        public Criteria andChannelFeeAmountNotEqualTo(String value) {
            addCriterion("channel_fee_amount <>", value, "channelFeeAmount");
            return (Criteria) this;
        }

        public Criteria andChannelFeeAmountGreaterThan(String value) {
            addCriterion("channel_fee_amount >", value, "channelFeeAmount");
            return (Criteria) this;
        }

        public Criteria andChannelFeeAmountGreaterThanOrEqualTo(String value) {
            addCriterion("channel_fee_amount >=", value, "channelFeeAmount");
            return (Criteria) this;
        }

        public Criteria andChannelFeeAmountLessThan(String value) {
            addCriterion("channel_fee_amount <", value, "channelFeeAmount");
            return (Criteria) this;
        }

        public Criteria andChannelFeeAmountLessThanOrEqualTo(String value) {
            addCriterion("channel_fee_amount <=", value, "channelFeeAmount");
            return (Criteria) this;
        }

        public Criteria andChannelFeeAmountLike(String value) {
            addCriterion("channel_fee_amount like", value, "channelFeeAmount");
            return (Criteria) this;
        }

        public Criteria andChannelFeeAmountNotLike(String value) {
            addCriterion("channel_fee_amount not like", value, "channelFeeAmount");
            return (Criteria) this;
        }

        public Criteria andChannelFeeAmountIn(List<String> values) {
            addCriterion("channel_fee_amount in", values, "channelFeeAmount");
            return (Criteria) this;
        }

        public Criteria andChannelFeeAmountNotIn(List<String> values) {
            addCriterion("channel_fee_amount not in", values, "channelFeeAmount");
            return (Criteria) this;
        }

        public Criteria andChannelFeeAmountBetween(String value1, String value2) {
            addCriterion("channel_fee_amount between", value1, value2, "channelFeeAmount");
            return (Criteria) this;
        }

        public Criteria andChannelFeeAmountNotBetween(String value1, String value2) {
            addCriterion("channel_fee_amount not between", value1, value2, "channelFeeAmount");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNull() {
            addCriterion("currency is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNotNull() {
            addCriterion("currency is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyEqualTo(Boolean value) {
            addCriterion("currency =", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotEqualTo(Boolean value) {
            addCriterion("currency <>", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThan(Boolean value) {
            addCriterion("currency >", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThanOrEqualTo(Boolean value) {
            addCriterion("currency >=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThan(Boolean value) {
            addCriterion("currency <", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThanOrEqualTo(Boolean value) {
            addCriterion("currency <=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyIn(List<Boolean> values) {
            addCriterion("currency in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotIn(List<Boolean> values) {
            addCriterion("currency not in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyBetween(Boolean value1, Boolean value2) {
            addCriterion("currency between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotBetween(Boolean value1, Boolean value2) {
            addCriterion("currency not between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andOutRealNameIsNull() {
            addCriterion("out_real_name is null");
            return (Criteria) this;
        }

        public Criteria andOutRealNameIsNotNull() {
            addCriterion("out_real_name is not null");
            return (Criteria) this;
        }

        public Criteria andOutRealNameEqualTo(String value) {
            addCriterion("out_real_name =", value, "outRealName");
            return (Criteria) this;
        }

        public Criteria andOutRealNameNotEqualTo(String value) {
            addCriterion("out_real_name <>", value, "outRealName");
            return (Criteria) this;
        }

        public Criteria andOutRealNameGreaterThan(String value) {
            addCriterion("out_real_name >", value, "outRealName");
            return (Criteria) this;
        }

        public Criteria andOutRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("out_real_name >=", value, "outRealName");
            return (Criteria) this;
        }

        public Criteria andOutRealNameLessThan(String value) {
            addCriterion("out_real_name <", value, "outRealName");
            return (Criteria) this;
        }

        public Criteria andOutRealNameLessThanOrEqualTo(String value) {
            addCriterion("out_real_name <=", value, "outRealName");
            return (Criteria) this;
        }

        public Criteria andOutRealNameLike(String value) {
            addCriterion("out_real_name like", value, "outRealName");
            return (Criteria) this;
        }

        public Criteria andOutRealNameNotLike(String value) {
            addCriterion("out_real_name not like", value, "outRealName");
            return (Criteria) this;
        }

        public Criteria andOutRealNameIn(List<String> values) {
            addCriterion("out_real_name in", values, "outRealName");
            return (Criteria) this;
        }

        public Criteria andOutRealNameNotIn(List<String> values) {
            addCriterion("out_real_name not in", values, "outRealName");
            return (Criteria) this;
        }

        public Criteria andOutRealNameBetween(String value1, String value2) {
            addCriterion("out_real_name between", value1, value2, "outRealName");
            return (Criteria) this;
        }

        public Criteria andOutRealNameNotBetween(String value1, String value2) {
            addCriterion("out_real_name not between", value1, value2, "outRealName");
            return (Criteria) this;
        }

        public Criteria andOutExternalAccountIsNull() {
            addCriterion("out_external_account is null");
            return (Criteria) this;
        }

        public Criteria andOutExternalAccountIsNotNull() {
            addCriterion("out_external_account is not null");
            return (Criteria) this;
        }

        public Criteria andOutExternalAccountEqualTo(String value) {
            addCriterion("out_external_account =", value, "outExternalAccount");
            return (Criteria) this;
        }

        public Criteria andOutExternalAccountNotEqualTo(String value) {
            addCriterion("out_external_account <>", value, "outExternalAccount");
            return (Criteria) this;
        }

        public Criteria andOutExternalAccountGreaterThan(String value) {
            addCriterion("out_external_account >", value, "outExternalAccount");
            return (Criteria) this;
        }

        public Criteria andOutExternalAccountGreaterThanOrEqualTo(String value) {
            addCriterion("out_external_account >=", value, "outExternalAccount");
            return (Criteria) this;
        }

        public Criteria andOutExternalAccountLessThan(String value) {
            addCriterion("out_external_account <", value, "outExternalAccount");
            return (Criteria) this;
        }

        public Criteria andOutExternalAccountLessThanOrEqualTo(String value) {
            addCriterion("out_external_account <=", value, "outExternalAccount");
            return (Criteria) this;
        }

        public Criteria andOutExternalAccountLike(String value) {
            addCriterion("out_external_account like", value, "outExternalAccount");
            return (Criteria) this;
        }

        public Criteria andOutExternalAccountNotLike(String value) {
            addCriterion("out_external_account not like", value, "outExternalAccount");
            return (Criteria) this;
        }

        public Criteria andOutExternalAccountIn(List<String> values) {
            addCriterion("out_external_account in", values, "outExternalAccount");
            return (Criteria) this;
        }

        public Criteria andOutExternalAccountNotIn(List<String> values) {
            addCriterion("out_external_account not in", values, "outExternalAccount");
            return (Criteria) this;
        }

        public Criteria andOutExternalAccountBetween(String value1, String value2) {
            addCriterion("out_external_account between", value1, value2, "outExternalAccount");
            return (Criteria) this;
        }

        public Criteria andOutExternalAccountNotBetween(String value1, String value2) {
            addCriterion("out_external_account not between", value1, value2, "outExternalAccount");
            return (Criteria) this;
        }

        public Criteria andInRealNameIsNull() {
            addCriterion("in_real_name is null");
            return (Criteria) this;
        }

        public Criteria andInRealNameIsNotNull() {
            addCriterion("in_real_name is not null");
            return (Criteria) this;
        }

        public Criteria andInRealNameEqualTo(String value) {
            addCriterion("in_real_name =", value, "inRealName");
            return (Criteria) this;
        }

        public Criteria andInRealNameNotEqualTo(String value) {
            addCriterion("in_real_name <>", value, "inRealName");
            return (Criteria) this;
        }

        public Criteria andInRealNameGreaterThan(String value) {
            addCriterion("in_real_name >", value, "inRealName");
            return (Criteria) this;
        }

        public Criteria andInRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("in_real_name >=", value, "inRealName");
            return (Criteria) this;
        }

        public Criteria andInRealNameLessThan(String value) {
            addCriterion("in_real_name <", value, "inRealName");
            return (Criteria) this;
        }

        public Criteria andInRealNameLessThanOrEqualTo(String value) {
            addCriterion("in_real_name <=", value, "inRealName");
            return (Criteria) this;
        }

        public Criteria andInRealNameLike(String value) {
            addCriterion("in_real_name like", value, "inRealName");
            return (Criteria) this;
        }

        public Criteria andInRealNameNotLike(String value) {
            addCriterion("in_real_name not like", value, "inRealName");
            return (Criteria) this;
        }

        public Criteria andInRealNameIn(List<String> values) {
            addCriterion("in_real_name in", values, "inRealName");
            return (Criteria) this;
        }

        public Criteria andInRealNameNotIn(List<String> values) {
            addCriterion("in_real_name not in", values, "inRealName");
            return (Criteria) this;
        }

        public Criteria andInRealNameBetween(String value1, String value2) {
            addCriterion("in_real_name between", value1, value2, "inRealName");
            return (Criteria) this;
        }

        public Criteria andInRealNameNotBetween(String value1, String value2) {
            addCriterion("in_real_name not between", value1, value2, "inRealName");
            return (Criteria) this;
        }

        public Criteria andInExternalAccountIsNull() {
            addCriterion("in_external_account is null");
            return (Criteria) this;
        }

        public Criteria andInExternalAccountIsNotNull() {
            addCriterion("in_external_account is not null");
            return (Criteria) this;
        }

        public Criteria andInExternalAccountEqualTo(String value) {
            addCriterion("in_external_account =", value, "inExternalAccount");
            return (Criteria) this;
        }

        public Criteria andInExternalAccountNotEqualTo(String value) {
            addCriterion("in_external_account <>", value, "inExternalAccount");
            return (Criteria) this;
        }

        public Criteria andInExternalAccountGreaterThan(String value) {
            addCriterion("in_external_account >", value, "inExternalAccount");
            return (Criteria) this;
        }

        public Criteria andInExternalAccountGreaterThanOrEqualTo(String value) {
            addCriterion("in_external_account >=", value, "inExternalAccount");
            return (Criteria) this;
        }

        public Criteria andInExternalAccountLessThan(String value) {
            addCriterion("in_external_account <", value, "inExternalAccount");
            return (Criteria) this;
        }

        public Criteria andInExternalAccountLessThanOrEqualTo(String value) {
            addCriterion("in_external_account <=", value, "inExternalAccount");
            return (Criteria) this;
        }

        public Criteria andInExternalAccountLike(String value) {
            addCriterion("in_external_account like", value, "inExternalAccount");
            return (Criteria) this;
        }

        public Criteria andInExternalAccountNotLike(String value) {
            addCriterion("in_external_account not like", value, "inExternalAccount");
            return (Criteria) this;
        }

        public Criteria andInExternalAccountIn(List<String> values) {
            addCriterion("in_external_account in", values, "inExternalAccount");
            return (Criteria) this;
        }

        public Criteria andInExternalAccountNotIn(List<String> values) {
            addCriterion("in_external_account not in", values, "inExternalAccount");
            return (Criteria) this;
        }

        public Criteria andInExternalAccountBetween(String value1, String value2) {
            addCriterion("in_external_account between", value1, value2, "inExternalAccount");
            return (Criteria) this;
        }

        public Criteria andInExternalAccountNotBetween(String value1, String value2) {
            addCriterion("in_external_account not between", value1, value2, "inExternalAccount");
            return (Criteria) this;
        }

        public Criteria andTransferTypeIsNull() {
            addCriterion("transfer_type is null");
            return (Criteria) this;
        }

        public Criteria andTransferTypeIsNotNull() {
            addCriterion("transfer_type is not null");
            return (Criteria) this;
        }

        public Criteria andTransferTypeEqualTo(String value) {
            addCriterion("transfer_type =", value, "transferType");
            return (Criteria) this;
        }

        public Criteria andTransferTypeNotEqualTo(String value) {
            addCriterion("transfer_type <>", value, "transferType");
            return (Criteria) this;
        }

        public Criteria andTransferTypeGreaterThan(String value) {
            addCriterion("transfer_type >", value, "transferType");
            return (Criteria) this;
        }

        public Criteria andTransferTypeGreaterThanOrEqualTo(String value) {
            addCriterion("transfer_type >=", value, "transferType");
            return (Criteria) this;
        }

        public Criteria andTransferTypeLessThan(String value) {
            addCriterion("transfer_type <", value, "transferType");
            return (Criteria) this;
        }

        public Criteria andTransferTypeLessThanOrEqualTo(String value) {
            addCriterion("transfer_type <=", value, "transferType");
            return (Criteria) this;
        }

        public Criteria andTransferTypeLike(String value) {
            addCriterion("transfer_type like", value, "transferType");
            return (Criteria) this;
        }

        public Criteria andTransferTypeNotLike(String value) {
            addCriterion("transfer_type not like", value, "transferType");
            return (Criteria) this;
        }

        public Criteria andTransferTypeIn(List<String> values) {
            addCriterion("transfer_type in", values, "transferType");
            return (Criteria) this;
        }

        public Criteria andTransferTypeNotIn(List<String> values) {
            addCriterion("transfer_type not in", values, "transferType");
            return (Criteria) this;
        }

        public Criteria andTransferTypeBetween(String value1, String value2) {
            addCriterion("transfer_type between", value1, value2, "transferType");
            return (Criteria) this;
        }

        public Criteria andTransferTypeNotBetween(String value1, String value2) {
            addCriterion("transfer_type not between", value1, value2, "transferType");
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

        public Criteria andSettleAmountIsNull() {
            addCriterion("settle_amount is null");
            return (Criteria) this;
        }

        public Criteria andSettleAmountIsNotNull() {
            addCriterion("settle_amount is not null");
            return (Criteria) this;
        }

        public Criteria andSettleAmountEqualTo(String value) {
            addCriterion("settle_amount =", value, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountNotEqualTo(String value) {
            addCriterion("settle_amount <>", value, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountGreaterThan(String value) {
            addCriterion("settle_amount >", value, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountGreaterThanOrEqualTo(String value) {
            addCriterion("settle_amount >=", value, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountLessThan(String value) {
            addCriterion("settle_amount <", value, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountLessThanOrEqualTo(String value) {
            addCriterion("settle_amount <=", value, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountLike(String value) {
            addCriterion("settle_amount like", value, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountNotLike(String value) {
            addCriterion("settle_amount not like", value, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountIn(List<String> values) {
            addCriterion("settle_amount in", values, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountNotIn(List<String> values) {
            addCriterion("settle_amount not in", values, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountBetween(String value1, String value2) {
            addCriterion("settle_amount between", value1, value2, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountNotBetween(String value1, String value2) {
            addCriterion("settle_amount not between", value1, value2, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andFinishDateIsNull() {
            addCriterion("finish_date is null");
            return (Criteria) this;
        }

        public Criteria andFinishDateIsNotNull() {
            addCriterion("finish_date is not null");
            return (Criteria) this;
        }

        public Criteria andFinishDateEqualTo(Date value) {
            addCriterion("finish_date =", value, "finishDate");
            return (Criteria) this;
        }

        public Criteria andFinishDateNotEqualTo(Date value) {
            addCriterion("finish_date <>", value, "finishDate");
            return (Criteria) this;
        }

        public Criteria andFinishDateGreaterThan(Date value) {
            addCriterion("finish_date >", value, "finishDate");
            return (Criteria) this;
        }

        public Criteria andFinishDateGreaterThanOrEqualTo(Date value) {
            addCriterion("finish_date >=", value, "finishDate");
            return (Criteria) this;
        }

        public Criteria andFinishDateLessThan(Date value) {
            addCriterion("finish_date <", value, "finishDate");
            return (Criteria) this;
        }

        public Criteria andFinishDateLessThanOrEqualTo(Date value) {
            addCriterion("finish_date <=", value, "finishDate");
            return (Criteria) this;
        }

        public Criteria andFinishDateIn(List<Date> values) {
            addCriterion("finish_date in", values, "finishDate");
            return (Criteria) this;
        }

        public Criteria andFinishDateNotIn(List<Date> values) {
            addCriterion("finish_date not in", values, "finishDate");
            return (Criteria) this;
        }

        public Criteria andFinishDateBetween(Date value1, Date value2) {
            addCriterion("finish_date between", value1, value2, "finishDate");
            return (Criteria) this;
        }

        public Criteria andFinishDateNotBetween(Date value1, Date value2) {
            addCriterion("finish_date not between", value1, value2, "finishDate");
            return (Criteria) this;
        }

        public Criteria andSettleDateIsNull() {
            addCriterion("settle_date is null");
            return (Criteria) this;
        }

        public Criteria andSettleDateIsNotNull() {
            addCriterion("settle_date is not null");
            return (Criteria) this;
        }

        public Criteria andSettleDateEqualTo(Date value) {
            addCriterion("settle_date =", value, "settleDate");
            return (Criteria) this;
        }

        public Criteria andSettleDateNotEqualTo(Date value) {
            addCriterion("settle_date <>", value, "settleDate");
            return (Criteria) this;
        }

        public Criteria andSettleDateGreaterThan(Date value) {
            addCriterion("settle_date >", value, "settleDate");
            return (Criteria) this;
        }

        public Criteria andSettleDateGreaterThanOrEqualTo(Date value) {
            addCriterion("settle_date >=", value, "settleDate");
            return (Criteria) this;
        }

        public Criteria andSettleDateLessThan(Date value) {
            addCriterion("settle_date <", value, "settleDate");
            return (Criteria) this;
        }

        public Criteria andSettleDateLessThanOrEqualTo(Date value) {
            addCriterion("settle_date <=", value, "settleDate");
            return (Criteria) this;
        }

        public Criteria andSettleDateIn(List<Date> values) {
            addCriterion("settle_date in", values, "settleDate");
            return (Criteria) this;
        }

        public Criteria andSettleDateNotIn(List<Date> values) {
            addCriterion("settle_date not in", values, "settleDate");
            return (Criteria) this;
        }

        public Criteria andSettleDateBetween(Date value1, Date value2) {
            addCriterion("settle_date between", value1, value2, "settleDate");
            return (Criteria) this;
        }

        public Criteria andSettleDateNotBetween(Date value1, Date value2) {
            addCriterion("settle_date not between", value1, value2, "settleDate");
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

        public Criteria andExpiredTimeIsNull() {
            addCriterion("expired_time is null");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeIsNotNull() {
            addCriterion("expired_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeEqualTo(Date value) {
            addCriterion("expired_time =", value, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeNotEqualTo(Date value) {
            addCriterion("expired_time <>", value, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeGreaterThan(Date value) {
            addCriterion("expired_time >", value, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("expired_time >=", value, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeLessThan(Date value) {
            addCriterion("expired_time <", value, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeLessThanOrEqualTo(Date value) {
            addCriterion("expired_time <=", value, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeIn(List<Date> values) {
            addCriterion("expired_time in", values, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeNotIn(List<Date> values) {
            addCriterion("expired_time not in", values, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeBetween(Date value1, Date value2) {
            addCriterion("expired_time between", value1, value2, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andExpiredTimeNotBetween(Date value1, Date value2) {
            addCriterion("expired_time not between", value1, value2, "expiredTime");
            return (Criteria) this;
        }

        public Criteria andRightShareIsNull() {
            addCriterion("right_share is null");
            return (Criteria) this;
        }

        public Criteria andRightShareIsNotNull() {
            addCriterion("right_share is not null");
            return (Criteria) this;
        }

        public Criteria andRightShareEqualTo(String value) {
            addCriterion("right_share =", value, "rightShare");
            return (Criteria) this;
        }

        public Criteria andRightShareNotEqualTo(String value) {
            addCriterion("right_share <>", value, "rightShare");
            return (Criteria) this;
        }

        public Criteria andRightShareGreaterThan(String value) {
            addCriterion("right_share >", value, "rightShare");
            return (Criteria) this;
        }

        public Criteria andRightShareGreaterThanOrEqualTo(String value) {
            addCriterion("right_share >=", value, "rightShare");
            return (Criteria) this;
        }

        public Criteria andRightShareLessThan(String value) {
            addCriterion("right_share <", value, "rightShare");
            return (Criteria) this;
        }

        public Criteria andRightShareLessThanOrEqualTo(String value) {
            addCriterion("right_share <=", value, "rightShare");
            return (Criteria) this;
        }

        public Criteria andRightShareLike(String value) {
            addCriterion("right_share like", value, "rightShare");
            return (Criteria) this;
        }

        public Criteria andRightShareNotLike(String value) {
            addCriterion("right_share not like", value, "rightShare");
            return (Criteria) this;
        }

        public Criteria andRightShareIn(List<String> values) {
            addCriterion("right_share in", values, "rightShare");
            return (Criteria) this;
        }

        public Criteria andRightShareNotIn(List<String> values) {
            addCriterion("right_share not in", values, "rightShare");
            return (Criteria) this;
        }

        public Criteria andRightShareBetween(String value1, String value2) {
            addCriterion("right_share between", value1, value2, "rightShare");
            return (Criteria) this;
        }

        public Criteria andRightShareNotBetween(String value1, String value2) {
            addCriterion("right_share not between", value1, value2, "rightShare");
            return (Criteria) this;
        }

        public Criteria andOriginFcpTrxnoIsNull() {
            addCriterion("origin_fcp_trxno is null");
            return (Criteria) this;
        }

        public Criteria andOriginFcpTrxnoIsNotNull() {
            addCriterion("origin_fcp_trxno is not null");
            return (Criteria) this;
        }

        public Criteria andOriginFcpTrxnoEqualTo(String value) {
            addCriterion("origin_fcp_trxno =", value, "originFcpTrxno");
            return (Criteria) this;
        }

        public Criteria andOriginFcpTrxnoNotEqualTo(String value) {
            addCriterion("origin_fcp_trxno <>", value, "originFcpTrxno");
            return (Criteria) this;
        }

        public Criteria andOriginFcpTrxnoGreaterThan(String value) {
            addCriterion("origin_fcp_trxno >", value, "originFcpTrxno");
            return (Criteria) this;
        }

        public Criteria andOriginFcpTrxnoGreaterThanOrEqualTo(String value) {
            addCriterion("origin_fcp_trxno >=", value, "originFcpTrxno");
            return (Criteria) this;
        }

        public Criteria andOriginFcpTrxnoLessThan(String value) {
            addCriterion("origin_fcp_trxno <", value, "originFcpTrxno");
            return (Criteria) this;
        }

        public Criteria andOriginFcpTrxnoLessThanOrEqualTo(String value) {
            addCriterion("origin_fcp_trxno <=", value, "originFcpTrxno");
            return (Criteria) this;
        }

        public Criteria andOriginFcpTrxnoLike(String value) {
            addCriterion("origin_fcp_trxno like", value, "originFcpTrxno");
            return (Criteria) this;
        }

        public Criteria andOriginFcpTrxnoNotLike(String value) {
            addCriterion("origin_fcp_trxno not like", value, "originFcpTrxno");
            return (Criteria) this;
        }

        public Criteria andOriginFcpTrxnoIn(List<String> values) {
            addCriterion("origin_fcp_trxno in", values, "originFcpTrxno");
            return (Criteria) this;
        }

        public Criteria andOriginFcpTrxnoNotIn(List<String> values) {
            addCriterion("origin_fcp_trxno not in", values, "originFcpTrxno");
            return (Criteria) this;
        }

        public Criteria andOriginFcpTrxnoBetween(String value1, String value2) {
            addCriterion("origin_fcp_trxno between", value1, value2, "originFcpTrxno");
            return (Criteria) this;
        }

        public Criteria andOriginFcpTrxnoNotBetween(String value1, String value2) {
            addCriterion("origin_fcp_trxno not between", value1, value2, "originFcpTrxno");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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
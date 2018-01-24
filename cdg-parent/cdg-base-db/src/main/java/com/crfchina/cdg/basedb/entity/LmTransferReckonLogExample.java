package com.crfchina.cdg.basedb.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LmTransferReckonLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LmTransferReckonLogExample() {
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

        public Criteria andLmReckonFileIsNull() {
            addCriterion("lm_reckon_file is null");
            return (Criteria) this;
        }

        public Criteria andLmReckonFileIsNotNull() {
            addCriterion("lm_reckon_file is not null");
            return (Criteria) this;
        }

        public Criteria andLmReckonFileEqualTo(String value) {
            addCriterion("lm_reckon_file =", value, "lmReckonFile");
            return (Criteria) this;
        }

        public Criteria andLmReckonFileNotEqualTo(String value) {
            addCriterion("lm_reckon_file <>", value, "lmReckonFile");
            return (Criteria) this;
        }

        public Criteria andLmReckonFileGreaterThan(String value) {
            addCriterion("lm_reckon_file >", value, "lmReckonFile");
            return (Criteria) this;
        }

        public Criteria andLmReckonFileGreaterThanOrEqualTo(String value) {
            addCriterion("lm_reckon_file >=", value, "lmReckonFile");
            return (Criteria) this;
        }

        public Criteria andLmReckonFileLessThan(String value) {
            addCriterion("lm_reckon_file <", value, "lmReckonFile");
            return (Criteria) this;
        }

        public Criteria andLmReckonFileLessThanOrEqualTo(String value) {
            addCriterion("lm_reckon_file <=", value, "lmReckonFile");
            return (Criteria) this;
        }

        public Criteria andLmReckonFileLike(String value) {
            addCriterion("lm_reckon_file like", value, "lmReckonFile");
            return (Criteria) this;
        }

        public Criteria andLmReckonFileNotLike(String value) {
            addCriterion("lm_reckon_file not like", value, "lmReckonFile");
            return (Criteria) this;
        }

        public Criteria andLmReckonFileIn(List<String> values) {
            addCriterion("lm_reckon_file in", values, "lmReckonFile");
            return (Criteria) this;
        }

        public Criteria andLmReckonFileNotIn(List<String> values) {
            addCriterion("lm_reckon_file not in", values, "lmReckonFile");
            return (Criteria) this;
        }

        public Criteria andLmReckonFileBetween(String value1, String value2) {
            addCriterion("lm_reckon_file between", value1, value2, "lmReckonFile");
            return (Criteria) this;
        }

        public Criteria andLmReckonFileNotBetween(String value1, String value2) {
            addCriterion("lm_reckon_file not between", value1, value2, "lmReckonFile");
            return (Criteria) this;
        }

        public Criteria andSuccessCountIsNull() {
            addCriterion("success_count is null");
            return (Criteria) this;
        }

        public Criteria andSuccessCountIsNotNull() {
            addCriterion("success_count is not null");
            return (Criteria) this;
        }

        public Criteria andSuccessCountEqualTo(String value) {
            addCriterion("success_count =", value, "successCount");
            return (Criteria) this;
        }

        public Criteria andSuccessCountNotEqualTo(String value) {
            addCriterion("success_count <>", value, "successCount");
            return (Criteria) this;
        }

        public Criteria andSuccessCountGreaterThan(String value) {
            addCriterion("success_count >", value, "successCount");
            return (Criteria) this;
        }

        public Criteria andSuccessCountGreaterThanOrEqualTo(String value) {
            addCriterion("success_count >=", value, "successCount");
            return (Criteria) this;
        }

        public Criteria andSuccessCountLessThan(String value) {
            addCriterion("success_count <", value, "successCount");
            return (Criteria) this;
        }

        public Criteria andSuccessCountLessThanOrEqualTo(String value) {
            addCriterion("success_count <=", value, "successCount");
            return (Criteria) this;
        }

        public Criteria andSuccessCountLike(String value) {
            addCriterion("success_count like", value, "successCount");
            return (Criteria) this;
        }

        public Criteria andSuccessCountNotLike(String value) {
            addCriterion("success_count not like", value, "successCount");
            return (Criteria) this;
        }

        public Criteria andSuccessCountIn(List<String> values) {
            addCriterion("success_count in", values, "successCount");
            return (Criteria) this;
        }

        public Criteria andSuccessCountNotIn(List<String> values) {
            addCriterion("success_count not in", values, "successCount");
            return (Criteria) this;
        }

        public Criteria andSuccessCountBetween(String value1, String value2) {
            addCriterion("success_count between", value1, value2, "successCount");
            return (Criteria) this;
        }

        public Criteria andSuccessCountNotBetween(String value1, String value2) {
            addCriterion("success_count not between", value1, value2, "successCount");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountIsNull() {
            addCriterion("success_amount is null");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountIsNotNull() {
            addCriterion("success_amount is not null");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountEqualTo(String value) {
            addCriterion("success_amount =", value, "successAmount");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountNotEqualTo(String value) {
            addCriterion("success_amount <>", value, "successAmount");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountGreaterThan(String value) {
            addCriterion("success_amount >", value, "successAmount");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountGreaterThanOrEqualTo(String value) {
            addCriterion("success_amount >=", value, "successAmount");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountLessThan(String value) {
            addCriterion("success_amount <", value, "successAmount");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountLessThanOrEqualTo(String value) {
            addCriterion("success_amount <=", value, "successAmount");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountLike(String value) {
            addCriterion("success_amount like", value, "successAmount");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountNotLike(String value) {
            addCriterion("success_amount not like", value, "successAmount");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountIn(List<String> values) {
            addCriterion("success_amount in", values, "successAmount");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountNotIn(List<String> values) {
            addCriterion("success_amount not in", values, "successAmount");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountBetween(String value1, String value2) {
            addCriterion("success_amount between", value1, value2, "successAmount");
            return (Criteria) this;
        }

        public Criteria andSuccessAmountNotBetween(String value1, String value2) {
            addCriterion("success_amount not between", value1, value2, "successAmount");
            return (Criteria) this;
        }

        public Criteria andLmCountIsNull() {
            addCriterion("lm_count is null");
            return (Criteria) this;
        }

        public Criteria andLmCountIsNotNull() {
            addCriterion("lm_count is not null");
            return (Criteria) this;
        }

        public Criteria andLmCountEqualTo(String value) {
            addCriterion("lm_count =", value, "lmCount");
            return (Criteria) this;
        }

        public Criteria andLmCountNotEqualTo(String value) {
            addCriterion("lm_count <>", value, "lmCount");
            return (Criteria) this;
        }

        public Criteria andLmCountGreaterThan(String value) {
            addCriterion("lm_count >", value, "lmCount");
            return (Criteria) this;
        }

        public Criteria andLmCountGreaterThanOrEqualTo(String value) {
            addCriterion("lm_count >=", value, "lmCount");
            return (Criteria) this;
        }

        public Criteria andLmCountLessThan(String value) {
            addCriterion("lm_count <", value, "lmCount");
            return (Criteria) this;
        }

        public Criteria andLmCountLessThanOrEqualTo(String value) {
            addCriterion("lm_count <=", value, "lmCount");
            return (Criteria) this;
        }

        public Criteria andLmCountLike(String value) {
            addCriterion("lm_count like", value, "lmCount");
            return (Criteria) this;
        }

        public Criteria andLmCountNotLike(String value) {
            addCriterion("lm_count not like", value, "lmCount");
            return (Criteria) this;
        }

        public Criteria andLmCountIn(List<String> values) {
            addCriterion("lm_count in", values, "lmCount");
            return (Criteria) this;
        }

        public Criteria andLmCountNotIn(List<String> values) {
            addCriterion("lm_count not in", values, "lmCount");
            return (Criteria) this;
        }

        public Criteria andLmCountBetween(String value1, String value2) {
            addCriterion("lm_count between", value1, value2, "lmCount");
            return (Criteria) this;
        }

        public Criteria andLmCountNotBetween(String value1, String value2) {
            addCriterion("lm_count not between", value1, value2, "lmCount");
            return (Criteria) this;
        }

        public Criteria andLmAmountIsNull() {
            addCriterion("lm_amount is null");
            return (Criteria) this;
        }

        public Criteria andLmAmountIsNotNull() {
            addCriterion("lm_amount is not null");
            return (Criteria) this;
        }

        public Criteria andLmAmountEqualTo(String value) {
            addCriterion("lm_amount =", value, "lmAmount");
            return (Criteria) this;
        }

        public Criteria andLmAmountNotEqualTo(String value) {
            addCriterion("lm_amount <>", value, "lmAmount");
            return (Criteria) this;
        }

        public Criteria andLmAmountGreaterThan(String value) {
            addCriterion("lm_amount >", value, "lmAmount");
            return (Criteria) this;
        }

        public Criteria andLmAmountGreaterThanOrEqualTo(String value) {
            addCriterion("lm_amount >=", value, "lmAmount");
            return (Criteria) this;
        }

        public Criteria andLmAmountLessThan(String value) {
            addCriterion("lm_amount <", value, "lmAmount");
            return (Criteria) this;
        }

        public Criteria andLmAmountLessThanOrEqualTo(String value) {
            addCriterion("lm_amount <=", value, "lmAmount");
            return (Criteria) this;
        }

        public Criteria andLmAmountLike(String value) {
            addCriterion("lm_amount like", value, "lmAmount");
            return (Criteria) this;
        }

        public Criteria andLmAmountNotLike(String value) {
            addCriterion("lm_amount not like", value, "lmAmount");
            return (Criteria) this;
        }

        public Criteria andLmAmountIn(List<String> values) {
            addCriterion("lm_amount in", values, "lmAmount");
            return (Criteria) this;
        }

        public Criteria andLmAmountNotIn(List<String> values) {
            addCriterion("lm_amount not in", values, "lmAmount");
            return (Criteria) this;
        }

        public Criteria andLmAmountBetween(String value1, String value2) {
            addCriterion("lm_amount between", value1, value2, "lmAmount");
            return (Criteria) this;
        }

        public Criteria andLmAmountNotBetween(String value1, String value2) {
            addCriterion("lm_amount not between", value1, value2, "lmAmount");
            return (Criteria) this;
        }

        public Criteria andCrfCountIsNull() {
            addCriterion("crf_count is null");
            return (Criteria) this;
        }

        public Criteria andCrfCountIsNotNull() {
            addCriterion("crf_count is not null");
            return (Criteria) this;
        }

        public Criteria andCrfCountEqualTo(String value) {
            addCriterion("crf_count =", value, "crfCount");
            return (Criteria) this;
        }

        public Criteria andCrfCountNotEqualTo(String value) {
            addCriterion("crf_count <>", value, "crfCount");
            return (Criteria) this;
        }

        public Criteria andCrfCountGreaterThan(String value) {
            addCriterion("crf_count >", value, "crfCount");
            return (Criteria) this;
        }

        public Criteria andCrfCountGreaterThanOrEqualTo(String value) {
            addCriterion("crf_count >=", value, "crfCount");
            return (Criteria) this;
        }

        public Criteria andCrfCountLessThan(String value) {
            addCriterion("crf_count <", value, "crfCount");
            return (Criteria) this;
        }

        public Criteria andCrfCountLessThanOrEqualTo(String value) {
            addCriterion("crf_count <=", value, "crfCount");
            return (Criteria) this;
        }

        public Criteria andCrfCountLike(String value) {
            addCriterion("crf_count like", value, "crfCount");
            return (Criteria) this;
        }

        public Criteria andCrfCountNotLike(String value) {
            addCriterion("crf_count not like", value, "crfCount");
            return (Criteria) this;
        }

        public Criteria andCrfCountIn(List<String> values) {
            addCriterion("crf_count in", values, "crfCount");
            return (Criteria) this;
        }

        public Criteria andCrfCountNotIn(List<String> values) {
            addCriterion("crf_count not in", values, "crfCount");
            return (Criteria) this;
        }

        public Criteria andCrfCountBetween(String value1, String value2) {
            addCriterion("crf_count between", value1, value2, "crfCount");
            return (Criteria) this;
        }

        public Criteria andCrfCountNotBetween(String value1, String value2) {
            addCriterion("crf_count not between", value1, value2, "crfCount");
            return (Criteria) this;
        }

        public Criteria andCrfAmountIsNull() {
            addCriterion("crf_amount is null");
            return (Criteria) this;
        }

        public Criteria andCrfAmountIsNotNull() {
            addCriterion("crf_amount is not null");
            return (Criteria) this;
        }

        public Criteria andCrfAmountEqualTo(String value) {
            addCriterion("crf_amount =", value, "crfAmount");
            return (Criteria) this;
        }

        public Criteria andCrfAmountNotEqualTo(String value) {
            addCriterion("crf_amount <>", value, "crfAmount");
            return (Criteria) this;
        }

        public Criteria andCrfAmountGreaterThan(String value) {
            addCriterion("crf_amount >", value, "crfAmount");
            return (Criteria) this;
        }

        public Criteria andCrfAmountGreaterThanOrEqualTo(String value) {
            addCriterion("crf_amount >=", value, "crfAmount");
            return (Criteria) this;
        }

        public Criteria andCrfAmountLessThan(String value) {
            addCriterion("crf_amount <", value, "crfAmount");
            return (Criteria) this;
        }

        public Criteria andCrfAmountLessThanOrEqualTo(String value) {
            addCriterion("crf_amount <=", value, "crfAmount");
            return (Criteria) this;
        }

        public Criteria andCrfAmountLike(String value) {
            addCriterion("crf_amount like", value, "crfAmount");
            return (Criteria) this;
        }

        public Criteria andCrfAmountNotLike(String value) {
            addCriterion("crf_amount not like", value, "crfAmount");
            return (Criteria) this;
        }

        public Criteria andCrfAmountIn(List<String> values) {
            addCriterion("crf_amount in", values, "crfAmount");
            return (Criteria) this;
        }

        public Criteria andCrfAmountNotIn(List<String> values) {
            addCriterion("crf_amount not in", values, "crfAmount");
            return (Criteria) this;
        }

        public Criteria andCrfAmountBetween(String value1, String value2) {
            addCriterion("crf_amount between", value1, value2, "crfAmount");
            return (Criteria) this;
        }

        public Criteria andCrfAmountNotBetween(String value1, String value2) {
            addCriterion("crf_amount not between", value1, value2, "crfAmount");
            return (Criteria) this;
        }

        public Criteria andLmFallCountIsNull() {
            addCriterion("lm_fall_count is null");
            return (Criteria) this;
        }

        public Criteria andLmFallCountIsNotNull() {
            addCriterion("lm_fall_count is not null");
            return (Criteria) this;
        }

        public Criteria andLmFallCountEqualTo(String value) {
            addCriterion("lm_fall_count =", value, "lmFallCount");
            return (Criteria) this;
        }

        public Criteria andLmFallCountNotEqualTo(String value) {
            addCriterion("lm_fall_count <>", value, "lmFallCount");
            return (Criteria) this;
        }

        public Criteria andLmFallCountGreaterThan(String value) {
            addCriterion("lm_fall_count >", value, "lmFallCount");
            return (Criteria) this;
        }

        public Criteria andLmFallCountGreaterThanOrEqualTo(String value) {
            addCriterion("lm_fall_count >=", value, "lmFallCount");
            return (Criteria) this;
        }

        public Criteria andLmFallCountLessThan(String value) {
            addCriterion("lm_fall_count <", value, "lmFallCount");
            return (Criteria) this;
        }

        public Criteria andLmFallCountLessThanOrEqualTo(String value) {
            addCriterion("lm_fall_count <=", value, "lmFallCount");
            return (Criteria) this;
        }

        public Criteria andLmFallCountLike(String value) {
            addCriterion("lm_fall_count like", value, "lmFallCount");
            return (Criteria) this;
        }

        public Criteria andLmFallCountNotLike(String value) {
            addCriterion("lm_fall_count not like", value, "lmFallCount");
            return (Criteria) this;
        }

        public Criteria andLmFallCountIn(List<String> values) {
            addCriterion("lm_fall_count in", values, "lmFallCount");
            return (Criteria) this;
        }

        public Criteria andLmFallCountNotIn(List<String> values) {
            addCriterion("lm_fall_count not in", values, "lmFallCount");
            return (Criteria) this;
        }

        public Criteria andLmFallCountBetween(String value1, String value2) {
            addCriterion("lm_fall_count between", value1, value2, "lmFallCount");
            return (Criteria) this;
        }

        public Criteria andLmFallCountNotBetween(String value1, String value2) {
            addCriterion("lm_fall_count not between", value1, value2, "lmFallCount");
            return (Criteria) this;
        }

        public Criteria andLmFallAmountIsNull() {
            addCriterion("lm_fall_amount is null");
            return (Criteria) this;
        }

        public Criteria andLmFallAmountIsNotNull() {
            addCriterion("lm_fall_amount is not null");
            return (Criteria) this;
        }

        public Criteria andLmFallAmountEqualTo(String value) {
            addCriterion("lm_fall_amount =", value, "lmFallAmount");
            return (Criteria) this;
        }

        public Criteria andLmFallAmountNotEqualTo(String value) {
            addCriterion("lm_fall_amount <>", value, "lmFallAmount");
            return (Criteria) this;
        }

        public Criteria andLmFallAmountGreaterThan(String value) {
            addCriterion("lm_fall_amount >", value, "lmFallAmount");
            return (Criteria) this;
        }

        public Criteria andLmFallAmountGreaterThanOrEqualTo(String value) {
            addCriterion("lm_fall_amount >=", value, "lmFallAmount");
            return (Criteria) this;
        }

        public Criteria andLmFallAmountLessThan(String value) {
            addCriterion("lm_fall_amount <", value, "lmFallAmount");
            return (Criteria) this;
        }

        public Criteria andLmFallAmountLessThanOrEqualTo(String value) {
            addCriterion("lm_fall_amount <=", value, "lmFallAmount");
            return (Criteria) this;
        }

        public Criteria andLmFallAmountLike(String value) {
            addCriterion("lm_fall_amount like", value, "lmFallAmount");
            return (Criteria) this;
        }

        public Criteria andLmFallAmountNotLike(String value) {
            addCriterion("lm_fall_amount not like", value, "lmFallAmount");
            return (Criteria) this;
        }

        public Criteria andLmFallAmountIn(List<String> values) {
            addCriterion("lm_fall_amount in", values, "lmFallAmount");
            return (Criteria) this;
        }

        public Criteria andLmFallAmountNotIn(List<String> values) {
            addCriterion("lm_fall_amount not in", values, "lmFallAmount");
            return (Criteria) this;
        }

        public Criteria andLmFallAmountBetween(String value1, String value2) {
            addCriterion("lm_fall_amount between", value1, value2, "lmFallAmount");
            return (Criteria) this;
        }

        public Criteria andLmFallAmountNotBetween(String value1, String value2) {
            addCriterion("lm_fall_amount not between", value1, value2, "lmFallAmount");
            return (Criteria) this;
        }

        public Criteria andCrfFallCountIsNull() {
            addCriterion("crf_fall_count is null");
            return (Criteria) this;
        }

        public Criteria andCrfFallCountIsNotNull() {
            addCriterion("crf_fall_count is not null");
            return (Criteria) this;
        }

        public Criteria andCrfFallCountEqualTo(String value) {
            addCriterion("crf_fall_count =", value, "crfFallCount");
            return (Criteria) this;
        }

        public Criteria andCrfFallCountNotEqualTo(String value) {
            addCriterion("crf_fall_count <>", value, "crfFallCount");
            return (Criteria) this;
        }

        public Criteria andCrfFallCountGreaterThan(String value) {
            addCriterion("crf_fall_count >", value, "crfFallCount");
            return (Criteria) this;
        }

        public Criteria andCrfFallCountGreaterThanOrEqualTo(String value) {
            addCriterion("crf_fall_count >=", value, "crfFallCount");
            return (Criteria) this;
        }

        public Criteria andCrfFallCountLessThan(String value) {
            addCriterion("crf_fall_count <", value, "crfFallCount");
            return (Criteria) this;
        }

        public Criteria andCrfFallCountLessThanOrEqualTo(String value) {
            addCriterion("crf_fall_count <=", value, "crfFallCount");
            return (Criteria) this;
        }

        public Criteria andCrfFallCountLike(String value) {
            addCriterion("crf_fall_count like", value, "crfFallCount");
            return (Criteria) this;
        }

        public Criteria andCrfFallCountNotLike(String value) {
            addCriterion("crf_fall_count not like", value, "crfFallCount");
            return (Criteria) this;
        }

        public Criteria andCrfFallCountIn(List<String> values) {
            addCriterion("crf_fall_count in", values, "crfFallCount");
            return (Criteria) this;
        }

        public Criteria andCrfFallCountNotIn(List<String> values) {
            addCriterion("crf_fall_count not in", values, "crfFallCount");
            return (Criteria) this;
        }

        public Criteria andCrfFallCountBetween(String value1, String value2) {
            addCriterion("crf_fall_count between", value1, value2, "crfFallCount");
            return (Criteria) this;
        }

        public Criteria andCrfFallCountNotBetween(String value1, String value2) {
            addCriterion("crf_fall_count not between", value1, value2, "crfFallCount");
            return (Criteria) this;
        }

        public Criteria andCrfFallAmountIsNull() {
            addCriterion("crf_fall_amount is null");
            return (Criteria) this;
        }

        public Criteria andCrfFallAmountIsNotNull() {
            addCriterion("crf_fall_amount is not null");
            return (Criteria) this;
        }

        public Criteria andCrfFallAmountEqualTo(String value) {
            addCriterion("crf_fall_amount =", value, "crfFallAmount");
            return (Criteria) this;
        }

        public Criteria andCrfFallAmountNotEqualTo(String value) {
            addCriterion("crf_fall_amount <>", value, "crfFallAmount");
            return (Criteria) this;
        }

        public Criteria andCrfFallAmountGreaterThan(String value) {
            addCriterion("crf_fall_amount >", value, "crfFallAmount");
            return (Criteria) this;
        }

        public Criteria andCrfFallAmountGreaterThanOrEqualTo(String value) {
            addCriterion("crf_fall_amount >=", value, "crfFallAmount");
            return (Criteria) this;
        }

        public Criteria andCrfFallAmountLessThan(String value) {
            addCriterion("crf_fall_amount <", value, "crfFallAmount");
            return (Criteria) this;
        }

        public Criteria andCrfFallAmountLessThanOrEqualTo(String value) {
            addCriterion("crf_fall_amount <=", value, "crfFallAmount");
            return (Criteria) this;
        }

        public Criteria andCrfFallAmountLike(String value) {
            addCriterion("crf_fall_amount like", value, "crfFallAmount");
            return (Criteria) this;
        }

        public Criteria andCrfFallAmountNotLike(String value) {
            addCriterion("crf_fall_amount not like", value, "crfFallAmount");
            return (Criteria) this;
        }

        public Criteria andCrfFallAmountIn(List<String> values) {
            addCriterion("crf_fall_amount in", values, "crfFallAmount");
            return (Criteria) this;
        }

        public Criteria andCrfFallAmountNotIn(List<String> values) {
            addCriterion("crf_fall_amount not in", values, "crfFallAmount");
            return (Criteria) this;
        }

        public Criteria andCrfFallAmountBetween(String value1, String value2) {
            addCriterion("crf_fall_amount between", value1, value2, "crfFallAmount");
            return (Criteria) this;
        }

        public Criteria andCrfFallAmountNotBetween(String value1, String value2) {
            addCriterion("crf_fall_amount not between", value1, value2, "crfFallAmount");
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

        public Criteria andReckonResultIsNull() {
            addCriterion("reckon_result is null");
            return (Criteria) this;
        }

        public Criteria andReckonResultIsNotNull() {
            addCriterion("reckon_result is not null");
            return (Criteria) this;
        }

        public Criteria andReckonResultEqualTo(String value) {
            addCriterion("reckon_result =", value, "reckonResult");
            return (Criteria) this;
        }

        public Criteria andReckonResultNotEqualTo(String value) {
            addCriterion("reckon_result <>", value, "reckonResult");
            return (Criteria) this;
        }

        public Criteria andReckonResultGreaterThan(String value) {
            addCriterion("reckon_result >", value, "reckonResult");
            return (Criteria) this;
        }

        public Criteria andReckonResultGreaterThanOrEqualTo(String value) {
            addCriterion("reckon_result >=", value, "reckonResult");
            return (Criteria) this;
        }

        public Criteria andReckonResultLessThan(String value) {
            addCriterion("reckon_result <", value, "reckonResult");
            return (Criteria) this;
        }

        public Criteria andReckonResultLessThanOrEqualTo(String value) {
            addCriterion("reckon_result <=", value, "reckonResult");
            return (Criteria) this;
        }

        public Criteria andReckonResultLike(String value) {
            addCriterion("reckon_result like", value, "reckonResult");
            return (Criteria) this;
        }

        public Criteria andReckonResultNotLike(String value) {
            addCriterion("reckon_result not like", value, "reckonResult");
            return (Criteria) this;
        }

        public Criteria andReckonResultIn(List<String> values) {
            addCriterion("reckon_result in", values, "reckonResult");
            return (Criteria) this;
        }

        public Criteria andReckonResultNotIn(List<String> values) {
            addCriterion("reckon_result not in", values, "reckonResult");
            return (Criteria) this;
        }

        public Criteria andReckonResultBetween(String value1, String value2) {
            addCriterion("reckon_result between", value1, value2, "reckonResult");
            return (Criteria) this;
        }

        public Criteria andReckonResultNotBetween(String value1, String value2) {
            addCriterion("reckon_result not between", value1, value2, "reckonResult");
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
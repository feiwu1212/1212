package com.crfchina.cdg.basedb.entity;

import java.util.Date;

public class LmTransferReckonDtl {
    private Long id;

    private String reckonId;

    private String reckonDate;

    private String reckonType;

    private String requestRefNo;

    private String fcpTrxNo;

    private String lmOrderNo;

    private String transferAmount;

    private Date accountDate;

    private String lmBizType;

    private String crfBizType;

    private String misc;

    private Integer statue;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReckonId() {
        return reckonId;
    }

    public void setReckonId(String reckonId) {
        this.reckonId = reckonId == null ? null : reckonId.trim();
    }

    public String getReckonDate() {
        return reckonDate;
    }

    public void setReckonDate(String reckonDate) {
        this.reckonDate = reckonDate == null ? null : reckonDate.trim();
    }

    public String getReckonType() {
        return reckonType;
    }

    public void setReckonType(String reckonType) {
        this.reckonType = reckonType == null ? null : reckonType.trim();
    }

    public String getRequestRefNo() {
        return requestRefNo;
    }

    public void setRequestRefNo(String requestRefNo) {
        this.requestRefNo = requestRefNo == null ? null : requestRefNo.trim();
    }

    public String getFcpTrxNo() {
        return fcpTrxNo;
    }

    public void setFcpTrxNo(String fcpTrxNo) {
        this.fcpTrxNo = fcpTrxNo == null ? null : fcpTrxNo.trim();
    }

    public String getLmOrderNo() {
        return lmOrderNo;
    }

    public void setLmOrderNo(String lmOrderNo) {
        this.lmOrderNo = lmOrderNo == null ? null : lmOrderNo.trim();
    }

    public String getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(String transferAmount) {
        this.transferAmount = transferAmount == null ? null : transferAmount.trim();
    }

    public Date getAccountDate() {
        return accountDate;
    }

    public void setAccountDate(Date accountDate) {
        this.accountDate = accountDate;
    }

    public String getLmBizType() {
        return lmBizType;
    }

    public void setLmBizType(String lmBizType) {
        this.lmBizType = lmBizType == null ? null : lmBizType.trim();
    }

    public String getCrfBizType() {
        return crfBizType;
    }

    public void setCrfBizType(String crfBizType) {
        this.crfBizType = crfBizType == null ? null : crfBizType.trim();
    }

    public String getMisc() {
        return misc;
    }

    public void setMisc(String misc) {
        this.misc = misc == null ? null : misc.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

	public Integer getStatue() {
		return statue;
	}

	public void setStatue(Integer statue) {
		this.statue = statue;
	}
}
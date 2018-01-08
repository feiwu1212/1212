package com.crfchina.cdg.basedb.entity;

import java.util.Date;

public class LmVaccountTransferDetail {
    private Long id;

    private String requestRefNo;

    private String fcpTrxNo;

    private String transferInfoId;

    private String transferAmount;

    private String outRealName;

    private String outExternalAccount;

    private String inRealName;

    private String inExternalAccount;

    private Date accountDate;

    private String settleAmount;

    private Date finishDate;

    private Date settleDate;

    private String lmBizType;

    private String crfBizType;

    private String rightShare;

    private String originFcpTrxno;

    private String customDefine;

    private String remark;

    private String result;

    private String failCode;

    private String failReason;

    private Date createTime;

    private Date updateTime;

    private Integer partitionDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getTransferInfoId() {
        return transferInfoId;
    }

    public void setTransferInfoId(String transferInfoId) {
        this.transferInfoId = transferInfoId == null ? null : transferInfoId.trim();
    }

    public String getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(String transferAmount) {
        this.transferAmount = transferAmount == null ? null : transferAmount.trim();
    }

    public String getOutRealName() {
        return outRealName;
    }

    public void setOutRealName(String outRealName) {
        this.outRealName = outRealName == null ? null : outRealName.trim();
    }

    public String getOutExternalAccount() {
        return outExternalAccount;
    }

    public void setOutExternalAccount(String outExternalAccount) {
        this.outExternalAccount = outExternalAccount == null ? null : outExternalAccount.trim();
    }

    public String getInRealName() {
        return inRealName;
    }

    public void setInRealName(String inRealName) {
        this.inRealName = inRealName == null ? null : inRealName.trim();
    }

    public String getInExternalAccount() {
        return inExternalAccount;
    }

    public void setInExternalAccount(String inExternalAccount) {
        this.inExternalAccount = inExternalAccount == null ? null : inExternalAccount.trim();
    }

    public Date getAccountDate() {
        return accountDate;
    }

    public void setAccountDate(Date accountDate) {
        this.accountDate = accountDate;
    }

    public String getSettleAmount() {
        return settleAmount;
    }

    public void setSettleAmount(String settleAmount) {
        this.settleAmount = settleAmount == null ? null : settleAmount.trim();
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public Date getSettleDate() {
        return settleDate;
    }

    public void setSettleDate(Date settleDate) {
        this.settleDate = settleDate;
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

    public String getRightShare() {
        return rightShare;
    }

    public void setRightShare(String rightShare) {
        this.rightShare = rightShare == null ? null : rightShare.trim();
    }

    public String getOriginFcpTrxno() {
        return originFcpTrxno;
    }

    public void setOriginFcpTrxno(String originFcpTrxno) {
        this.originFcpTrxno = originFcpTrxno == null ? null : originFcpTrxno.trim();
    }

    public String getCustomDefine() {
        return customDefine;
    }

    public void setCustomDefine(String customDefine) {
        this.customDefine = customDefine == null ? null : customDefine.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public String getFailCode() {
        return failCode;
    }

    public void setFailCode(String failCode) {
        this.failCode = failCode == null ? null : failCode.trim();
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason == null ? null : failReason.trim();
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

    public Integer getPartitionDate() {
        return partitionDate;
    }

    public void setPartitionDate(Integer partitionDate) {
        this.partitionDate = partitionDate;
    }
}
package com.crfchina.cdg.basedb.entity;

import java.util.Date;

public class LmVaccountTransferInfo {
    private Long id;

    private String batchNo;

    private String requestRefNo;

    private Date requestTime;

    private String systemNo;

    private String fcpTrxNo;

    private String transferAmount;

    private String channelFeeAmount;

    private int currency;

    private String outRealName;

    private String outExternalAccount;

    private String inRealName;

    private String inExternalAccount;

    private String transferType;

    private Date accountDate;

    private String settleAmount;

    private Date finishDate;

    private Date settleDate;

    private String lmBizType;

    private String crfBizType;

    private Date expiredTime;

    private String rightShare;

    private String originFcpTrxno;

    private String remark;

    private String callbackUrl;

    private String notifyUrl;

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

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
    }

    public String getRequestRefNo() {
        return requestRefNo;
    }

    public void setRequestRefNo(String requestRefNo) {
        this.requestRefNo = requestRefNo == null ? null : requestRefNo.trim();
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public String getSystemNo() {
        return systemNo;
    }

    public void setSystemNo(String systemNo) {
        this.systemNo = systemNo == null ? null : systemNo.trim();
    }

    public String getFcpTrxNo() {
        return fcpTrxNo;
    }

    public void setFcpTrxNo(String fcpTrxNo) {
        this.fcpTrxNo = fcpTrxNo == null ? null : fcpTrxNo.trim();
    }

    public String getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(String transferAmount) {
        this.transferAmount = transferAmount == null ? null : transferAmount.trim();
    }

    public String getChannelFeeAmount() {
        return channelFeeAmount;
    }

    public void setChannelFeeAmount(String channelFeeAmount) {
        this.channelFeeAmount = channelFeeAmount == null ? null : channelFeeAmount.trim();
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
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

    public String getTransferType() {
        return transferType;
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType == null ? null : transferType.trim();
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

    public Date getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Date expiredTime) {
        this.expiredTime = expiredTime;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl == null ? null : callbackUrl.trim();
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl == null ? null : notifyUrl.trim();
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
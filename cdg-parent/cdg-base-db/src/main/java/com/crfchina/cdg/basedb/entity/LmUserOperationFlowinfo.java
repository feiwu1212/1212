package com.crfchina.cdg.basedb.entity;

import java.util.Date;

public class LmUserOperationFlowinfo {
    private Boolean id;

    private String fcpTrxNo;

    private String requestRefNo;

    private Date requestTime;

    private String systemNo;

    private Byte operType;

    private String platformUserId;

    private Boolean isSkip;

    private String bizTypeDesc;

    private String authList;

    private Boolean checkType;

    private String callbackUrl;

    private String notifyUrl;

    private String result;

    private String failCode;

    private String failReason;

    private Date createTime;

    private Date updateTime;

    private Integer partitionDate;

    public Boolean getId() {
        return id;
    }

    public void setId(Boolean id) {
        this.id = id;
    }

    public String getFcpTrxNo() {
        return fcpTrxNo;
    }

    public void setFcpTrxNo(String fcpTrxNo) {
        this.fcpTrxNo = fcpTrxNo == null ? null : fcpTrxNo.trim();
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

    public Byte getOperType() {
        return operType;
    }

    public void setOperType(Byte operType) {
        this.operType = operType;
    }

    public String getPlatformUserId() {
        return platformUserId;
    }

    public void setPlatformUserId(String platformUserId) {
        this.platformUserId = platformUserId == null ? null : platformUserId.trim();
    }

    public Boolean getIsSkip() {
        return isSkip;
    }

    public void setIsSkip(Boolean isSkip) {
        this.isSkip = isSkip;
    }

    public String getBizTypeDesc() {
        return bizTypeDesc;
    }

    public void setBizTypeDesc(String bizTypeDesc) {
        this.bizTypeDesc = bizTypeDesc == null ? null : bizTypeDesc.trim();
    }

    public String getAuthList() {
        return authList;
    }

    public void setAuthList(String authList) {
        this.authList = authList == null ? null : authList.trim();
    }

    public Boolean getCheckType() {
        return checkType;
    }

    public void setCheckType(Boolean checkType) {
        this.checkType = checkType;
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
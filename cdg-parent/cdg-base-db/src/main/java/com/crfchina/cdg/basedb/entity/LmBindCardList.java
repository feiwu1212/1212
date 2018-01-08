package com.crfchina.cdg.basedb.entity;

import java.util.Date;

public class LmBindCardList {
    private Long id;

    private String platformUserId;

    private String userRealName;

    private String bankcardNo;

    private String bankCode;

    private String mobile;

    private String idNo;

    private Byte idType;

    private Date bindcardTime;

    private String userRole;

    private String authList;

    private Boolean checkType;

    private Boolean userLimitType;

    private Boolean accessType;

    private Boolean auditStatus;

    private Boolean status;

    private Date createTime;

    private Date updateTime;

    private Integer partitionDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlatformUserId() {
        return platformUserId;
    }

    public void setPlatformUserId(String platformUserId) {
        this.platformUserId = platformUserId == null ? null : platformUserId.trim();
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName == null ? null : userRealName.trim();
    }

    public String getBankcardNo() {
        return bankcardNo;
    }

    public void setBankcardNo(String bankcardNo) {
        this.bankcardNo = bankcardNo == null ? null : bankcardNo.trim();
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode == null ? null : bankCode.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo == null ? null : idNo.trim();
    }

    public Byte getIdType() {
        return idType;
    }

    public void setIdType(Byte idType) {
        this.idType = idType;
    }

    public Date getBindcardTime() {
        return bindcardTime;
    }

    public void setBindcardTime(Date bindcardTime) {
        this.bindcardTime = bindcardTime;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole == null ? null : userRole.trim();
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

    public Boolean getUserLimitType() {
        return userLimitType;
    }

    public void setUserLimitType(Boolean userLimitType) {
        this.userLimitType = userLimitType;
    }

    public Boolean getAccessType() {
        return accessType;
    }

    public void setAccessType(Boolean accessType) {
        this.accessType = accessType;
    }

    public Boolean getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Boolean auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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
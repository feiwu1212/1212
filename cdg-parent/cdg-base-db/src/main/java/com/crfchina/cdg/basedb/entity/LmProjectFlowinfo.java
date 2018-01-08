package com.crfchina.cdg.basedb.entity;

import java.util.Date;

public class LmProjectFlowinfo {
    private Long id;

    private String fcpTrxNo;

    private String requestRefNo;

    private Date requestTime;

    private String systemNo;

    private String platformUserId;

    private String projectNo;

    private String projectAmount;

    private String projectName;

    private String projectDesc;

    private Boolean projectType;

    private Integer projectPeriod;

    private String interestRate;

    private Boolean repaymentWay;

    private String extend;

    private Byte projectStatus;

    private Date createTime;

    private Date updateTime;

    private String result;

    private String failCode;

    private String failReason;

    private Integer partitionDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getPlatformUserId() {
        return platformUserId;
    }

    public void setPlatformUserId(String platformUserId) {
        this.platformUserId = platformUserId == null ? null : platformUserId.trim();
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo == null ? null : projectNo.trim();
    }

    public String getProjectAmount() {
        return projectAmount;
    }

    public void setProjectAmount(String projectAmount) {
        this.projectAmount = projectAmount == null ? null : projectAmount.trim();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc == null ? null : projectDesc.trim();
    }

    public Boolean getProjectType() {
        return projectType;
    }

    public void setProjectType(Boolean projectType) {
        this.projectType = projectType;
    }

    public Integer getProjectPeriod() {
        return projectPeriod;
    }

    public void setProjectPeriod(Integer projectPeriod) {
        this.projectPeriod = projectPeriod;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate == null ? null : interestRate.trim();
    }

    public Boolean getRepaymentWay() {
        return repaymentWay;
    }

    public void setRepaymentWay(Boolean repaymentWay) {
        this.repaymentWay = repaymentWay;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend == null ? null : extend.trim();
    }

    public Byte getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(Byte projectStatus) {
        this.projectStatus = projectStatus;
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

    public Integer getPartitionDate() {
        return partitionDate;
    }

    public void setPartitionDate(Integer partitionDate) {
        this.partitionDate = partitionDate;
    }
}
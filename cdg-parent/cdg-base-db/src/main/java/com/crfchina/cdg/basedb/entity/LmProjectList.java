package com.crfchina.cdg.basedb.entity;

import java.util.Date;

public class LmProjectList {
    private Long id;

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
}
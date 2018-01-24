package com.crfchina.cdg.basedb.entity;

import java.util.Date;

public class LmTransferReckonLog {
    private Long id;

    private String reckonId;

    private String reckonDate;

    private String reckonType;

    private String lmReckonFile;

    private String successCount;

    private String successAmount;

    private String lmCount;

    private String lmAmount;

    private String crfCount;

    private String crfAmount;

    private String lmFallCount;

    private String lmFallAmount;

    private String crfFallCount;

    private String crfFallAmount;

    private String misc;

    private Integer statue;

    private String reckonResult;

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

    public String getLmReckonFile() {
        return lmReckonFile;
    }

    public void setLmReckonFile(String lmReckonFile) {
        this.lmReckonFile = lmReckonFile == null ? null : lmReckonFile.trim();
    }

    public String getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(String successCount) {
        this.successCount = successCount == null ? null : successCount.trim();
    }

    public String getSuccessAmount() {
        return successAmount;
    }

    public void setSuccessAmount(String successAmount) {
        this.successAmount = successAmount == null ? null : successAmount.trim();
    }

    public String getLmCount() {
        return lmCount;
    }

    public void setLmCount(String lmCount) {
        this.lmCount = lmCount == null ? null : lmCount.trim();
    }

    public String getLmAmount() {
        return lmAmount;
    }

    public void setLmAmount(String lmAmount) {
        this.lmAmount = lmAmount == null ? null : lmAmount.trim();
    }

    public String getCrfCount() {
        return crfCount;
    }

    public void setCrfCount(String crfCount) {
        this.crfCount = crfCount == null ? null : crfCount.trim();
    }

    public String getCrfAmount() {
        return crfAmount;
    }

    public void setCrfAmount(String crfAmount) {
        this.crfAmount = crfAmount == null ? null : crfAmount.trim();
    }

    public String getLmFallCount() {
        return lmFallCount;
    }

    public void setLmFallCount(String lmFallCount) {
        this.lmFallCount = lmFallCount == null ? null : lmFallCount.trim();
    }

    public String getLmFallAmount() {
        return lmFallAmount;
    }

    public void setLmFallAmount(String lmFallAmount) {
        this.lmFallAmount = lmFallAmount == null ? null : lmFallAmount.trim();
    }

    public String getCrfFallCount() {
        return crfFallCount;
    }

    public void setCrfFallCount(String crfFallCount) {
        this.crfFallCount = crfFallCount == null ? null : crfFallCount.trim();
    }

    public String getCrfFallAmount() {
        return crfFallAmount;
    }

    public void setCrfFallAmount(String crfFallAmount) {
        this.crfFallAmount = crfFallAmount == null ? null : crfFallAmount.trim();
    }

    public String getMisc() {
        return misc;
    }

    public void setMisc(String misc) {
        this.misc = misc == null ? null : misc.trim();
    }

    public String getReckonResult() {
        return reckonResult;
    }

    public void setReckonResult(String reckonResult) {
        this.reckonResult = reckonResult == null ? null : reckonResult.trim();
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
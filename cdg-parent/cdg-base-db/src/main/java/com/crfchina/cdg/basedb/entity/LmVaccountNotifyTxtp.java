package com.crfchina.cdg.basedb.entity;

import java.util.Date;

public class LmVaccountNotifyTxtp {
    private Long id;

    private String lmReturnTrxNo;

    private String fcpTrxNo;

    private String rollbackAmount;

    private String rollbackCommAmount;

    private Date completedTime;

    private String rollbackStatus;

    private String rollbackType;

    private Integer status;

    private Date doneTime;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLmReturnTrxNo() {
        return lmReturnTrxNo;
    }

    public void setLmReturnTrxNo(String lmReturnTrxNo) {
        this.lmReturnTrxNo = lmReturnTrxNo == null ? null : lmReturnTrxNo.trim();
    }

    public String getFcpTrxNo() {
        return fcpTrxNo;
    }

    public void setFcpTrxNo(String fcpTrxNo) {
        this.fcpTrxNo = fcpTrxNo == null ? null : fcpTrxNo.trim();
    }

    public String getRollbackAmount() {
        return rollbackAmount;
    }

    public void setRollbackAmount(String rollbackAmount) {
        this.rollbackAmount = rollbackAmount == null ? null : rollbackAmount.trim();
    }

    public String getRollbackCommAmount() {
        return rollbackCommAmount;
    }

    public void setRollbackCommAmount(String rollbackCommAmount) {
        this.rollbackCommAmount = rollbackCommAmount == null ? null : rollbackCommAmount.trim();
    }

    public Date getCompletedTime() {
        return completedTime;
    }

    public void setCompletedTime(Date completedTime) {
        this.completedTime = completedTime;
    }

    public String getRollbackStatus() {
        return rollbackStatus;
    }

    public void setRollbackStatus(String rollbackStatus) {
        this.rollbackStatus = rollbackStatus == null ? null : rollbackStatus.trim();
    }

    public String getRollbackType() {
        return rollbackType;
    }

    public void setRollbackType(String rollbackType) {
        this.rollbackType = rollbackType == null ? null : rollbackType.trim();
    }

    public Date getDoneTime() {
        return doneTime;
    }

    public void setDoneTime(Date doneTime) {
        this.doneTime = doneTime;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
package com.crfchina.cdg.basedb.entity;

import java.util.Date;

public class SystemStatusCode {
    private Long id;

    private String codeNo;

    private String statusCode;

    private String codeExplain;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeNo() {
        return codeNo;
    }

    public void setCodeNo(String codeNo) {
        this.codeNo = codeNo == null ? null : codeNo.trim();
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode == null ? null : statusCode.trim();
    }

    public String getCodeExplain() {
        return codeExplain;
    }

    public void setCodeExplain(String codeExplain) {
        this.codeExplain = codeExplain == null ? null : codeExplain.trim();
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
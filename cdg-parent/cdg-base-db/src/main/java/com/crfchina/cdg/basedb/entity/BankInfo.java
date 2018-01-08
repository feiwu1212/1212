package com.crfchina.cdg.basedb.entity;

import java.util.Date;

public class BankInfo {
    private Long id;

    private String bankCode;

    private String bankName;

    private String lmBankCode;

    private String fuiouBankCode;

    private String logoUrl;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode == null ? null : bankCode.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getLmBankCode() {
        return lmBankCode;
    }

    public void setLmBankCode(String lmBankCode) {
        this.lmBankCode = lmBankCode == null ? null : lmBankCode.trim();
    }

    public String getFuiouBankCode() {
        return fuiouBankCode;
    }

    public void setFuiouBankCode(String fuiouBankCode) {
        this.fuiouBankCode = fuiouBankCode == null ? null : fuiouBankCode.trim();
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl == null ? null : logoUrl.trim();
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
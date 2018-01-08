package com.crfchina.cdg.basedb.entity;

import java.util.Date;

public class SystemStatusCodeMetadata {
    private Long id;

    private String codeNo;

    private String channelInfoNo;

    private String statusReport;

    private String statusReportExplain;

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

    public String getChannelInfoNo() {
        return channelInfoNo;
    }

    public void setChannelInfoNo(String channelInfoNo) {
        this.channelInfoNo = channelInfoNo == null ? null : channelInfoNo.trim();
    }

    public String getStatusReport() {
        return statusReport;
    }

    public void setStatusReport(String statusReport) {
        this.statusReport = statusReport == null ? null : statusReport.trim();
    }

    public String getStatusReportExplain() {
        return statusReportExplain;
    }

    public void setStatusReportExplain(String statusReportExplain) {
        this.statusReportExplain = statusReportExplain == null ? null : statusReportExplain.trim();
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
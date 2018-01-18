/**
 * @Title：
 * @Package com.crfchina.cdg.api.dto
 * @date 2018/1/17 14:38
 * @version V1.0
 */
package com.crfchina.cdg.api.dto;

import java.util.List;

/**
 * @ProjectName：cdg-parent
 * @ClassName：BizDetails
 * @Description:
 * @author: Administrator
 * @date：2018/1/17 14:38
 * @updateBy：但锐轩
 * @updateDate：2018/1/17 14:38
 * @remarks：
 */
public class BizDetail {

	String requestNo;

	String tradeType;

	String projectNo;

	String saleRequestNo;

	List<Detail> details;

	public String getRequestNo() {
		return requestNo;
	}

	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}

	public String getSaleRequestNo() {
		return saleRequestNo;
	}

	public void setSaleRequestNo(String saleRequestNo) {
		this.saleRequestNo = saleRequestNo;
	}

	public List<Detail> getDetails() {
		return details;
	}

	public void setDetails(List<Detail> details) {
		this.details = details;
	}
}

/**    
 * @Title：FundTransferDetailDTO.java    
 * @Package com.crfchina.cdg.dto.param
 *     
 * @date 2018年1月6日 上午11:08:10 
 * @version V1.0
 */
package com.crfchina.cdg.dto.param;

import java.io.Serializable;

/**
 * 
 * @ProjectName：cdg-service
 * @ClassName：FundTransferDetailDTO 
 * @Description:交易明细DTO
 * @author: William
 * @date：2018年1月6日 上午11:08:10
 * @updateBy：William
 * @updateDate：2018年1月6日 上午11:08:10
 * @remarks：
 */
public class FundTransferDetailDTO implements Serializable{
	
	protected String accountSubjectCode;//交易科目
	protected String originFcpTrxNo;//原交易冻结流水号(通常是投资申请时预冻结流水号/还款时冻结流水号)
	protected String fromPlatformUserNo;//付款方用户号
	protected String fromUserName;//付款方用户姓名
	protected String toPlatformUserNo;//收款方用户号
	protected String toUserName;//收款方用户姓名
	
	protected Long amount;//划拨金额（分）
	protected Long share;//债权转让份额（债权转让时填写）
	protected String remark;//备注

	public String getAccountSubjectCode() {
		return accountSubjectCode;
	}

	public void setAccountSubjectCode(String accountSubjectCode) {
		this.accountSubjectCode = accountSubjectCode;
	}

	public String getOriginFcpTrxNo() {
		return originFcpTrxNo;
	}

	public void setOriginFcpTrxNo(String originFcpTrxNo) {
		this.originFcpTrxNo = originFcpTrxNo;
	}

	public String getFromPlatformUserNo() {
		return fromPlatformUserNo;
	}

	public void setFromPlatformUserNo(String fromPlatformUserNo) {
		this.fromPlatformUserNo = fromPlatformUserNo;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public String getToPlatformUserNo() {
		return toPlatformUserNo;
	}

	public void setToPlatformUserNo(String toPlatformUserNo) {
		this.toPlatformUserNo = toPlatformUserNo;
	}

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Long getShare() {
		return share;
	}

	public void setShare(Long share) {
		this.share = share;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	
	
	
	
	
}

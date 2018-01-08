/**    
 * @Title：LmFundTransferParamDTO.java    
 * @Package com.crfchina.cdg.dto.param
 *     
 * @date 2018年1月6日 上午11:06:30 
 * @version V1.0
 */
package com.crfchina.cdg.dto.param;

import java.util.List;

import com.crfchina.cdg.common.enums.business.TransactionType;
import com.crfchina.cdg.dto.base.BaseParamDTO;

/**    
 * 
 * @ProjectName：cdg-service
 * @ClassName：LmFundTransferParamDTO 
 * @Description:
 * @author: William
 * @date：2018年1月6日 上午11:06:30
 * @updateBy：William
 * @updateDate：2018年1月6日 上午11:06:30
 * @remarks：
 */
public class LmFundTransferParamDTO extends BaseParamDTO{
	
	protected TransactionType tradeType;//交易类型
	protected String fromPlatformUserNo;//付款方用户号
	protected String toPlatformUserNo;//收款方用户号
	protected String projectNo;//标的号
	protected Long amount;//划拨金额（分）
	
	protected List<FundTransferDetailDTO> transferDetailList;

	public TransactionType getTradeType() {
		return tradeType;
	}

	public void setTradeType(TransactionType tradeType) {
		this.tradeType = tradeType;
	}

	public String getFromPlatformUserNo() {
		return fromPlatformUserNo;
	}

	public void setFromPlatformUserNo(String fromPlatformUserNo) {
		this.fromPlatformUserNo = fromPlatformUserNo;
	}

	public String getToPlatformUserNo() {
		return toPlatformUserNo;
	}

	public void setToPlatformUserNo(String toPlatformUserNo) {
		this.toPlatformUserNo = toPlatformUserNo;
	}

	public String getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public List<FundTransferDetailDTO> getTransferDetailList() {
		return transferDetailList;
	}

	public void setTransferDetailList(List<FundTransferDetailDTO> transferDetailList) {
		this.transferDetailList = transferDetailList;
	}
	
	

}

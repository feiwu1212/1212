/**    
 * @Title：LmUnFreezePreTransactionParamDTO.java    
 * @Package com.crfchina.cdg.dto.param
 *     
 * @date 2018年1月6日 上午10:25:41 
 * @version V1.0
 */
package com.crfchina.cdg.dto.param;

import java.util.List;

import com.crfchina.cdg.dto.base.LmAPIBaseParamDTO;

/**    
 * 
 * @ProjectName：cdg-service
 * @ClassName：LmUnFreezePreTransactionParamDTO
 * @Description:
 * @author: William
 * @date：2018年1月6日 上午10:25:41
 * @updateBy：William
 * @updateDate：2018年1月6日 上午10:25:41
 * @remarks：预处理解冻
 */
public class LmUnFreezePreTransactionParamDTO extends LmAPIBaseParamDTO {
	
	protected String originFcpTrxNo;//原交易冻结流水号(通常是投资申请时预冻结流水号/还款时冻结流水号)
	protected Long amount;//解冻金额
	protected Long commissionAmount;//平台佣金
	protected List<ProfitDetailDTO> profitDetailList;//分润明细
	
	public String getOriginFcpTrxNo() {
		return originFcpTrxNo;
	}
	public void setOriginFcpTrxNo(String originFcpTrxNo) {
		this.originFcpTrxNo = originFcpTrxNo;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public Long getCommissionAmount() {
		return commissionAmount;
	}
	public void setCommissionAmount(Long commissionAmount) {
		this.commissionAmount = commissionAmount;
	}
	public List<ProfitDetailDTO> getProfitDetailList() {
		return profitDetailList;
	}
	public void setProfitDetailList(List<ProfitDetailDTO> profitDetailList) {
		this.profitDetailList = profitDetailList;
	}
	
	

}

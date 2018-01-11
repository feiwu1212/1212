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
	
	/**    
	 * serialVersionUID:TODO    
	 *  
	 */    
	
	private static final long serialVersionUID = 1L;
	protected TransactionType tradeType;//交易主业务类型（比如：放款、还款、代偿、债权认购等）
	protected String projectNo;//标的号
	protected Long totalAmount;//所有明细总金额（分）
	
	protected List<FundTransferDetailDTO> mainTransferList;//主业务必须（通常指投标放款、还款）
	protected List<FundTransferDetailDTO> subTransferDetailList;//副业务非必须（通常指佣金、分润）
	
	public TransactionType getTradeType() {
		return tradeType;
	}
	public void setTradeType(TransactionType tradeType) {
		this.tradeType = tradeType;
	}
	public String getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}
	public Long getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Long totalAmount) {
		this.totalAmount = totalAmount;
	}
	public List<FundTransferDetailDTO> getMainTransferList() {
		return mainTransferList;
	}
	public void setMainTransferList(List<FundTransferDetailDTO> mainTransferList) {
		this.mainTransferList = mainTransferList;
	}
	public List<FundTransferDetailDTO> getSubTransferDetailList() {
		return subTransferDetailList;
	}
	public void setSubTransferDetailList(List<FundTransferDetailDTO> subTransferDetailList) {
		this.subTransferDetailList = subTransferDetailList;
	}

}

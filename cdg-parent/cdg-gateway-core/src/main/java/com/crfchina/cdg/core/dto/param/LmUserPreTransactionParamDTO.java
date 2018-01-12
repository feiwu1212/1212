/**    
 * @Title：LmUserPreTransactionParamDTO.java    
 * @Package com.crfchina.cdg.core.dto.param
 *     
 * @date 2018年1月6日 下午4:52:09 
 * @version V1.0
 */
package com.crfchina.cdg.core.dto.param;

import com.crfchina.cdg.core.dto.base.LmGatewayBaseParamDTO;

/**    
 * 
 * @ProjectName：cdg-gateway-core
 * LmUserPreTransactionParamDTO 
 * @Description: 用户资金冻结，用以处理后续用户资金的动作
 * @author: ghf
 * @date：2018年1月6日 下午4:52:09
 * @updateBy：ghf
 * @updateDate：2018年1月6日 下午4:52:09
 * @remarks：
 */
public class LmUserPreTransactionParamDTO extends LmGatewayBaseParamDTO {
	
	private static final long serialVersionUID = 1L;
	protected Long amount;//冻结金额
	protected Long preMarketingAmount;//预备使用的红包金额，只记录不冻结，仅限投标业务类型 
	protected String expired;//页面过期时间
	protected String bizType;  //预处理业务类型
	protected String projectNo; //标的号
	protected String share; //购买债转份额，业务类型为债权认购时，需要传此参数
	protected String remark; //备注
	protected String originFcpTrxNo; //债权出让交易流水号，只有债权认购业务需填此参数 
	
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public Long getPreMarketingAmount() {
		return preMarketingAmount;
	}
	public void setPreMarketingAmount(Long preMarketingAmount) {
		this.preMarketingAmount = preMarketingAmount;
	}
	public String getBizType() {
		return bizType;
	}
	public void setBizType(String bizType) {
		this.bizType = bizType;
	}
	public String getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}
	public String getShare() {
		return share;
	}
	public void setShare(String share) {
		this.share = share;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getOriginFcpTrxNo() {
		return originFcpTrxNo;
	}
	public void setOriginFcpTrxNo(String originFcpTrxNo) {
		this.originFcpTrxNo = originFcpTrxNo;
	}

	public String getExpired() {
		return expired;
	}

	public void setExpired(String expired) {
		this.expired = expired;
	}
}

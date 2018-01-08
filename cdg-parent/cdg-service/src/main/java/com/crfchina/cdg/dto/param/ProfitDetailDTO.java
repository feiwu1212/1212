/**    
 * @Title：ProfitDetailDTO.java    
 * @Package com.crfchina.cdg.dto.param
 *     
 * @date 2018年1月6日 下午2:40:04 
 * @version V1.0
 */
package com.crfchina.cdg.dto.param;

/**    
 * 
 * @ProjectName：cdg-service
 * @ClassName：ProfitDetailDTO
 * @Description:预处理解冻分润明细
 * @author: William
 * @date：2018年1月6日 下午2:40:04
 * @updateBy：William
 * @updateDate：2018年1月6日 下午2:40:04
 * @remarks：
 */
public class ProfitDetailDTO {
	protected String platformUserNo;//平台会员编号
	protected Long amount;//分润金额
	public String getPlatformUserNo() {
		return platformUserNo;
	}
	public void setPlatformUserNo(String platformUserNo) {
		this.platformUserNo = platformUserNo;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	
	
}

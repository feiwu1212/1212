/**    
 * @Title：LmCancelRightsSaleParamDTO.java    
 * @Package com.crfchina.cdg.dto.param
 *     
 * @date 2018年1月6日 下午5:09:50 
 * @version V1.0
 */
package com.crfchina.cdg.dto.param;

import com.crfchina.cdg.dto.base.LmAPIBaseParamDTO;

/**    
 * 
 * @ProjectName：cdg-service
 * @ClassName：LmCancelRightsSaleParamDTO
 * @Description:债权转让申请请求参数
 * @author: William
 * @date：2018年1月6日 下午5:09:50
 * @updateBy：William
 * @updateDate：2018年1月6日 下午5:09:50
 * @remarks：
 */
public class LmCancelRightsSaleParamDTO extends LmAPIBaseParamDTO {
	
	
	protected String originFcpTrxNo;//债权出让请求流水号(通常是债权出让的流水号)

	public String getOriginFcpTrxNo() {
		return originFcpTrxNo;
	}

	public void setOriginFcpTrxNo(String originFcpTrxNo) {
		this.originFcpTrxNo = originFcpTrxNo;
	}
	
	

	
}

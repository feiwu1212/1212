/**    
 * @Title：LmRightsSaleParamDTO.java    
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
 * @ClassName：LmRightsSaleParamDTO 
 * @Description:债权转让申请请求参数
 * @author: William
 * @date：2018年1月6日 下午5:09:50
 * @updateBy：William
 * @updateDate：2018年1月6日 下午5:09:50
 * @remarks：
 */
public class LmRightsSaleParamDTO extends LmAPIBaseParamDTO {
	
	protected String projectNo;//标的号
	protected Long saleShare;//出让份额（转让债权本金，单位：分）
	
	public String getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}
	public Long getSaleShare() {
		return saleShare;
	}
	public void setSaleShare(Long saleShare) {
		this.saleShare = saleShare;
	}
	
}

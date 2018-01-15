/**    
 * @Title：LmDebentureSaleParamDTO.java    
 * @Package com.crfchina.cdg.dto.param
 *     
 * @date 2018年1月6日 上午10:53:02 
 * @version V1.0
 */
package com.crfchina.cdg.dto.param;

import com.crfchina.cdg.common.enums.business.ProjectType;
import com.crfchina.cdg.common.enums.business.RepaymentType;
import com.crfchina.cdg.dto.base.LmAPIBaseParamDTO;

/**
 * 
 * 
 * @ProjectName：cdg-service
 * @ClassName：LmDebentureSaleParamDTO 
 * @Description:债券转让输入接口
 * @author: ghf
 * @date：2018年1月15日 下午5:34:42
 * @updateBy：ghf
 * @updateDate：2018年1月15日 下午5:34:42
 * @remarks：债券转让输入接口
 */
public class LmDebentureSaleParamDTO extends LmAPIBaseParamDTO {
	
	/**    
	 * serialVersionUID:TODO    
	 *  
	 */    
	
	private static final long serialVersionUID = 1L;
	protected String projectNo;//标的编号
	protected String saleShare;//转让债券份额
	public String getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}
	public String getSaleShare() {
		return saleShare;
	}
	public void setSaleShare(String saleShare) {
		this.saleShare = saleShare;
	}


}

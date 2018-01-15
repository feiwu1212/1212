/**    
 * @Title：LmDebentureSaleResultDTO.java    
 * @Package com.crfchina.cdg.dto.param
 *     
 * @date 2018年1月6日 上午10:53:02 
 * @version V1.0
 */
package com.crfchina.cdg.dto.result;

import com.crfchina.cdg.dto.base.LmBaseResultDTO;

/**
 * 
 * 
 * @ProjectName：cdg-service
 * @ClassName：LmDebentureSaleResultDTO 
 * @Description:
 * @author: ghf
 * @date：2018年1月15日 下午5:58:57
 * @updateBy：ghf
 * @updateDate：2018年1月15日 下午5:58:57
 * @remarks：
 */
public class LmDebentureSaleResultDTO extends LmBaseResultDTO {

	/**    
	 * serialVersionUID:TODO    
	 *  
	 */    
	
	private static final long serialVersionUID = 1L;
	
	protected String debentureStatus;//债权出让状态

	public String getDebentureStatus() {
		return debentureStatus;
	}

	public void setDebentureStatus(String debentureStatus) {
		this.debentureStatus = debentureStatus;
	}

	

}

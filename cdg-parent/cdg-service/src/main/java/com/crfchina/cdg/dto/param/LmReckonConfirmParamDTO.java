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
 * 
 * @ProjectName：cdg-service
 * @ClassName：LmReckonConfirmParamDTO 
 * @Description:
 * @author: ghf
 * @date：2018年1月25日 下午5:23:47
 * @updateBy：ghf
 * @updateDate：2018年1月25日 下午5:23:47
 * @remarks：
 */
public class LmReckonConfirmParamDTO extends BaseParamDTO{
	
	/**    
	 * serialVersionUID:TODO    
	 *  
	 */    
	
	private static final long serialVersionUID = 1L;
	
	protected String reckonDate ;
	
	public String getReckonDate() {
		return reckonDate;
	}

	public void setReckonDate(String reckonDate) {
		this.reckonDate = reckonDate;
	}

}

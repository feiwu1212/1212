/**    
 * @Title： LmAuthorizationEntrustPayResultDTO.java    
 * @Package com.crfchina.cdg.dto.param
 *     
 * @date 2018年1月6日 上午10:53:02 
 * @version V1.0
 */
package com.crfchina.cdg.dto.result;

import com.crfchina.cdg.dto.base.LmBaseResultDTO;

/**    
 * 
 * @ProjectName：cdg-service
 * @ClassName： LmAuthorizationEntrustPayResultDTO
 * @Description:
 * @author: William
 * @date：2018年1月6日 上午10:53:02
 * @updateBy：William
 * @updateDate：2018年1月6日 上午10:53:02
 * @remarks：
 */
public class LmAuthorizationEntrustPayResultDTO extends LmBaseResultDTO {

	private static final long serialVersionUID = 1L;
	
	protected String authorizeStatus;

	public String getAuthorizeStatus() {
		return authorizeStatus;
	}

	public void setAuthorizeStatus(String authorizeStatus) {
		this.authorizeStatus = authorizeStatus;
	}

	

}

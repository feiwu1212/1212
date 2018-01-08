/**    
 * @Title：LmGatewayBaseParamDTO.java    
 * @Package com.crfchina.cdg.dto.base
 *     
 * @date 2018年1月5日 下午3:09:29 
 * @version V1.0
 */
package com.crfchina.cdg.core.dto.base;

import com.crfchina.cdg.common.enums.business.Terminal;

/**    
 * 
 * @ProjectName：cdg-service
 * @ClassName：LmGatewayBaseParamDTO
 * @Description:
 * @author: William
 * @date：2018年1月5日 下午3:09:29
 * @updateBy：William
 * @updateDate：2018年1月5日 下午3:09:29
 * @remarks：
 */
public class LmGatewayBaseParamDTO extends BaseParamDTO{

	protected String platformUserNo;//平台用户编号
	private Terminal userDevice;//终端类型
	
	protected String callbackUrl;//重定向页面url
	protected String notifyUrl;//异步通知url
	
	public String getPlatformUserNo() {
		return platformUserNo;
	}

	public void setPlatformUserNo(String platformUserNo) {
		this.platformUserNo = platformUserNo;
	}

	public Terminal getUserDevice() {
		return userDevice;
	}

	public void setUserDevice(Terminal userDevice) {
		this.userDevice = userDevice;
	}

	public String getCallbackUrl() {
		return callbackUrl;
	}

	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}
	
	
}

/**    
 * @Title：LanmaolyAPIBaseParamDTO.java    
 * @Package com.crfchina.cdg.dto.base
 *     
 * @date 2018年1月5日 下午3:09:29 
 * @version V1.0
 */
package com.crfchina.cdg.dto.base;

/**    
 * 
 * @ProjectName：cdg-service
 * @ClassName：LanmaolyAPIBaseParamDTO
 * @Description:
 * @author: William
 * @date：2018年1月5日 下午3:09:29
 * @updateBy：William
 * @updateDate：2018年1月5日 下午3:09:29
 * @remarks：
 */
public class LmAPIBaseParamDTO extends BaseParamDTO{
	protected String platformUserNo;//平台用户编号

	public String getPlatformUserNo() {
		return platformUserNo;
	}

	public void setPlatformUserNo(String platformUserNo) {
		this.platformUserNo = platformUserNo;
	}
	
	
}

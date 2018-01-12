/**    
 * @Title：LanmaolyBaseResultDTO.java    
 * @Package com.crfchina.cdg.dto.base
 *     
 * @date 2018年1月5日 下午3:09:29 
 * @version V1.0
 */
package com.crfchina.cdg.dto.base;

/**    
 * 
 * @ProjectName：cdg-service
 * @ClassName：LanmaolyBaseResultDTO 
 * @Description:
 * @author: William
 * @date：2018年1月5日 下午3:09:29
 * @updateBy：William
 * @updateDate：2018年1月5日 下午3:09:29
 * @remarks：
 */
public class LmBaseResultDTO extends BaseResultDTO{

	/**    
	 * serialVersionUID:TODO    
	 *  
	 */    
	
	private static final long serialVersionUID = 1L;

	protected String requestRefNo;//请求参考号（内部系统交易流水号）
	
	protected String fcpTrxNo;//资金通道对懒猫交易流水号

	protected String platformUserNo;//平台用户编号
	
	public String getPlatformUserNo() {
		return platformUserNo;
	}

	public void setPlatformUserNo(String platformUserNo) {
		this.platformUserNo = platformUserNo;
	}

	public String getRequestRefNo() {
		return requestRefNo;
	}

	public void setRequestRefNo(String requestRefNo) {
		this.requestRefNo = requestRefNo;
	}

	public String getFcpTrxNo() {
		return fcpTrxNo;
	}

	public void setFcpTrxNo(String fcpTrxNo) {
		this.fcpTrxNo = fcpTrxNo;
	}
	
	

}

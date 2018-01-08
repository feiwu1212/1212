/**    
 * @Title：LmUpdateProjectParamDTO.java    
 * @Package com.crfchina.cdg.dto.param
 *     
 * @date 2018年1月6日 上午10:53:02 
 * @version V1.0
 */
package com.crfchina.cdg.dto.param;

import com.crfchina.cdg.common.enums.business.ProjectStatus;
import com.crfchina.cdg.dto.base.LmAPIBaseParamDTO;

/**    
 * 
 * @ProjectName：cdg-service
 * @ClassName：LmUpdateProjectParamDTO
 * @Description:
 * @author: William
 * @date：2018年1月6日 上午10:53:02
 * @updateBy：William
 * @updateDate：2018年1月6日 上午10:53:02
 * @remarks：标的变更状态
 */
public class LmUpdateProjectParamDTO extends LmAPIBaseParamDTO {
	
	protected String projectNo;//标的编号
	protected ProjectStatus status;//标的状态
	public String getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}
	public ProjectStatus getStatus() {
		return status;
	}
	public void setStatus(ProjectStatus status) {
		this.status = status;
	}
	
	
	

}

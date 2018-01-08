/**    
 * @Title：LmProjectParamDTO.java    
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
 * @ProjectName：cdg-service
 * @ClassName：LmProjectParamDTO 
 * @Description:
 * @author: William
 * @date：2018年1月6日 上午10:53:02
 * @updateBy：William
 * @updateDate：2018年1月6日 上午10:53:02
 * @remarks：标的请求参数
 */
public class LmCreateProjectParamDTO extends LmAPIBaseParamDTO {
	
	protected String projectNo;//标的编号
	protected Long projectAmount;//标的金额（分）
	protected String projectName;//标的名称
	protected String projectDescription;//标的描述
	protected ProjectType  projectType;//【标的类型】
	protected int projectPeriod;//标的期限(单位:天)(只做记录，不做严格校验)
	protected String annnualInterestRate;// 年化利率(只做记录，不做严格校验)
	protected RepaymentType repaymentWay;//【还款方式】(只做记录，不做严格校验)
	protected String extend;// 标的扩展信息
	public String getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}
	public Long getProjectAmount() {
		return projectAmount;
	}
	public void setProjectAmount(Long projectAmount) {
		this.projectAmount = projectAmount;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectDescription() {
		return projectDescription;
	}
	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}
	public ProjectType getProjectType() {
		return projectType;
	}
	public void setProjectType(ProjectType projectType) {
		this.projectType = projectType;
	}
	public int getProjectPeriod() {
		return projectPeriod;
	}
	public void setProjectPeriod(int projectPeriod) {
		this.projectPeriod = projectPeriod;
	}
	public String getAnnnualInterestRate() {
		return annnualInterestRate;
	}
	public void setAnnnualInterestRate(String annnualInterestRate) {
		this.annnualInterestRate = annnualInterestRate;
	}
	public RepaymentType getRepaymentWay() {
		return repaymentWay;
	}
	public void setRepaymentWay(RepaymentType repaymentWay) {
		this.repaymentWay = repaymentWay;
	}
	public String getExtend() {
		return extend;
	}
	public void setExtend(String extend) {
		this.extend = extend;
	}
	
	

}

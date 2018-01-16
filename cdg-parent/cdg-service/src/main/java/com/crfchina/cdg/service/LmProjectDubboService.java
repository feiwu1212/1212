/**    
 * @Title：LmProjectDubboService.java    
 * @Package com.crfchina.cdg.service
 *     
 * @date 2018年1月5日 下午4:49:27 
 * @version V1.0
 */
package com.crfchina.cdg.service;

import com.crfchina.cdg.dto.param.LmAuthorizationEntrustPayParamDTO;
import com.crfchina.cdg.dto.param.LmCreateProjectParamDTO;
import com.crfchina.cdg.dto.param.LmUpdateProjectParamDTO;
import com.crfchina.cdg.dto.result.LmAuthorizationEntrustPayResultDTO;
import com.crfchina.cdg.dto.result.LmCreateProjectResultDTO;
import com.crfchina.cdg.dto.result.LmUpdateProjectResultDTO;

/**
 * 
 * @ProjectName：cdg-service
 * @ClassName：LmProjectDubboService 
 * @Description:
 * @author: William
 * @date：2018年1月5日 下午4:49:27
 * @updateBy：William
 * @updateDate：2018年1月5日 下午4:49:27
 * @remarks：
 */
public interface LmProjectDubboService {

 /**
  * 创建标的ESTABLISH_PROJECT
  * @Title: establishProject  
  * @Description: 标的新增
  * @param paramDTO
  * @return
  * LmAutoWithdrawResultDTO
  * @throws
  */
	LmCreateProjectResultDTO establishProject(LmCreateProjectParamDTO paramDTO);

	/**
	 * 
	 * @Title: modifyProject  
	 * @Description: 标的变更
	 * @param paramDTO
	 * @return
	 * LmUpdateProjectResultDTO
	 * @throws
	 */
	LmUpdateProjectResultDTO modifyProject(LmUpdateProjectParamDTO paramDTO);
	
	/**
	 *  
	 * @Title: authorizationEntrustPay  
	 * @Description: 委托支付授权
	 * @param paramDTO
	 * @return
	 * LmAuthorizationEntrustPayResultDTO
	 * @throws
	 */
	LmAuthorizationEntrustPayResultDTO authorizationEntrustPay(LmAuthorizationEntrustPayParamDTO paramDTO);
	
	
}

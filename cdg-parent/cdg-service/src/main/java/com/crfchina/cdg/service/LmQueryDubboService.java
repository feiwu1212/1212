/**    
 * @Title： LmQueryDubboService.java    
 * @Package com.crfchina.cdg.service
 *     
 * @date 2018年1月5日 下午4:52:54 
 * @version V1.0
 */
package com.crfchina.cdg.service;

import com.crfchina.cdg.dto.param.LmQueryUserInformationParamDTO;
import com.crfchina.cdg.dto.result.LmQueryUserInformationResultDTO;

/**    
 * 
 * @ProjectName：cdg-service
 * @ClassName： LmQueryDubboService 
 * @Description:
 * @author: William
 * @date：2018年1月5日 下午4:52:54
 * @updateBy：William
 * @updateDate：2018年1月5日 下午4:52:54
 * @remarks：
 */
public interface LmQueryDubboService {

	
	/**
	 * 
	 * @Title: querUserInformation  
	 * @Description: 用户信息查询
	 * @param paramDTO
	 * @return
	 * LmQueryUserInformationResultDTO
	 * @throws
	 */
	LmQueryUserInformationResultDTO querUserInformation(LmQueryUserInformationParamDTO paramDTO);
	
	
}

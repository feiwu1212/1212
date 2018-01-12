/**    
 * @Title：LmProjectDubboService.java    
 * @Package com.crfchina.cdg.service
 *     
 * @date 2018年1月5日 下午4:49:27 
 * @version V1.0
 */
package com.crfchina.cdg.service;

import com.crfchina.cdg.dto.param.LmCreateProjectParamDTO;
import com.crfchina.cdg.dto.result.LmCreateProjectResultDTO;

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
  * @Description: TODO
  * @param paramDTO
  * @return
  * LmAutoWithdrawResultDTO
  * @throws
  */
	LmCreateProjectResultDTO establishProject(LmCreateProjectParamDTO paramDTO);

	
}

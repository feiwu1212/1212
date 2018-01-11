/**    
 * @Title：SysDataLoadConfiguration.java    
 * @Package com.crfchina.cdg.api.config
 *     
 * @date 2018年1月11日 下午2:44:19 
 * @version V1.0
 */
package com.crfchina.cdg.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**    
 * 
 * @ProjectName：cdg-gateway-core
 * @ClassName：SysDataLoadConfiguration 
 * @Description:初始化基础数据到Redis
 * @author: William
 * @date：2018年1月11日 下午2:44:19
 * @updateBy：William
 * @updateDate：2018年1月11日 下午2:44:19
 * @remarks：
 */
@Component
public class SysDataLoadConfiguration implements CommandLineRunner{
	
	private static final Logger logger = LoggerFactory.getLogger(SysDataLoadConfiguration.class);
	

	@Override
	public void run(String... args) throws Exception {
		logger.info("CDG-GateWay-Core初始化基础数据到Redis Start...");
		
		
		logger.info("CDG-GateWay-Core初始化基础数据Redis End...");
	}
		
	
	
}

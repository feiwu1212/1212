/**    
 * @Title：CdgAPICoreApplication.java    
 * @Package com.crfchina.cdg.api
 *     
 * @date 2018年1月6日 下午5:50:38 
 * @version V1.0
 */
package com.crfchina.cdg.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**    
 * 
 * @ProjectName：cdg-api-core
 * @ClassName：CdgAPICoreApplication 
 * @Description:
 * @author: William
 * @date：2018年1月6日 下午5:50:38
 * @updateBy：William
 * @updateDate：2018年1月6日 下午5:50:38
 * @remarks：
 */
@SpringBootApplication
public class CdgAPICoreApplication extends SpringBootServletInitializer{
	
	public static void main(String[] args) {
		SpringApplication.run(CdgAPICoreApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CdgAPICoreApplication.class);
	}

}

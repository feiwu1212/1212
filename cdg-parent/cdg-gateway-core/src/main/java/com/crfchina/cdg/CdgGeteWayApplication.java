/**    
 * @Title：CdgGeteWayApplication.java    
 * @Package com.crfchina.cdg
 *     
 * @date 2018年1月5日 下午5:35:32 
 * @version V1.0
 */
package com.crfchina.cdg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**    
 * 
 * @ProjectName：cdg-gateway-core
 * @ClassName：CdgGeteWayApplication 
 * @Description:
 * @author: William
 * @date：2018年1月5日 下午5:35:32
 * @updateBy：William
 * @updateDate：2018年1月5日 下午5:35:32
 * @remarks：
 */
@SpringBootApplication
public class CdgGeteWayApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(CdgGeteWayApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CdgGeteWayApplication.class);
	}
}

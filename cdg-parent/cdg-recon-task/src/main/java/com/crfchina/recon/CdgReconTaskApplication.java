/**    
 * @Title：CdgReconTaskApplication.java    
 * @Package com.crfchina.recon.config
 *     
 * @date 2018年1月9日 上午9:53:41 
 * @version V1.0
 */
package com.crfchina.recon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**    
 * 
 * @ProjectName：cdg-recon-task
 * @ClassName：CdgReconTaskApplication 
 * @Description:
 * @author: William
 * @date：2018年1月9日 上午9:53:41
 * @updateBy：William
 * @updateDate：2018年1月9日 上午9:53:41
 * @remarks：
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.crfchina"})
@ImportResource({"classpath*:spring-disconf.xml"})//导入spring配置
public class CdgReconTaskApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CdgReconTaskApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CdgReconTaskApplication.class);
	}

}

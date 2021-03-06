/**    
 * @Title：CdgAPICoreApplication.java    
 * @Package com.crfchina.cdg.api
 *     
 * @date 2018年1月6日 下午5:50:38 
 * @version V1.0
 */
package com.crfchina.cdg.api;

import java.io.IOException;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportResource;

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
//@ComponentScan(basePackages = {"com.crfchina"})
@SpringBootApplication
@EnableCaching  //缓存使用
@MapperScan("com.crfchina.cdg.basedb.dao")//Mybatis扫包
@ImportResource({"classpath*:spring-disconf.xml"})//导入spring配置
public class CdgAPICoreApplication extends SpringBootServletInitializer{
	
	public static void main(String[] args) {
		SpringApplication.run(CdgAPICoreApplication.class, args);
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CdgAPICoreApplication.class);
	}

}

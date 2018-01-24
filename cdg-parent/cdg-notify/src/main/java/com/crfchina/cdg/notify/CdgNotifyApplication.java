package com.crfchina.cdg.notify; /**
 * @Title：
 * @Package PACKAGE_NAME
 * @date 2018/1/10 11:18
 * @version V1.0
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * @ProjectName：cdg-parent
 * @ClassName：CdgNotifyApplication
 * @Description:
 * @author: Administrator
 * @date：2018/1/10 11:18
 * @updateBy：但锐轩
 * @updateDate：2018/1/10 11:18
 * @remarks：
 */
@SpringBootApplication
@MapperScan("com.crfchina.cdg.basedb.dao")
@ComponentScan(basePackages = {"com.crfchina"})
@ImportResource({"classpath*:spring-disconf.xml"})//导入spring配置
public class CdgNotifyApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CdgNotifyApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CdgNotifyApplication.class);
	}
}

/**
 * @Title：
 * @Package com.crfchina.cdg.api.config
 * @date 2018/1/8 16:23
 * @version V1.0
 */
package com.crfchina.cdg.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * @ProjectName：cdg-parent
 * @ClassName：DubboConfiguration
 * @Description:
 * @author: Administrator
 * @date：2018/1/8 16:23
 * @updateBy：但锐轩
 * @updateDate：2018/1/8 16:23
 * @remarks：
 */
@Configuration
@PropertySource("classpath:dubbo.properties")
@ImportResource({"classpath:dubbo/*.xml"})
public class DubboConfiguration {
}

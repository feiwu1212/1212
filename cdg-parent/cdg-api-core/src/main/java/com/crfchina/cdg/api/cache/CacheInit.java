package com.crfchina.cdg.api.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by wanye on 2017/6/3.
 */
@Component
@Order(1)
public class CacheInit implements CommandLineRunner {
	
	 @Autowired
	  private SysCodeService cacheService;

	
    @Override
    public void run(String... args) throws Exception {
	        System.out.println(">>缓存加载<<");
	        this.cacheService.loadSystemStatusCodeCache();
	        this.cacheService.loadSystemStatusCodeMetadataCache();

    }
}
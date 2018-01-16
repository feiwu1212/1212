package com.crfchina.cdg.api.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class CacheInit implements CommandLineRunner {
	
	 @Autowired
	  private SysCodeService cacheService;

	
    @Override
    public void run(String... args) throws Exception {
	        this.cacheService.loadSystemStatusCodeCache();
	        this.cacheService.loadSystemStatusCodeMetadataCache();

    }
}
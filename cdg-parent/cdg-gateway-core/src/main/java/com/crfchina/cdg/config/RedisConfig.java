/**
 * @Title：
 * @Package com.crfchina.config
 * @date 2017/8/2 19:52
 * @version V1.0
 */
package com.crfchina.cdg.config;

import org.springframework.stereotype.Component;

import com.baidu.disconf.client.common.annotations.DisconfFile;

/**
 * @ProjectName：webp2p_interface
 * @ClassName：TemplateConfig
 * @Description:
 * @author: Administrator
 * @date：2017/8/2 19:52
 * @updateBy：但锐轩
 * @updateDate：2017/8/2 19:52
 * @remarks：
 */
@Component
@DisconfFile(filename="redis.properties")
public class RedisConfig {

	private String redisMode;
	private String redisHost;
	private String redisPassword;
	private int redisMaxIdle;
	private int redisMaxTotal;
	private long redisMaxWait;
	private int redisDatabase;
	private boolean redisTestOnBorrow;
	

	public int getRedisMaxIdle() {
		return redisMaxIdle;
	}

	public void setRedisMaxIdle(int redisMaxIdle) {
		this.redisMaxIdle = redisMaxIdle;
	}

	public int getRedisMaxTotal() {
		return redisMaxTotal;
	}

	public void setRedisMaxTotal(int redisMaxTotal) {
		this.redisMaxTotal = redisMaxTotal;
	}

	public long getRedisMaxWait() {
		return redisMaxWait;
	}

	public void setRedisMaxWait(long redisMaxWait) {
		this.redisMaxWait = redisMaxWait;
	}

	public boolean isRedisTestOnBorrow() {
		return redisTestOnBorrow;
	}

	public void setRedisTestOnBorrow(boolean redisTestOnBorrow) {
		this.redisTestOnBorrow = redisTestOnBorrow;
	}

	public String getRedisMode() {
		return redisMode;
	}

	public void setRedisMode(String redisMode) {
		this.redisMode = redisMode;
	}

	public String getRedisHost() {
		return redisHost;
	}

	public void setRedisHost(String redisHost) {
		this.redisHost = redisHost;
	}

	public String getRedisPassword() {
		return redisPassword;
	}

	public void setRedisPassword(String redisPassword) {
		this.redisPassword = redisPassword;
	}


	public int getRedisDatabase() {
		return redisDatabase;
	}

	public void setRedisDatabase(int redisDatabase) {
		this.redisDatabase = redisDatabase;
	}

}

/**
 * @Title：
 * @Package com.crfchina.config
 * @date 2017/8/2 19:52
 * @version V1.0
 */
package com.crfchina.cdg.notify.config;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import redis.clients.jedis.JedisPoolConfig;

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

	private static final Logger logger = LoggerFactory.getLogger(RedisConfig.class);

	private static final String REDIS_MODEL_LOCAL="local";

	private static final String REDIS_MODEL_CLUSTER="cluster";

	private static final String REDIS_MODEL_SENTINEL="sentinel";

	@Value("${redis.redisMode}")
	private String redisMode;
	@Value("${redis.redisHost}")
	private String redisHost;
	@Value("${redis.redisPassword}")
	private String redisPassword;
	@Value("${redis.redisMaxIdle}")
	private int redisMaxIdle;
	@Value("${redis.redisMaxTotal}")
	private int redisMaxTotal;
	@Value("${redis.redisMaxWait}")
	private long redisMaxWait;
	@Value("${redis.redisDatabase}")
	private int redisDatabase;
	@Value("${redis.redisTestOnBorrow}")
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

	@Bean(name="redisTemplate")
	public RedisTemplate<Object, Object> redisTemplate(
			@Qualifier("jedisConnectionFactory") JedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
		RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(redisConnectionFactory);

		// 使用Jackson2JsonRedisSerialize 替换默认序列化
		Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

		jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

		// 设置value的序列化规则和 key的序列化规则
		redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}

	@Bean
	public StringRedisTemplate stringRedisTemplate(
			@Qualifier("jedisConnectionFactory") JedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
		StringRedisTemplate template = new StringRedisTemplate();
		template.setConnectionFactory(redisConnectionFactory);
		return template;
	}

	@Bean("jedisConnectionFactory")
	public JedisConnectionFactory connectionFactory() {
		String model = redisMode;
		if (REDIS_MODEL_LOCAL.equals(model)) {
			return localModel();
		}
		if (REDIS_MODEL_CLUSTER.equals(model)) {
			return clusterModel();
		}
		if (REDIS_MODEL_SENTINEL.equals(model)) {
			return sentinelModel();
		}
		throw new RuntimeException("不能初始化Redis,请指定Redis的启动模式");
	}

	/**
	 * localModel
	 * **/
	public JedisConnectionFactory localModel() {
		logger.info("localModel");
		JedisConnectionFactory jedis = new JedisConnectionFactory();
		String hosts = redisHost;
		String[] host = hosts.split(":");
		jedis.setHostName(host[0]);
		jedis.setPort(new Integer(host[1]));
		String password = redisPassword;
		if (!StringUtils.isEmpty(password)) {
			jedis.setPassword(password);
		}
		int index = redisDatabase;
		if (index != 0) {
			jedis.setDatabase(index);
		}
		JedisPoolConfig poolCofig = new JedisPoolConfig();
		poolCofig.setMaxIdle(redisMaxIdle);
		poolCofig.setMaxTotal(redisMaxTotal);
		poolCofig.setMaxWaitMillis(redisMaxWait);
		poolCofig.setTestOnBorrow(redisTestOnBorrow);
		jedis.setPoolConfig(poolCofig);
		jedis.afterPropertiesSet();
		return jedis;
	}

	/**
	 * clusterModel
	 * **/
	public JedisConnectionFactory clusterModel() {
		logger.info("clusterModel");
		// pool config
		JedisPoolConfig poolCofig = new JedisPoolConfig();
		poolCofig.setMaxIdle(redisMaxIdle);
		poolCofig.setMaxTotal(redisMaxTotal);
		poolCofig.setMaxWaitMillis(redisMaxWait);
		poolCofig.setTestOnBorrow(redisTestOnBorrow);
		// cluster config
		RedisClusterConfiguration redisClusterConfig = new RedisClusterConfiguration();
		String hosts = redisHost;
		String[] item = hosts.split("&");
		List<RedisNode> nodes = new ArrayList<RedisNode>();
		for (int i = 0; i < item.length; i++) {
			String[] host = item[i].split(":");
			RedisNode node = new RedisNode(host[0], new Integer(host[1]));
			nodes.add(node);
		}
		redisClusterConfig.setMaxRedirects(item.length);
		redisClusterConfig.setClusterNodes(nodes);
		// factory config
		JedisConnectionFactory factory = new JedisConnectionFactory(redisClusterConfig, poolCofig);
		String password = redisPassword;
		if (!StringUtils.isEmpty(password)) {
			factory.setPassword(password);
		}
		int index = redisDatabase;
		if (index != 0) {
			factory.setDatabase(index);
		}
		factory.afterPropertiesSet();
		return factory;
	}


	/**
	 * sentinelModel
	 * **/
	public JedisConnectionFactory sentinelModel() {
		logger.info("sentinelModel");
		// pool config
		JedisPoolConfig poolCofig = new JedisPoolConfig();
		poolCofig.setMaxIdle(redisMaxIdle);
		poolCofig.setMaxTotal(redisMaxTotal);
		poolCofig.setMaxWaitMillis(redisMaxWait);
		poolCofig.setTestOnBorrow(redisTestOnBorrow);
		// sentinel config
		RedisSentinelConfiguration redisSentinelConfiguration=new RedisSentinelConfiguration();
		String hosts = redisHost;
		String[] item = hosts.split("&");
		List<RedisNode> nodes = new ArrayList<RedisNode>();
		for (int i = 0; i < item.length; i++) {
			String[] host = item[i].split(":");
			RedisNode node = new RedisNode(host[0], new Integer(host[1]));
			nodes.add(node);
		}
		redisSentinelConfiguration.setSentinels(nodes);
		// factory config
		JedisConnectionFactory factory = new JedisConnectionFactory(redisSentinelConfiguration, poolCofig);
		String password = redisPassword;
		if (!StringUtils.isEmpty(password)) {
			factory.setPassword(password);
		}
		int index = redisDatabase;
		if (index != 0) {
			factory.setDatabase(index);
		}
		factory.afterPropertiesSet();
		return factory;
	}
}

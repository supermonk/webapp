package com.supermonk.cloud;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager.RedisCacheManagerBuilder;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableCaching
@EnableAutoConfiguration
@EnableConfigurationProperties
public class ApplicationConfiguration implements WebMvcConfigurer {
	@Value("${redis.config.expiryseconds}")
	private long redisExpiry;

	private static final String SWAGGER_UI_HTML = "swagger-ui.html";
	private static final String WEBJARS = "/webjars/**";
	private static final String CLASSPATH_RESOURCES = "classpath:/META-INF/resources/";
	private static final String CLASSPATH_WEBJARS = CLASSPATH_RESOURCES + "webjars/";

	@Primary
	@Bean(name = "redisCache")
	public CacheManager cacheManager(RedisConnectionFactory cf) {
		return RedisCacheManagerBuilder.fromConnectionFactory(cf)
				.cacheDefaults(RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(redisExpiry))).build();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(SWAGGER_UI_HTML).addResourceLocations(CLASSPATH_RESOURCES);
		registry.addResourceHandler(WEBJARS).addResourceLocations(CLASSPATH_WEBJARS);
	}

	 
}

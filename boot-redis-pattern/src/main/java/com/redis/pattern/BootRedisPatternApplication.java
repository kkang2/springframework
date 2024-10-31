package com.redis.pattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootRedisPatternApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootRedisPatternApplication.class, args);
	}

}

/*
@Bean
	public CacheManager cacheManager() {
		RedisCacheConfiguration defaultConfig = RedisCacheConfiguration.defaultCacheConfig()
	        .entryTtl(Duration.ofHours(1))  // 캐시의 유효 기간을 1시간으로 설정
	        .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
	        //.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new Jackson2JsonRedisSerializer<>(Object.class)));  // 캐시 데이터 value 직렬화할 때 JSON 으로 변환하여 저장
	        .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));  // 캐시 데이터 value 직렬화할 때 JSON 으로 변환하여 저장

	    Map<String, RedisCacheConfiguration> configurations = new HashMap<>();
	    // HashMap configuration 객체의 key 는 캐시 이름을 저장하고, value 는 캐시를 설정할 수 있는 RedisConfiguration 저장
	    // RedisCacheConfiguration 은 불변 객체이므로 entryTtl() 은 새로운 RedisCacheConfiguration 객체를 리턴
	    // 즉, 기존 defaultConfig 객체에는 영향이 없음
	    configurations.put("cmmn-code", defaultConfig.entryTtl(Duration.ofMinutes(10)));
	    configurations.put("workplace-setup", defaultConfig.entryTtl(Duration.ofMinutes(10)));
	    configurations.put("cmmn_prec_format", defaultConfig.entryTtl(Duration.ofMinutes(10)));

	    return RedisCacheManager.RedisCacheManagerBuilder
	    	.fromConnectionFactory(redisConnectionFactory())  // RedisCacheManager 가 사용할 RedisConnectionFactory 객체 설정
	        .cacheDefaults(defaultConfig) // RedisCacheConfiguration 인자를 사용하여 RedisCacheManager 의 기본 캐시 설정
	        .withInitialCacheConfigurations(configurations) // RedisCacheManager 생성 시 초기값 설정, 따라서 RedisCacheManager 스프링 빈이 생성되면 hotelCache 와 hotelAddressCache 캐시 값이 설정됨
	        .build();
	  }
	
	@Bean
	public RedisConnectionFactory redisConnectionFactory() {
		String profilesActive = env.getProperty("spring.profiles.active");
		String host = redisProperties.getHost();
		int port = redisProperties.getPort();
		String redisPass = redisProperties.getPassword();
		
		RedisClusterConfiguration clusterConfig = null;
		RedisStandaloneConfiguration standaloneConfig = null;
		
		// 레디스와 클라이언트 사이에 커넥션을 생성할 때 소요되는 최대 시간 설정
	    // 설정한 SocketOptions 객체는 ClientOptions 객체에 다시 랩핑함
	    // 랩핑한 ClientOptions 는 LettuceClientConfigurationBuilder 의 clientOptions() 메서드를 사용하여 설정 가능
	    final SocketOptions socketOptions = SocketOptions.builder().connectTimeout(Duration.ofSeconds(10)).build();
	    final ClientOptions clientOptions = ClientOptions.builder().socketOptions(socketOptions).build();

	    LettuceClientConfiguration lettuceClientConfiguration = LettuceClientConfiguration.builder()
	        .clientOptions(clientOptions)
	        .commandTimeout(Duration.ofSeconds(5))  // 레디스 명령어를 실행하고 응답받는 시간 설정
	        .shutdownTimeout(Duration.ZERO) // 레디스 클라이언트가 안전하게 종료하려고 애플리케이션이 종료될 때까지 기다리는 최대 시간
	        .build();
		
		if("prd".equals(profilesActive)) {
			clusterConfig = new RedisClusterConfiguration(redisProperties.getCluster().getNodes());
			clusterConfig.setMaxRedirects(redisProperties.getCluster().getMaxRedirects());
			clusterConfig.setPassword(redisPass);
		} else {
			standaloneConfig = new RedisStandaloneConfiguration(host, port);
			standaloneConfig.setPassword(redisPass);
		}
		
		return new LettuceConnectionFactory("prd".equals(profilesActive) ? clusterConfig : standaloneConfig, lettuceClientConfiguration);
	}*/

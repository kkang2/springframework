package com.boot.pattern.configure;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class AppConfiguration {
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		
		Resource[] mapperResources = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*Mapper.xml");
		Resource configResource = new PathMatchingResourcePatternResolver().getResource("classpath:mappers/aliasConfig.xml");
		
		System.out.println("configResource : " + configResource);
		
		sessionFactory.setMapperLocations(mapperResources);
		sessionFactory.setConfigLocation(configResource);
		
		return sessionFactory.getObject();
	}
}

package com.boot.pattern.util;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SpringInfoUtil {
	public static void printBeanNames(ApplicationContext context) {
		log.info("bean total count : {}", context.getBeanDefinitionCount());
		
		String[] beanNames = context.getBeanDefinitionNames();
		
		Arrays.sort(beanNames);
		
		for (String beanName : beanNames) {
			log.info("beanName : {}", beanName);
		}
	}
}
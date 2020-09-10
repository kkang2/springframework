package com.boot.pattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.boot.pattern.util.SpringInfoUtil;

@SpringBootApplication
//@ImportResource("classpath:application-context.xml") xml 파일에서 빈 설정 읽어오기
//@Import(ExistingConfiguration.class) 자바 파일에서 빈 설정 읽어오기
public class BootPatternApplication {
    public static void main(String[] args) {
    	ConfigurableApplicationContext context = SpringApplication.run(BootPatternApplication.class, args);
    	
    	SpringInfoUtil.printBeanNames(context);
    }
}
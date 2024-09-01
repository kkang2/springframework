package com.boot.pattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootWebPatternApplication {

    public static void main(String[] args) {
    	System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(BootWebPatternApplication.class, args);
    }

}

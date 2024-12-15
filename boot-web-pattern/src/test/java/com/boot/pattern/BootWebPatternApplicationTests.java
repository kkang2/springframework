package com.boot.pattern;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BootWebPatternApplicationTests {
	@Autowired(required = false)
	private TestRestTemplate testRestTemplate;
	
	@Test
    public void testHello() {
        String msg = testRestTemplate.getForObject("/", String.class);
        System.out.println("msg : " + msg);
        log.info("msg : {}", msg);
    }
	
    @Test
    void contextLoads(){}
}

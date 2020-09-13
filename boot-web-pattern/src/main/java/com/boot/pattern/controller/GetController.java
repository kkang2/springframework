package com.boot.pattern.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetController {
	@GetMapping("/")
	//@RequestMapping(value="/", method=RequestMethod.GET) 위와 동일 작동
	public String hello() {
		return "Hello World, from Spring boot web!";
	}
}
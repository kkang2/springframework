package com.boot.pattern.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
	@PostMapping("/")
	//@RequestMapping(value="/", method=RequestMethod.POST) 위와 동일 작동
	public String hello() {
		return "Hello World, from Spring boot web!";
	}
}
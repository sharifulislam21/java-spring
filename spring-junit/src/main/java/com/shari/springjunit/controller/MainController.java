package com.shari.springjunit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@GetMapping("/hello-world")
	public String helloworld() {
		return "Hello World";
	}
}

/*
 * (If you are using JUnit 5) In the next lecture, You do NOT need to add
 * 
 * @RunWith(SpringRunner.class) on top of
 * 
 * @WebMvcTest(HelloWorldController.class)
 * 
 * 
 * 
 * JUnit 4 Code
 * 
 * @RunWith(SpringRunner.class)
 * 
 * @WebMvcTest(HelloWorldController.class)
 * 
 * 
 * 
 * JUnit 5 Code
 * 
 * @WebMvcTest(HelloWorldController.class)
 */

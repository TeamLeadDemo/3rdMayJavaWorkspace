package com.demo.springbootdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api") // optional
public class HelloController {

	// here we create our rest endpoints by defining the rest methods
	
	// http://localhost:7272/api/hello
	@GetMapping("hello")
	public String helloEndpoint() {
		return "My Hello endpoint using spring rest!";
	}
	
}

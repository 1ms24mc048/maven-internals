package com.example.demo;

import org.springframework.bind.web.annotaion.RestController;
import org.springframework.bind.web.annotaion.GetMapping;

@RestController()
public class HelloController
{
	@GetMapping('/')
	public String home()
	{
		return "Hi from Maven";
	}
}

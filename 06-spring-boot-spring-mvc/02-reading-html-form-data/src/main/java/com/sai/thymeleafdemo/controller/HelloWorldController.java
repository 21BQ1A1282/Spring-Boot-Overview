package com.sai.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	
	// need a controller method to show initial html form
	
	@RequestMapping("/showform")
	public String showForm() {
		return "helloworld-form";
	}
	
	// need a controller method to process the html form
	
	@RequestMapping("/processform")
	public String processForm() {
		return "helloworld";
	}
}

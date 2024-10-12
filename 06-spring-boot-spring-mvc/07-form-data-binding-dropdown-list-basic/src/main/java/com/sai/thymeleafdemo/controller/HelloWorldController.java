package com.sai.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {
	
	// need a controller method to show initial html form
	
	@GetMapping("/showform")
	public String showForm() {
		return "helloworld-form";
	}
	
	// need a controller method to process the html form
	
	@RequestMapping("/processform")
	public String processForm() {
		return "helloworld";
	}
	
	// need a controller method to read form data and add data to the model
	
	@RequestMapping("/processformversiontwo")
	public String newVersionProcessForm(HttpServletRequest request, Model model) {
		
		// read the request parameter from the html form
		
		String theName = request.getParameter("studentName");
		
		// convert the data to all caps
		
		theName = theName.toUpperCase();
		
		// create the message
		
		String result = "Hi!"+ theName;
		
		// add message to the model
		
		model.addAttribute("message",result);
		
		return "helloworld";
	}
	
	
	
	@PostMapping("/processformversionthree")
	public String newVersionProcessFormthree(@RequestParam("studentName") String theName, Model model) {
		
		// convert the data to all caps
		
		theName = theName.toUpperCase();
		
		// create the message
		
		String result = "How are you "+ theName;
		
		// add message to the model
		
		model.addAttribute("message",result);
		
		return "helloworld";
	}
}

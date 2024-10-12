package com.sai.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sai.thymeleafdemo.model.Student;

@Controller
public class StudentController {
	
	
	@GetMapping("/showstudentform")
	public String showForm(Model model) {
		
		// create a student object
		Student theStudent = new Student();
		
		// add student object to the model
		model.addAttribute("student",theStudent);
		
		return "student-form";
	}
	
	@PostMapping("/processstudentform")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		return "student-confirmation";
	}
}

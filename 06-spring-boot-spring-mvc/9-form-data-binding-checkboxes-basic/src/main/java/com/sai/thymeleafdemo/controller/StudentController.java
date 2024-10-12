package com.sai.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sai.thymeleafdemo.model.Student;

@Controller
public class StudentController {
	
	@Value("${countries}")
	private List<String> countries;
	
	@Value("${langauages}")
	private List<String> langauages;
	
	@Value("${systems}")
	private List<String> systems;
	
	@GetMapping("/showstudentform")
	public String showForm(Model model) {
		
		// create a student object
		Student theStudent = new Student();
		
		// add student object to the model
		model.addAttribute("student",theStudent);
		
		// add the list of countries to the model
		model.addAttribute("countries", countries);
		
		// add the list of programmingLangauage to the model
		model.addAttribute("langauages", langauages);
		
		// add the list of os to the model
		model.addAttribute("systems", systems);
		
		return "student-form";
	}
	
	@PostMapping("/processstudentform")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		return "student-confirmation";
	}
}

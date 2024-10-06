package com.sai.demo.rest;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sai.demo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	// define endpoint for "/students" - return a list of students
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		List<Student> li=new ArrayList<>();
		li.add(new Student("sai","madhavarapu"));
		li.add(new Student("siva","kandula"));
		
		return li;
	}
}

package com.sai.demo.rest;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sai.demo.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudents;
	
	// define @PostConstruct to load the student data ... only once
	
	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<>();
		theStudents.add(new Student("sai","madhavarapu"));
		theStudents.add(new Student("siva","kandula"));
	}
	
	// define endpoint for "/students" - return a list of students
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		return theStudents;
	}
	
	// define endpoint for "/students/{studentId}" - return student at index
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId){
		return theStudents.get(studentId);
	}
}

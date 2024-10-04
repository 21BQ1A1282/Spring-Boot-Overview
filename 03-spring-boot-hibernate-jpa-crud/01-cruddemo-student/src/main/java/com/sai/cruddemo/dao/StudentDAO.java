package com.sai.cruddemo.dao;

import java.util.List;

import com.sai.cruddemo.entity.Student;

public interface StudentDAO {
	
	// Create - C
	void save(Student theStudent);
	
	// Read - R
	Student findById(Integer id);
	
	// Read - R (query - findAll())
	List<Student> findAll();
	
	List<Student> findByLastName(String theLastName);
	
	// Update - U 
	
	void update(Student theStudent);
	
	// Delete - D
	
	void delete(Integer id);
	
	int deleteAll();
}

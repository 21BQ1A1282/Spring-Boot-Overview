package com.sai.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sai.cruddemo.dao.StudentDAO;
import com.sai.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// Create - C

			//createStudent(studentDAO);
			//createMultipleStudent(studentDAO);

			// Read  - R

			//readStudent(studentDAO);

			// Read - R (query - findAll())

			//queryForStudents(studentDAO);

			//queryForStudentsByLastName(studentDAO);
			
			// Update - U 
			
			//updateStudent(studentDAO);
			
			// Delete - D
			
			//deleteStudent(studentDAO);
			
			//deleteAllStudents(studentDAO);
		};
	}

	private void createMultipleStudent(StudentDAO studentDAO) {

		// create the student object

		System.out.println("creating 3 student object ...");
		Student tempstudent1=new Student("sai","mad","saimad@123.com");
		Student tempstudent2=new Student("mani","madha","mani@123.com");
		Student tempstudent3=new Student("kanta","madhava","kanta@123.com");

		// save the student object

		System.out.println("saving the student...");
		studentDAO.save(tempstudent1);
		studentDAO.save(tempstudent2);
		studentDAO.save(tempstudent3);

	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object

		System.out.println("creating new student object ...");
		Student tempstudent=new Student("paul","Doe","sai@123.com");

		// save the student object

		System.out.println("saving the student...");
		studentDAO.save(tempstudent);

		// display id of the saved student

		System.out.println("saved student. Generated id: "+ tempstudent.getId());
	}

	private void readStudent(StudentDAO studentDAO) {

		// create the student object

		System.out.println("creating new student object ...");
		Student tempstudent=new Student("siva","kand","siva@123.com");

		// save the student object

		System.out.println("saving the student...");
		studentDAO.save(tempstudent);

		// display id of the saved student

		int theId=tempstudent.getId();
		System.out.println("saved student. Generated id: "+ theId);

		// retrieve student based on the id : primary key
		System.out.println("Retrieving student with is : "+ theId);
		Student mystudent=studentDAO.findById(theId);

		// display student

		System.out.println("Found the student: "+mystudent);

	}

	private void queryForStudents(StudentDAO studentDAO) {

		// get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// display list of students
		for (Student tempStudent:theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("kand");

		// display list of students
		for (Student tempStudent:theStudents) {
			System.out.println(tempStudent);
		}
	}
	
	private void updateStudent(StudentDAO studentDAO) {
		
		// retrieve student based on the id : primary key 
		int studentId = 1;
		System.out.println("Getting Student with id: "+studentId);
		Student myStudent = studentDAO.findById(studentId);
		
		// change first name to "mani"
		System.out.println("updating student....");
		myStudent.setFirstName("mani");
		
		// update the student
		studentDAO.update(myStudent);
		
		// display updated student
		System.out.println("updated student: "+ myStudent);
	}
	
	private void deleteStudent(StudentDAO studentDAO) {
		
		// delete the student
		
		int studentId = 1;
		System.out.println("Deleting Student id: "+studentId);
		studentDAO.delete(studentId);
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsdel= studentDAO.deleteAll();
		System.out.println("Deleted row count : "+ numRowsdel);
	}
}

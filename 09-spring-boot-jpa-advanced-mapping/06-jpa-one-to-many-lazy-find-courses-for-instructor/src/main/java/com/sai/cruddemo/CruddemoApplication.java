package com.sai.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sai.cruddemo.dao.AppDAO;
import com.sai.cruddemo.entity.Course;
import com.sai.cruddemo.entity.Instructor;
import com.sai.cruddemo.entity.InstructorDetail;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner ->{
			// createInstructor(appDAO);

            // findInstructor(appDAO);

			// deleteInstructor(appDAO);

			// findInstructorDetail(appDAO);

			// deleteInstructorDetail(appDAO);

			// CreateInstructorWithCourse(appDAO);

			// findInstructorWithCourses(appDAO);

			findCoursesForInstructor(appDAO);

		};
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId = 1;
		// find instructor
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);

		// find courses for instructor
		System.out.println("Finding courses for instructor id: " + theId);
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);

		// associate the objects
		tempInstructor.setCourses(courses);

		System.out.println("the associated courses: " + tempInstructor.getCourses());

		System.out.println("Done!");

	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		
		int theId=1;

		System.out.println("Finding instructor id: "+ theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: "+ tempInstructor);

		System.out.println("the associated courses : "+ tempInstructor.getCourses());

		System.out.println("Done");
	}

	private void CreateInstructorWithCourse(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("siva","madhav","siva@gmail.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("https://youtu.be/67ka17XZE7s?si=XEN10eaczouOVSsa","sai!!");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		Course tempCourse = new Course("Air guitar--  ");
		Course tempCourse1 = new Course("Air --  ");

		tempInstructor.add(tempCourse);
		tempInstructor.add(tempCourse1);

		System.out.println("saving instructor: "+tempInstructor);
		System.out.println("The Courses : "+tempInstructor.getCourses());
		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId=4;
		System.out.println("Deleting instrutorDetail id: "+theId);

		appDAO.deleteInstructorDetailById(theId);

		System.out.println("Done");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		
		int theId=3;

		InstructorDetail tempInstructor = appDAO.findInstructorDetailById(theId);

		System.out.println("tempInstructor: "+ tempInstructor);

		System.out.println("the associated instructorDetail only : "+ tempInstructor.getInstructor());

		System.out.println("Done");
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId=2;
		System.out.println("Deleting instrutor id: "+theId);

		appDAO.deleteInstructorById(theId);

		System.out.println("Done");
	}

	private void findInstructor(AppDAO appDAO) {
		
		int theId=1;
		System.out.println("Finding instrutor id: "+theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: "+ tempInstructor);
		System.out.println("the associated instructorDetail only : "+ tempInstructor.getInstructorDetail());

	}

	private void createInstructor(AppDAO appDAO) {

		Instructor tempInstructor = new Instructor("sai","madhav","sai@gmail.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("https://youtu.be/67ka17XZE7s?si=XEN10eaczouOVSsa","sai!!");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		System.out.println("saving instructor: "+tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}

}

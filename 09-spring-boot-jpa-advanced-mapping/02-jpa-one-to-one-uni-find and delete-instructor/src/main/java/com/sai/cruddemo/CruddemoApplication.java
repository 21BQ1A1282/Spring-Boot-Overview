package com.sai.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sai.cruddemo.dao.AppDAO;
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

			deleteInstructor(appDAO);
		};
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

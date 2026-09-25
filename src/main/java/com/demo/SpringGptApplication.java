package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.demo.repository.StudentRepository;

@SpringBootApplication
public class SpringGptApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(SpringGptApplication.class, args);
		
		StudentRepository srepo=context.getBean(StudentRepository.class);
		
//		srepo.findStudentByPattern("ra").forEach(System.out::println);
	
//		srepo.findStudentMarksGreaterThan(95.0).forEach(System.out::println);
		
//		srepo.findAllStudents().forEach(System.out::println);
		
//		srepo.findByPattern("%ra%").forEach(System.out::println);
		
//		srepo.findStudentByMarks(95.0).forEach(System.out::println);
		
		
	}

}

package com.example.studentallocation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.studentallocation")
public class StudentAllocationApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentAllocationApplication.class, args);
	}

}

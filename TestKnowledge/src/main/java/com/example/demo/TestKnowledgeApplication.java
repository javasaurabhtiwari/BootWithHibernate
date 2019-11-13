package com.example.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Entity.Student;


@SpringBootApplication
public class TestKnowledgeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestKnowledgeApplication.class, args);
		
	}

}

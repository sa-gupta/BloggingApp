package com.cg.blogging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BloggingMain {

	public static void main(String[] args) {
		SpringApplication.run(BloggingMain.class, args);
		System.out.println("......Server running on port 8083.......");
	}

}

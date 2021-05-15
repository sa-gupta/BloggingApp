package com.cg.blogging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <h1>Blogging Main Class</h1> This class starts the spring application
 * 
 * @author Sachin Gupta
 *
 */

@SpringBootApplication
public class BloggingMain {

	public static void main(String[] args) {
		SpringApplication.run(BloggingMain.class, args);
		System.out.println("......Server running on port 8083.......");
	}
}

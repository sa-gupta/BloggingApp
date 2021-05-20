package com.cg.blogging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

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
	
	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource src = new UrlBasedCorsConfigurationSource();
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowCredentials(true);
		configuration.addAllowedHeader("*");
		configuration.addAllowedOrigin("*");
		configuration.addAllowedMethod("*");
		src.registerCorsConfiguration("/**", configuration);
		return new CorsFilter(src);	
	}
}

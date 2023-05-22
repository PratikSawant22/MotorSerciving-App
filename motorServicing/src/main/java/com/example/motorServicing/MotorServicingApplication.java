package com.example.motorServicing;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class MotorServicingApplication  {

	public static void main(String[] args) {
		SpringApplication.run(MotorServicingApplication.class, args);
	}

}

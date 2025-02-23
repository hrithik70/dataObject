package com.hrithik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.hrithik")
public class DataObjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataObjectApplication.class, args);
	}

}

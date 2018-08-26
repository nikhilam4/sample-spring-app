package com.nikhila.sampleproject.nikhilalearningfullstackappangularspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class NikhilaLearningFullStackAppAngularSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(NikhilaLearningFullStackAppAngularSpringBootApplication.class, args);
	}
}

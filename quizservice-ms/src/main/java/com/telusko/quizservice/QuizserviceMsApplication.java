package com.telusko.quizservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class QuizserviceMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizserviceMsApplication.class, args);
	}

}

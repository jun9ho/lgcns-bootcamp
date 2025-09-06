package com.lgcns.practice_inspire_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class PracticeInspireSpringApplication {

	public static void main(String[] args) {

		//한번 정리해야됨
		Dotenv env = Dotenv.configure().ignoreIfMissing().load();
		env.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));
		
		SpringApplication.run(PracticeInspireSpringApplication.class, args);
	}

}

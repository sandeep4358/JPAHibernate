package com.example.JPAjoinPactice001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories("com.roytuts.spring.data.jpa.left.right.inner.cross.join.repository")

public class JpAjoinPactice001Application {

	public static void main(String[] args) {
		SpringApplication.run(JpAjoinPactice001Application.class, args);
	}

}

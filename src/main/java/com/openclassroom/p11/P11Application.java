package com.openclassroom.p11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
@Transactional
@SpringBootApplication
public class P11Application {

	public static void main(String[] args) {
		SpringApplication.run(P11Application.class, args);
	}

}

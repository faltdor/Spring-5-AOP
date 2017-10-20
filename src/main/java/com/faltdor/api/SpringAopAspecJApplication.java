package com.faltdor.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringAopAspecJApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAopAspecJApplication.class, args);
	}
}

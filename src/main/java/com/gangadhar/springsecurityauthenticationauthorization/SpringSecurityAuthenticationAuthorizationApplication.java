package com.gangadhar.springsecurityauthenticationauthorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.gangadhar")
public class SpringSecurityAuthenticationAuthorizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityAuthenticationAuthorizationApplication.class, args);
	}

}

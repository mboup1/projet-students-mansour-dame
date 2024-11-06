package com.dame_mansour.app_spring_security;

import com.dame_mansour.app_spring_security.entities.User;
import com.dame_mansour.app_spring_security.repository.UserRepository;
import com.dame_mansour.app_spring_security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppSpringSecurityApplication {

	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(AppSpringSecurityApplication.class, args);
	}


}

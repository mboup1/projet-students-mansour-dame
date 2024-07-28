package com.mansour_dame.Eureka.sever;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaServer
public class EurekaSeverApplication {
	@Value("${name}")
	public String name;

	@Value("${password}")
	public String password;

	public static void main(String[] args) {
		SpringApplication.run(EurekaSeverApplication.class, args);
	}

	@Bean
	public CommandLineRunner printCredentials() {
		return args -> {
			System.out.println("Username: " + name);
			System.out.println("Password: " + password);
		};
	}

}

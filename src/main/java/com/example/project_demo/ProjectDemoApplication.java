package com.example.project_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true)
public class ProjectDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectDemoApplication.class, args);
	}

}

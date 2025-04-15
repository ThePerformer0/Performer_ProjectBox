package com.projectbox.projectbox_backend;

import com.projectbox.projectbox_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectboxBackendApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ProjectboxBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userService.createAdmin();
	}

}

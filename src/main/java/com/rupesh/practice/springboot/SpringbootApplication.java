package com.rupesh.practice.springboot;

import com.rupesh.practice.springboot.model.AppUser;
import com.rupesh.practice.springboot.model.Role;
import com.rupesh.practice.springboot.service.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class SpringbootApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

	@Bean
	CommandLineRunner run(AppUserService appUserService) {
		return args -> {
			//Adding role to database in Role table
			appUserService.saveRole(new Role(null, "ROLE_USER"));

			//Adding users to database in User table
			appUserService.saveAppUser(new AppUser("Sundar Pichai", "sundar", "1234", new ArrayList<>()));
			appUserService.saveAppUser(new AppUser("Parag Agrawal", "parag", "1234", new ArrayList<>()));

			//Adding role to user to database in appuser_role table
			appUserService.addRoleToUser("sundar", "ROLE_USER");
		};
	}
}

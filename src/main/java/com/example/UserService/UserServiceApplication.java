package com.example.UserService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;


@SpringBootApplication
@EntityScan("com.example.UserService.domain")
public class UserServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(UserServiceApplication.class, args);
	}

	/*@Bean
	CommandLineRunner run (UserService userService){
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new AppUser(null, "John Peter", "John", "123456", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Alice Wonder", "Alice", "1234567", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Jane Chris", "Jane", "12345678", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "Joseph Apple", "Joseph", "123456789", new ArrayList<>()));

			userService.addRoleToUser("John", "ROLE_USER");
			userService.addRoleToUser("John", "ROLE_MANAGER");
			userService.addRoleToUser("Alice", "ROLE_MANAGER");
			userService.addRoleToUser("Jane", "ROLE_ADMIN");
			userService.addRoleToUser("Joseph", "ROLE_USER");
			userService.addRoleToUser("Joseph", "ROLE_ADMIN");
			userService.addRoleToUser("Joseph", "ROLE_SUPER_ADMIN");
		};

	 */
	}


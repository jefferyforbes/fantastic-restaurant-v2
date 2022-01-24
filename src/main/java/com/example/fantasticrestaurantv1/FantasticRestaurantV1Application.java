package com.example.fantasticrestaurantv1;

import com.example.fantasticrestaurantv1.users.domain.Role;
import com.example.fantasticrestaurantv1.users.domain.User;
import com.example.fantasticrestaurantv1.users.domain.UserType;
import com.example.fantasticrestaurantv1.users.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Properties;

@SpringBootApplication
public class FantasticRestaurantV1Application {

	public static void main(String[] args) {
		SpringApplication.run(FantasticRestaurantV1Application.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner propertiesRunner() {
		Properties prop = new Properties();

		prop.setProperty("practice", "value_practice");
		prop.setProperty("java.runtime.version", "17");
		prop.setProperty("java", "java.runtime.version=17");

		System.out.println(prop.getProperty("practice"));
		System.out.println(prop.keySet());
		return null;
	}

    @Bean
    CommandLineRunner runner(UserService userService) {
        userService.createRole(new Role(1, "ROLE_USER"));

        userService.registerUser(new User("",
                "jeffery_main_user",
                "main_password",
                "jefferyforbes.1@outlook.com",
                "07504516578",
                LocalDate.now(),
                UserType.PERSONAL,
                LocalDateTime.now(),
                LocalDateTime.now()));
        return null;
    }
}

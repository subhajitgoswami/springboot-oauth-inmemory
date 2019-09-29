package com.subhajit.springsecurityoauth;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RestController;

import com.subhajit.springsecurityoauth.dao.UserDao;
import com.subhajit.springsecurityoauth.model.User;

@SpringBootApplication
@EnableAuthorizationServer
@EnableResourceServer
@RestController
public class SpringOauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringOauthApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(UserDao repository) {
		return args -> {
			repository.save(
					new User(1, "Alex123", "$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu", 3456, 33));
			repository.save(
					new User(2, "Tom234", "$2a$04$PCIX2hYrve38M7eOcqAbCO9UqjYg7gfFNpKsinAxh99nms9e.8HwK", 7823, 23));
			repository.save(
					new User(3, "Adam", "$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu", 4234, 45));
		};
	}
}

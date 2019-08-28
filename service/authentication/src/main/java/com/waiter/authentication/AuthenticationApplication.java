package com.waiter.authentication;

import com.waiter.authentication.user.UserService;
import com.waiter.authentication.user.User;
import com.waiter.authentication.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

import java.util.NoSuchElementException;

@SpringBootApplication
@Slf4j
public class AuthenticationApplication {

	@Autowired
	@Lazy
	private UserService accountService;

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationApplication.class, args);
	}


	@Bean
	public CommandLineRunner initUser(UserRepository repository) {
		//
		return (args) -> {
			accountService.saveUser("test", "test", "홍길동");
			accountService.saveUser("test2", "test2", "길동이");
			accountService.saveUser("test3", "test3", "개똥이");
			accountService.saveUser("test4", "test4", "헬로카봇");

			for (User user : repository.findAll()) {
				log.info("\n## found user : {}", user);
			}

			User user = repository.findByLoginId("test").orElseThrow(() -> new NoSuchElementException());
			log.info("\n## user : {}", user);
		};
	}
}

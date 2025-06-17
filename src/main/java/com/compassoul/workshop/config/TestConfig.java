package com.compassoul.workshop.config;

import com.compassoul.workshop.entities.User;
import com.compassoul.workshop.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    private final UserRepository userRepository;

    @Autowired  // Optional declaration
    public TestConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        userRepository.saveAll(Arrays.asList(
                new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"),
                new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"),
                new User(null, "José White", "jose@gmail.com", "966666666", "123456")
        ));
    }
}

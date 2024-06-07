package com.example.library.config;

import com.example.library.models.User;
import com.example.library.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "Rua Baiano", "86994778760");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "Rua Pinheiro", "86994778760");

        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}

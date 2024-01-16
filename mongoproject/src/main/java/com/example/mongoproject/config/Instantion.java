package com.example.mongoproject.config;


import com.example.mongoproject.domain.User;
import com.example.mongoproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantion implements CommandLineRunner {


    @Autowired
    UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User stephan = new User(null, "Stephan Guimaraes", "stephan.guimaraess@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, stephan, bob));
    }
}

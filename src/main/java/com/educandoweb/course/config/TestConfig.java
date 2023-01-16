package com.educandoweb.course.config;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "999999999", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "88888888", "654321");
        User u3 = new User(null, "Luis Felipe Rodrigues", "luisfelipebr1995@gmail.com", "(16)997198565", "987654321");

        System.out.println("Rodando com perfil Test");
        userRepository.saveAll(Arrays.asList(u1, u2, u3));
    }
}

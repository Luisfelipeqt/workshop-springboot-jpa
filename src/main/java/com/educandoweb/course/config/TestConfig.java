package com.educandoweb.course.config;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "999999999", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "88888888", "654321");
        User u3 = new User(null, "Luis Felipe Rodrigues", "luisfelipebr1995@gmail.com", "(16)997198565", "987654321");

        Order o1 = new Order(null, Instant.parse("2023-01-17T12:35:50Z"), u1);
        Order o2 = new Order(null, Instant.parse("2023-01-17T12:35:50Z"), u2);
        Order o3 = new Order(null, Instant.parse("2023-01-17T12:35:50Z"), u3);


        System.out.println("Rodando com perfil Test");
        userRepository.saveAll(Arrays.asList(u1, u2, u3));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}

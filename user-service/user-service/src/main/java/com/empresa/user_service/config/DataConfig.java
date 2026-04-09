package com.empresa.user_service.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.empresa.user_service.model.User;
import com.empresa.user_service.repository.UserRepository;

@Configuration
public class DataConfig {

    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {
    return args -> {
        List<User> initialProducts = List.of(
            new User(1L, "Dudy Bran", "Dudy.bran@gmail.com","1234")
        );

        // Si tu repositorio tiene saveAll, úsalo. 
        // Si es una lista manual, puedes hacer un forEach:
        initialProducts.forEach(repository::save);

        System.out.println(">>> Semilla de datos completada.");
        };
    }
}
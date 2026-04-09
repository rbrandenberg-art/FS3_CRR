package com.empresa.product_service.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.empresa.product_service.model.Product;
import com.empresa.product_service.repository.ProductRepository;

@Configuration
public class DataConfig {

    @Bean
    CommandLineRunner initDatabase(ProductRepository repository) {
    return args -> {
        List<Product> initialProducts = List.of(
            new Product(1L, "Monitor 4K", 350000.0),
            new Product(2L, "Audifonos inalambricos", 20000.0),
            new Product(3L, "Mouse Logitec", 10000.0)
        );

        // Si tu repositorio tiene saveAll, úsalo. 
        // Si es una lista manual, puedes hacer un forEach:
        initialProducts.forEach(repository::save);

        System.out.println(">>> Semilla de datos completada.");
        };
    }
}
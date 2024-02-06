package com.example.services;

import com.example.model.Product;
import com.example.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@AllArgsConstructor
public class FillDataBase implements CommandLineRunner {
    private ProductRepository productRepository;


    @Override
    public void run(String... args) throws Exception {

        // Добавление нескольких товаров
        productRepository.save(new Product("Laptop", 10, 1200));
        productRepository.save(new Product("Smartphone", 20, 800));
        productRepository.save(new Product("Toy 1", 20, 800));
        productRepository.save(new Product("Toy", 20, 800));
    }

}

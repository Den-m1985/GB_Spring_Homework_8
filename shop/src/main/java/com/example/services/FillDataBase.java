package com.example.services;

import com.example.model.Account;
import com.example.model.Product;
import com.example.repositories.AccountRepository;
import com.example.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@AllArgsConstructor
public class FillDataBase implements CommandLineRunner {

    private AccountRepository accountRepository;
    private ProductRepository productRepository;


    @Override
    public void run(String... args) throws Exception {
        // Заполнение базы данных примерами данных

        // Добавление нескольких аккаунтов
        accountRepository.save(new Account("John Doe", new BigDecimal("1000.00")));
        accountRepository.save(new Account("Alice Smith", new BigDecimal("2500.50")));

        // Добавление нескольких товаров
        productRepository.save(new Product("Laptop", 10, 1200));
        productRepository.save(new Product("Smartphone", 20, 800));
    }

}

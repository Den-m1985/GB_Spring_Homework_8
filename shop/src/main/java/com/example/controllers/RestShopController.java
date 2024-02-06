package com.example.controllers;


import com.example.model.Account;
import com.example.model.Product;
import com.example.repositories.AccountRepository;
import com.example.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/shop")
public class RestShopController {

    private ProductRepository productRepository;

    private AccountRepository accountRepository;


    @GetMapping("/account")
    public List<Account> findAllAccountss() {
        return accountRepository.findAll();
    }

    @GetMapping("/product")
    public  List<Product> findAllProductss() {
        return productRepository.findAll();
    }

}

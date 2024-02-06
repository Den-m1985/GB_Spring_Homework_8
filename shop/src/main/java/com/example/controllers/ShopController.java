package com.example.controllers;

import com.example.model.Account;
import com.example.model.Product;
import com.example.repositories.AccountRepository;
import com.example.repositories.ProductRepository;
import com.example.services.PaymentService;
import com.example.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/shop")
public class ShopController {

    //@Autowired
    //private StoreService storeService;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/accounts")
    public String findAllAccounts(Model model) {
        List<Account> accounts = accountRepository.findAll();
        model.addAttribute("accounts", accounts);
        return "accounts";
    }

    @GetMapping("/products")
    public String findAllProducts(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "products";
    }


    @PostMapping("/sell")
    public ResponseEntity<String> sellProduct(@RequestParam Long productId,
                                              @RequestParam int quantity,
                                              @RequestParam Long AccountId
                                              ) {
        // Продажа товара
        //storeService.sellProduct(productId, quantity);

        // Резервирование товара
        reservationService.reserveProduct(productId, quantity);
        int totalPrice = reservationService.getTotal(productId, quantity);

        // Обработка оплаты
        paymentService.transferMoney(AccountId,totalPrice);

        return ResponseEntity.ok("Product sold successfully");
    }

}

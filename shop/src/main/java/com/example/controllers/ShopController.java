package com.example.controllers;

import com.example.model.Product;
import com.example.repositories.ProductRepository;
import com.example.services.PaymentService;
import com.example.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public String findAllProducts(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "products";
    }

    // Отображение информации о товаре по ID
    @GetMapping("/product/{id}")
    public String getProductDetails(@PathVariable Long id, Model model) {
        // Получение информации о товаре из базы данных по ID
        Product product = reservationService.getProductById(id);
        model.addAttribute("product", product);
        return "product";
    }

    // Обработка покупки товара
    @PostMapping("/product/{id}")
    public String buyProduct(@PathVariable Long id, @RequestParam int quantity, Model model) {

        // Резервирование товара
        reservationService.reserveProduct(id, quantity);
        int totalPrice = reservationService.getTotal(id, quantity);

        // Обработка оплаты
        paymentService.transferMoney(id, totalPrice);

        return "redirect:/shop/";
    }

}

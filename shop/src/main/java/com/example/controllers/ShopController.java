package com.example.controllers;

import com.example.services.PaymentService;
import com.example.services.ReservationService;
import com.example.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private StoreService storeService;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private PaymentService paymentService;



    @PostMapping("/sell")
    public ResponseEntity<String> sellProduct(@RequestParam String productId, @RequestParam int quantity) {
        // Продажа товара
        storeService.sellProduct(productId, quantity);

        // Резервирование товара
        reservationService.reserveProduct(productId, quantity);

        // Обработка оплаты
        paymentService.processPayment("userId", calculateTotalAmount(productId, quantity));

        return ResponseEntity.ok("Product sold successfully");
    }


    private double calculateTotalAmount(String productId, int quantity) {
        // Логика расчета общей стоимости товара
        return 0.0; // Замените на реальную логику
    }


}

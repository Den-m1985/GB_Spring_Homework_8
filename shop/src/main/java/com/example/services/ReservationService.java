package com.example.services;

import org.springframework.transaction.annotation.Transactional;

public class ReservationService {

    @Transactional
    public void reserveProduct(String productId, int quantity) {
        // Логика резервирования товара на складе
    }


}

package com.example.services;

import com.example.model.Product;
import com.example.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@AllArgsConstructor
public class ReservationService {

    private ProductRepository productRepository;


    @Transactional
    public void reserveProduct(long productId, int quantity) {
        // Логика резервирования товара на складе
        Product product = getProductById(productId);
        int allQuatity = product.getQuantity();
        product.setQuantity(allQuatity - quantity);
        productRepository.save(product);
        throw new RuntimeException("Oh no! Reservatonal went wrong!");
    }


    public Product getProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findProductById(id);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        }
        throw new IllegalArgumentException("Product not found with id: " + id);
    }

    public int getTotal(long productId, int quantity) {
        Product product = getProductById(productId);
        return product.getPrice() * quantity;
    }

}

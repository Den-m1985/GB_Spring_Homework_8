package com.example.services;

import com.example.model.Product;
import com.example.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@AllArgsConstructor
@Service
public class PaymentService {

    private ProductRepository productRepository;

    @Transactional
    public void transferMoney(long id, int quantity) {

        Product product = getProductById(id);

        int newQuantity = product.getQuantity();
        product.setQuantity(newQuantity);

        productRepository.save(product);

    }


    public Product getProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findProductById(id);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        }
        throw new IllegalArgumentException("Product not found with id: " + id);
    }

}

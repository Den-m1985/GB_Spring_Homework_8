package com.example.services;

import com.example.model.Product;
import com.example.repositories.ProductRepository;
import lombok.AllArgsConstructor;
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
    }


    public Product getProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findProductById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            if (product.getQuantity() > 0) {
                return optionalProduct.get();
            } else throw new RuntimeException("Product: " + product.getName() + " is empty");
        }
        throw new RuntimeException("Product not found with id: " + id);
    }

    public int getTotal(long productId, int quantity) {
        Product product = getProductById(productId);
        return product.getPrice() * quantity;
    }

}

package com.example.backendspringboot.service;

import org.springframework.http.ResponseEntity;

public interface ProductService {

    ResponseEntity<?> getAllProduct();

    ResponseEntity<?> updateProductRating(Integer id, Double rate);
    
    // List<Product> getAllProduct();

    // Product updateProductRating(Integer id, Double rate);
}

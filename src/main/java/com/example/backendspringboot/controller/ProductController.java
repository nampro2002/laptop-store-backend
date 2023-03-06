package com.example.backendspringboot.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.backendspringboot.Entity.Product;
import com.example.backendspringboot.model.product.dto.ProductRatingDTO;
import com.example.backendspringboot.model.product.mapper.ProductMapper;
import com.example.backendspringboot.service.ProductService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<?> getAllProduct() {
        return productService.getAllProduct();
    }

    @PutMapping("/rate/{id}")
    public ResponseEntity<?> updateProductRating(@PathVariable Integer id, @RequestBody ProductRatingDTO productRatingDTO) {
        System.out.println("updateProductRating");
        return productService.updateProductRating(id, productRatingDTO.getRate());

    }

}

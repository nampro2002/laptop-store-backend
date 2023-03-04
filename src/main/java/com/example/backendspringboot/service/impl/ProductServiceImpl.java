package com.example.backendspringboot.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.backendspringboot.Entity.Product;
import com.example.backendspringboot.model.product.dto.ProductDTOResponse;
import com.example.backendspringboot.model.product.mapper.ProductMapper;
import com.example.backendspringboot.repository.ProductRepository;
import com.example.backendspringboot.service.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public ResponseEntity<?> getAllProduct() {
        // TODO Auto-generated method stub
        List<Product> products = null;
            products = productRepository.findAll();
            List<ProductDTOResponse> productsDtoResponses = ProductMapper.toListProductDTOResponse(products);
        return new ResponseEntity<>(productsDtoResponses, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateProductRating(Integer id, Double rate) {
        // TODO Auto-generated method stub
        Product product = productRepository.findById(id).get();
        product.setRate(rate);
        System.out.println("rate: " + rate);
        product = productRepository.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    // @Override
    // public List<Product> getAllProduct() {
    //     // TODO Auto-generated method stub
    //     List<Product> products = null;
    //     try {
    //         products = productRepository.findAll();
    //         return products;
    //     } catch (Exception e) {
    //         System.out.println(e.getMessage());
    //     }
    //     return products;
    // }

    // @Override
    // public Product updateProductRating(Integer id, Double rate) {
    //     // TODO Auto-generated method stub
    //     Product product = productRepository.findById(id).get();
    //     product.setRate(rate);
    //     System.out.println("rate: " + rate);
    //     return productRepository.save(product);
    // }

}

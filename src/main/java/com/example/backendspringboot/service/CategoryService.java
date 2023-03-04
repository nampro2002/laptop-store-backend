package com.example.backendspringboot.service;

import org.springframework.http.ResponseEntity;

public interface CategoryService {

    ResponseEntity<?> getAllCategory();
    
    // List<Category> getAllCategory();
    
}

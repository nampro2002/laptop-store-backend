package com.example.backendspringboot.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backendspringboot.Entity.Category;
import com.example.backendspringboot.service.CategoryService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/category")
    public ResponseEntity<?> getAllCategory() {       
        return  categoryService.getAllCategory();

    }
    // @GetMapping("/category")
    // public List<Category> getAllCategory() {
    //     List<Category> categories = categoryService.getAllCategory();
    //     return categories;

    // }
}

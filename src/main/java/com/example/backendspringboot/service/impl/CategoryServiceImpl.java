package com.example.backendspringboot.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.backendspringboot.Entity.Category;
import com.example.backendspringboot.repository.CategoryRepository;
import com.example.backendspringboot.service.CategoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    public ResponseEntity<?> getAllCategory() {
        // TODO Auto-generated method stub
        List<Category> categories = categoryRepository.findAll();
      return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    // @Override
    // public List<Category> getAllCategory() {
    //     // TODO Auto-generated method stub
    //   return categoryRepository.findAll();
    // }
    
}

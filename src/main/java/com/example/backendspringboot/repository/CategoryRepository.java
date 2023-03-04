package com.example.backendspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backendspringboot.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
    
}

package com.example.backendspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backendspringboot.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    
}

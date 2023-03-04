package com.example.backendspringboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backendspringboot.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    Optional<User> findByPhone(String phone);

    Boolean existsByUsername(String username);

    Boolean existsByPhone(String username);

}

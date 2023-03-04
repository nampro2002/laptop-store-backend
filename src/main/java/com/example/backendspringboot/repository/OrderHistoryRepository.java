package com.example.backendspringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.backendspringboot.Entity.OrderHistory;

public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Integer>{
    @Query("SELECT oh FROM OrderHistory oh WHERE oh.user.id = :userId")
    List<OrderHistory> findAllByUserId(@Param("userId") int userId);
}

package com.example.backendspringboot.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.backendspringboot.model.history.dto.OrderHistoryDTOResponse;

public interface OrderHistoryService {

    ResponseEntity<?> getOrerHistoryByUserId(Integer userId);

    ResponseEntity<?> addNewOrderHistory(OrderHistoryDTOResponse orderHistoryDTOResponse);
    // List<OrderHistoryDTOResponse> getOrerHistoryByUserId(Integer userId);

    // OrderHistoryDTOResponse addNewOrderHistory(OrderHistoryDTOResponse orderHistoryDTOResponse);
    
}

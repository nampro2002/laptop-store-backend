package com.example.backendspringboot.service;

import org.springframework.http.ResponseEntity;

import com.example.backendspringboot.model.history.dto.OrderHistoryDTORequest;

public interface OrderHistoryService {

    ResponseEntity<?> getOrerHistoryByUserId(Integer userId);

    ResponseEntity<?> addNewOrderHistory(OrderHistoryDTORequest orderHistoryDTORequest);
    // List<OrderHistoryDTOResponse> getOrerHistoryByUserId(Integer userId);

    // OrderHistoryDTOResponse addNewOrderHistory(OrderHistoryDTOResponse orderHistoryDTOResponse);
    
}

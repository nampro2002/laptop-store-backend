package com.example.backendspringboot.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.backendspringboot.model.history.dto.OrderHistoryDTORequest;
import com.example.backendspringboot.model.history.dto.OrderHistoryDTOResponse;
import com.example.backendspringboot.service.OrderHistoryService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
public class OrderHistoryController {
    
    private final OrderHistoryService orderHistoryService;

    @GetMapping("/history")
    public ResponseEntity<?> getOrerHistoryByUserId(@RequestParam(name = "userId", required = false) Integer userId) {
        return orderHistoryService.getOrerHistoryByUserId(userId);

    }
    @PostMapping("/history")
    public ResponseEntity<?> addNewOrderHistory(@RequestBody OrderHistoryDTORequest orderHistoryDTORequest) {
        return orderHistoryService.addNewOrderHistory(orderHistoryDTORequest);

    }

    // @GetMapping("/history")
    // public List<OrderHistoryDTOResponse> getOrerHistoryByUserId(@RequestParam(name = "userId", required = false) Integer userId) {
    //     return orderHistoryService.getOrerHistoryByUserId(userId);

    // }
    // @PostMapping("/history")
    // public OrderHistoryDTOResponse addNewOrderHistory(@RequestBody OrderHistoryDTOResponse orderHistoryDTOResponse) {
    //     return orderHistoryService.addNewOrderHistory(orderHistoryDTOResponse);

    // }

}

package com.example.backendspringboot.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.backendspringboot.Entity.OrderHistory;
import com.example.backendspringboot.Entity.User;
import com.example.backendspringboot.model.history.dto.OrderHistoryDTOResponse;
import com.example.backendspringboot.repository.OrderHistoryRepository;
import com.example.backendspringboot.repository.UserRepository;
import com.example.backendspringboot.service.OrderHistoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderHistoryServiceImpl implements OrderHistoryService {

    private final OrderHistoryRepository orderHistoryRepository;
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<?> getOrerHistoryByUserId(Integer userId) {
        List<OrderHistory> orderHistory = orderHistoryRepository.findAllByUserId(userId);
        List<OrderHistoryDTOResponse> orderHistoryDTOResponse = orderHistory.stream().map(order -> {
            return OrderHistoryDTOResponse.builder()
                    .userId(order.getUser().getId())
                    .phone(order.getPhone())
                    .address(order.getAddress())
                    .description(order.getDescription())
                    .build();
        }).toList();

        return new ResponseEntity<>(orderHistoryDTOResponse, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<?> addNewOrderHistory(OrderHistoryDTOResponse orderHistoryDTOResponse) {

        User user = userRepository.findById(orderHistoryDTOResponse.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        OrderHistory orderHistory = OrderHistory.builder()
                .user(user)
                .phone(orderHistoryDTOResponse.getPhone())
                .address(orderHistoryDTOResponse.getAddress())
                .description(orderHistoryDTOResponse.getDescription())
                .build();
        OrderHistory orderHistorySaved = orderHistoryRepository.save(orderHistory);
        return new ResponseEntity<>(OrderHistoryDTOResponse.builder().userId(orderHistorySaved.getUser().getId())
                .phone(orderHistorySaved.getPhone()).address(orderHistorySaved.getAddress())
                .description(orderHistorySaved.getDescription()).build(), HttpStatus.OK);
    }
    // @Override
    // public List<OrderHistoryDTOResponse> getOrerHistoryByUserId(Integer userId) {
    // List<OrderHistory> orderHistory =
    // orderHistoryRepository.findAllByUserId(userId);
    // List<OrderHistoryDTOResponse> orderHistoryDTOResponse =
    // orderHistory.stream().map(order -> {
    // return OrderHistoryDTOResponse.builder()
    // .userId(order.getUser().getId())
    // .phone(order.getPhone())
    // .address(order.getAddress())
    // .description(order.getDescription())
    // .build();
    // }).toList();

    // return orderHistoryDTOResponse;

    // }

    // @Override
    // public OrderHistoryDTOResponse addNewOrderHistory(OrderHistoryDTOResponse
    // orderHistoryDTOResponse) {

    // User user = userRepository.findById(orderHistoryDTOResponse.getUserId())
    // .orElseThrow(() -> new RuntimeException("User not found"));

    // OrderHistory orderHistory = OrderHistory.builder()
    // .user(user)
    // .phone(orderHistoryDTOResponse.getPhone())
    // .address(orderHistoryDTOResponse.getAddress())
    // .description(orderHistoryDTOResponse.getDescription())
    // .build();
    // OrderHistory orderHistorySaved = orderHistoryRepository.save(orderHistory);
    // return
    // OrderHistoryDTOResponse.builder().userId(orderHistorySaved.getUser().getId())
    // .phone(orderHistorySaved.getPhone()).address(orderHistorySaved.getAddress())
    // .description(orderHistorySaved.getDescription()).build();
    // }

}

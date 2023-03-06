package com.example.backendspringboot.model.history.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderHistoryDTOResponse {
    private String name;
    private String phone;
    private String address;
    private String description;
}

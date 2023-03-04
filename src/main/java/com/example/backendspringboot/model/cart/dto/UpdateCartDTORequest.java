package com.example.backendspringboot.model.cart.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateCartDTORequest {
    private int prodId;
    private int quantity;   
}

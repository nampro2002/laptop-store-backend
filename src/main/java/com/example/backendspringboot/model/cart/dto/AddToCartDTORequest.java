package com.example.backendspringboot.model.cart.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddToCartDTORequest {
    private int userId;
    private int prodId;
    private int quantity;   
}

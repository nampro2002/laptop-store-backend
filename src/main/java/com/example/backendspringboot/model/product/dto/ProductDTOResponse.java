package com.example.backendspringboot.model.product.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDTOResponse {
    private int id;
    private String name;
    private int price;
    private double rate;
    private String imageUrl;
    private int categoryId;
}

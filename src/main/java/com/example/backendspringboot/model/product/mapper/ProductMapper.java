package com.example.backendspringboot.model.product.mapper;

import java.util.List;

import com.example.backendspringboot.Entity.Product;
import com.example.backendspringboot.model.product.dto.ProductDTOResponse;

public class ProductMapper {
    public static List<ProductDTOResponse> toListProductDTOResponse(List<Product> products){
        List<ProductDTOResponse> productDTOResponses  = products.stream().map(product -> {
            return ProductDTOResponse.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .price(product.getPrice())
                    .rate(product.getRate())
                    .imageUrl(product.getImageUrl())
                    .categoryId(product.getCategory().getId())
                    .build();
        }).toList();
       return productDTOResponses;
    }
}

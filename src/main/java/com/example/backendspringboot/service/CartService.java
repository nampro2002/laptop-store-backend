package com.example.backendspringboot.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.backendspringboot.model.cart.dto.AddToCartDTORequest;
import com.example.backendspringboot.model.cart.dto.CartDTOResponse;
import com.example.backendspringboot.model.cart.dto.UpdateCartDTORequest;

public interface CartService {

    ResponseEntity<?> getAllCarts(Integer userId);

    ResponseEntity<?> updateToCart(Integer cartId, UpdateCartDTORequest updateCartDTORequest);

    ResponseEntity<?> addToCart(AddToCartDTORequest addToCartDTORequest);
    
    ResponseEntity<?> removeFromCart(Integer cartId);
    
    ResponseEntity<?> removeAllFromCart(Integer userId);
    
    // List<CartDTOResponse> getAllCarts(Integer userId);

    // CartDTOResponse updateToCart(Integer cartId, UpdateCartDTORequest updateCartDTORequest);

    // CartDTOResponse addToCart(AddToCartDTORequest addToCartDTORequest);

    
}

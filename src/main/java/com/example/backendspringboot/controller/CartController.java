package com.example.backendspringboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.backendspringboot.model.cart.dto.AddToCartDTORequest;
import com.example.backendspringboot.model.cart.dto.UpdateCartDTORequest;
import com.example.backendspringboot.service.CartService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CartController {
    private final CartService cartService;

    @GetMapping("/cart")
    public ResponseEntity<?> getAllCarts(@RequestParam(name = "userId", required = false) Integer userId) {
    return cartService.getAllCarts(userId);

    }
    @PostMapping("/cart")
    public ResponseEntity<?> addToCart(@RequestBody AddToCartDTORequest addToCartDTORequest) {
    return cartService.addToCart(addToCartDTORequest);

    }
    @PutMapping("/cart/{cartId}")
    public ResponseEntity<?> updateToCart(@PathVariable Integer cartId, @RequestBody UpdateCartDTORequest updateCartDTORequest) {
        return cartService.updateToCart(cartId, updateCartDTORequest);
        
    }
    @DeleteMapping("/cart")
    public ResponseEntity<?> removeFromCart(@RequestParam(name = "cartId", required = false) Integer cartId) {
        System.out.println(cartId);
        return cartService.removeFromCart(cartId);
        
    }
    @DeleteMapping("/cartAll")
    public ResponseEntity<?> removeAllFromCart(@RequestParam(name = "userId", required = false) Integer userId) {
        return cartService.removeAllFromCart(userId);
        
    }
    // @GetMapping("/cart")
    // public List<CartDTOResponse> getAllCarts(@RequestParam(name = "userId", required = false) Integer userId) {
    // return cartService.getAllCarts(userId);
    
    // }
    // @PostMapping("/cart")
    // public CartDTOResponse addToCart(@RequestBody AddToCartDTORequest addToCartDTORequest) {
    // return cartService.addToCart(addToCartDTORequest);
    
    // }
    // @PutMapping("/cart/{cartId}")
    // public CartDTOResponse updateToCart(@PathVariable Integer cartId, @RequestBody UpdateCartDTORequest updateCartDTORequest) {
    //     return cartService.updateToCart(cartId, updateCartDTORequest);
        
    // }
}

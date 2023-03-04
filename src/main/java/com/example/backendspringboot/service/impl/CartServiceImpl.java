package com.example.backendspringboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.backendspringboot.Entity.Cart;
import com.example.backendspringboot.Entity.Product;
import com.example.backendspringboot.Entity.User;
import com.example.backendspringboot.model.cart.dto.AddToCartDTORequest;
import com.example.backendspringboot.model.cart.dto.CartDTOResponse;
import com.example.backendspringboot.model.cart.dto.UpdateCartDTORequest;
import com.example.backendspringboot.repository.CartRepository;
import com.example.backendspringboot.repository.ProductRepository;
import com.example.backendspringboot.repository.UserRepository;
import com.example.backendspringboot.service.CartService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Override
    public ResponseEntity<?> getAllCarts(Integer userId) {
        List<Cart> carts = cartRepository.findByUserId(userId);
        List<CartDTOResponse> cartDTOResponses = carts.stream().map(cart -> {
            return CartDTOResponse.builder()
                    .id(cart.getId())
                    .userId(cart.getUser().getId())
                    .prodId(cart.getProduct().getId())
                    .quantity(cart.getQuantity())
                    .build();
        }).toList();

        return new ResponseEntity<>(cartDTOResponses, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateToCart(Integer cartId, UpdateCartDTORequest updateCartDTORequest) {
        Optional<Cart> cart = cartRepository.findById(cartId);
        if (cart.isEmpty()) {
            return null;
        }
        cart.get().setQuantity(updateCartDTORequest.getQuantity());
        Cart updatedCart = cartRepository.save(cart.get());
        return new ResponseEntity<>(
                CartDTOResponse.builder().id(updatedCart.getId()).userId(updatedCart.getUser().getId())
                        .prodId(updatedCart.getProduct().getId())
                        .quantity(updatedCart.getQuantity()).build(),
                HttpStatus.OK);
        // else {
        // return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
        // }

    }

    @Override
    public ResponseEntity<?> addToCart(AddToCartDTORequest addToCartDTORequest) {
        // TODO Auto-generated method stub
        User user = userRepository.findById(addToCartDTORequest.getUserId()).get();
        Product product = productRepository.findById(addToCartDTORequest.getProdId()).get();
        Cart cart = new Cart();
        cart.setQuantity(addToCartDTORequest.getQuantity());
        cart.setUser(user);
        cart.setProduct(product);
        Cart savedCart = cartRepository.save(cart);
        return new ResponseEntity<>(CartDTOResponse.builder().id(savedCart.getId()).userId(savedCart.getUser().getId())
                .prodId(savedCart.getProduct().getId())
                .quantity(savedCart.getQuantity()).build(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> removeFromCart(Integer cartId) {
        // TODO Auto-generated method stub
        cartRepository.deleteById(cartId);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> removeAllFromCart(Integer userId) {
        // TODO Auto-generated method stub
        List<Cart> carts = cartRepository.findByUserId(userId);
        carts.forEach(cart -> {
            cartRepository.deleteById(cart.getId());
        });
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }

    // @Override
    // public List<CartDTOResponse> getAllCarts(Integer userId) {
    // List<Cart> carts = cartRepository.findByUserId(userId);
    // List<CartDTOResponse> cartDTOResponses = carts.stream().map(cart -> {
    // return CartDTOResponse.builder()
    // .id(cart.getId())
    // .userId(cart.getUser().getId())
    // .prodId(cart.getProduct().getId())
    // .quantity(cart.getQuantity())
    // .build();
    // }).toList();

    // return cartDTOResponses;
    // }

    // @Override
    // public CartDTOResponse updateToCart(Integer cartId, UpdateCartDTORequest
    // updateCartDTORequest) {
    // Optional<Cart> cart = cartRepository.findById(cartId);
    // if (cart.isEmpty()) {
    // return null;
    // }
    // cart.get().setQuantity(updateCartDTORequest.getQuantity());
    // Cart updatedCart = cartRepository.save(cart.get());
    // return
    // CartDTOResponse.builder().id(updatedCart.getId()).userId(updatedCart.getUser().getId())
    // .prodId(updatedCart.getProduct().getId())
    // .quantity(updatedCart.getQuantity()).build();
    // // else {
    // // return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
    // // }

    // }

    // @Override
    // public CartDTOResponse addToCart(AddToCartDTORequest addToCartDTORequest) {
    // // TODO Auto-generated method stub
    // User user = userRepository.findById(addToCartDTORequest.getUserId()).get();
    // Product product =
    // productRepository.findById(addToCartDTORequest.getProdId()).get();
    // Cart cart = new Cart();
    // cart.setQuantity(addToCartDTORequest.getQuantity());
    // cart.setUser(user);
    // cart.setProduct(product);
    // Cart savedCart = cartRepository.save(cart);
    // return
    // CartDTOResponse.builder().id(savedCart.getId()).userId(savedCart.getUser().getId())
    // .prodId(savedCart.getProduct().getId())
    // .quantity(savedCart.getQuantity()).build();
    // }

}

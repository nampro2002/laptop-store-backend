package com.example.backendspringboot.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.backendspringboot.Entity.User;
import com.example.backendspringboot.model.user.dto.LoginDTORequest;
import com.example.backendspringboot.model.user.dto.LoginDTOResponse;
import com.example.backendspringboot.model.user.dto.RegisterDTORequest;
import com.example.backendspringboot.model.user.dto.RegisterDTOResponse;
import com.example.backendspringboot.model.user.dto.UpdateInfoDTORequest;
import com.example.backendspringboot.model.user.dto.UpdatePasswordDTORequest;
import com.example.backendspringboot.service.MyUserDetailsService;
import com.example.backendspringboot.service.UserService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final MyUserDetailsService userDetailsService;

    @PostMapping("/login")
    public LoginDTOResponse login(@RequestBody LoginDTORequest loginDTORequest) {
        System.out.println("login");
        return userDetailsService.login(loginDTORequest.getUsername(), loginDTORequest.getPassword());
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDTORequest registerDTO) {
        System.out.println("register");
        return userService.register(registerDTO);
    }
    @PutMapping("/user/{id}")
    public ResponseEntity<?> updateInfo(@PathVariable Integer id, @RequestBody UpdateInfoDTORequest updateInfoDTORequest) {

        return userService.updateInfo(id, updateInfoDTORequest);
    }
    @PatchMapping("/user/{id}")
    public ResponseEntity<?> updatePassword(@PathVariable Integer id, @RequestBody UpdatePasswordDTORequest updatePasswordDTORequest) {

        return userService.updatePassword(id, updatePasswordDTORequest);
    }

}

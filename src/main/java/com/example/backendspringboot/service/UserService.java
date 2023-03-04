package com.example.backendspringboot.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.backendspringboot.Entity.User;
import com.example.backendspringboot.model.user.dto.LoginDTOResponse;
import com.example.backendspringboot.model.user.dto.RegisterDTORequest;
import com.example.backendspringboot.model.user.dto.RegisterDTOResponse;
import com.example.backendspringboot.model.user.dto.UpdateInfoDTORequest;
import com.example.backendspringboot.model.user.dto.UpdatePasswordDTORequest;

public interface UserService {

    ResponseEntity<?> register(RegisterDTORequest registerDTO);

    ResponseEntity<?> updateInfo(Integer id, UpdateInfoDTORequest updateInfoDTORequest);

    ResponseEntity<?> updatePassword(Integer id, UpdatePasswordDTORequest updatePasswordDTORequest);

    

    

    // List<User>  getAllUser();
    
}

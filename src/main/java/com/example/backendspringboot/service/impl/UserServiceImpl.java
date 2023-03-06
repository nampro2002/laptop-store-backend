package com.example.backendspringboot.service.impl;

import java.util.Collections;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.backendspringboot.Entity.Role;
import com.example.backendspringboot.Entity.User;
import com.example.backendspringboot.model.user.dto.RegisterDTORequest;
import com.example.backendspringboot.model.user.dto.RegisterDTOResponse;
import com.example.backendspringboot.model.user.dto.UpdateInfoDTORequest;
import com.example.backendspringboot.model.user.dto.UpdatePasswordDTORequest;
import com.example.backendspringboot.repository.RoleRepository;
import com.example.backendspringboot.repository.UserRepository;
import com.example.backendspringboot.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<?> register(RegisterDTORequest registerDTO) {
        // TODO Auto-generated method stub
        System.out.println(registerDTO);
        if (userRepository.existsByUsername(registerDTO.getUsername())) {
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }
        if (userRepository.existsByPhone(registerDTO.getPhone())) {
            return new ResponseEntity<>("Phone is already taken!", HttpStatus.BAD_REQUEST);
        }
        User user = new User();
        user.setUsername(registerDTO.getUsername());
        user.setPhone(registerDTO.getPhone());
        user.setName(registerDTO.getName());
        // user.setPassword(registerDTO.getPassword());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        Role roles = roleRepository.findByName("ROLE_USER").get();
        user.setRoles(Collections.singletonList(roles));
        userRepository.save(user);
        return new ResponseEntity<>(RegisterDTOResponse.builder().username(registerDTO.getUsername())
                .phone(registerDTO.getPhone()).name(registerDTO.getName())
                .roles(Collections.singletonList(roles.getName())).build(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateInfo(Integer id, UpdateInfoDTORequest updateInfoDTORequest) {
        // TODO Auto-generated method stub
        Optional<User> userCheck = userRepository.findByPhone(updateInfoDTORequest.getPhone());
        if(userCheck.isPresent() && userCheck.get().getId() != id) {
            return new ResponseEntity<>("Phone is already taken!", HttpStatus.BAD_REQUEST);
        }

        User user = userRepository.findById(id).get();
        user.setName(updateInfoDTORequest.getName().equals("") ? user.getName() : updateInfoDTORequest.getName());
        user.setPhone(updateInfoDTORequest.getPhone().equals("") ? user.getPhone() : updateInfoDTORequest.getPhone());
        user.setImgUrl(
                updateInfoDTORequest.getImgUrl().equals("") ? user.getImgUrl() : updateInfoDTORequest.getImgUrl());
        user.setAddress(
                updateInfoDTORequest.getAddress().equals("") ? user.getAddress() : updateInfoDTORequest.getAddress());
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updatePassword(Integer id, UpdatePasswordDTORequest updatePasswordDTORequest) {
        // TODO Auto-generated method stub       
        System.out.println("user");
        User user = userRepository.findById(id).get();
        if(!passwordEncoder.matches(updatePasswordDTORequest.getOldPassword(), user.getPassword())) {
            return new ResponseEntity<>("Old password is incorrect!", HttpStatus.BAD_REQUEST);
        }
        user.setPassword(passwordEncoder.encode(updatePasswordDTORequest.getNewPassword()));
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // @Override
    // public List<User> getAllUser() {
    // // TODO Auto-generated method stub
    // return userRepository.findAll();
    // }

}

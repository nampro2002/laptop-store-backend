package com.example.backendspringboot.model.user.dto;
import java.util.List;

import com.example.backendspringboot.Entity.Role;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterDTOResponse {
    private String name;
    private String phone;
    private String username;          
    private List<String> roles;          
}

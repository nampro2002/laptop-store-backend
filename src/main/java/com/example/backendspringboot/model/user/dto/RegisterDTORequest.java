package com.example.backendspringboot.model.user.dto;
import lombok.Data;

@Data
public class RegisterDTORequest {
    private String name;
    private String phone;
    private String username;
    private String password;     
 
}

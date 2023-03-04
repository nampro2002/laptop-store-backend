package com.example.backendspringboot.model.user.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginDTORequest {
    private String username;
    private String password;
}

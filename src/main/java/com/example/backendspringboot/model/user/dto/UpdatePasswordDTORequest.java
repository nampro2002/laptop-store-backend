package com.example.backendspringboot.model.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePasswordDTORequest {
    private String oldPassword;
    private String newPassword;
}

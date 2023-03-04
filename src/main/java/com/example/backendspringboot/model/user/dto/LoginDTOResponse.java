package com.example.backendspringboot.model.user.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginDTOResponse {
    private String accessToken;
    private UserInfoDTOResponse userInfo;
}

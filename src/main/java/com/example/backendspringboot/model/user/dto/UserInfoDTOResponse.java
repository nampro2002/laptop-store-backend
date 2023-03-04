package com.example.backendspringboot.model.user.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserInfoDTOResponse {
    
    private Integer id;
    private String name;
    private String phone;
    private String username;
    private String imgUrl;
    private String address;
}

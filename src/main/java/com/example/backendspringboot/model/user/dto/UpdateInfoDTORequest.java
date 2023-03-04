package com.example.backendspringboot.model.user.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateInfoDTORequest {
    private String name;
    private String phone;
    private String imgUrl;
    private String address;
}

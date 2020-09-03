package com.oauth2.server.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthorizationDto {

    private String userId;
    private String redirectUri;
    private String responseType;
}

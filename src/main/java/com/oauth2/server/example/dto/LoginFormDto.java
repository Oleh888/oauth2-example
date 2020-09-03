package com.oauth2.server.example.dto;

import lombok.Data;

@Data
public class LoginFormDto {

    private String password;
    private String redirectUri;
    private String userId;
}

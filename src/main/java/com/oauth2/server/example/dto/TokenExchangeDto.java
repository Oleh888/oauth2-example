package com.oauth2.server.example.dto;

import lombok.Data;

@Data
public class TokenExchangeDto {

    private String userId;
    private String client_secret;
    private String response_type;
    private String grant_type;
    private String code;
    private String refresh_token;
}

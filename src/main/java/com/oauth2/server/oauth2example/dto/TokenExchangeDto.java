package com.oauth2.server.oauth2example.dto;

import lombok.Data;

@Data
public class TokenExchangeDto {

    private String client_id;
    private String client_secret;
    private String response_type;
    private String grant_type;
    private String code;
    private String refresh_token;
}

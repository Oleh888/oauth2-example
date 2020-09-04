package com.oauth2.server.example.model;

import lombok.Data;

@Data
public class User {
    private String id;
    private String name;
    private String secretHash;
    private String redirectUri;
    private String testRedirectUri;
    private String cipherKey;
    private Long tokenExpirationTime;
    private String details;
}

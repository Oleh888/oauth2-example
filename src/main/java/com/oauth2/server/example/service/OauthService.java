package com.oauth2.server.example.service;

import com.oauth2.server.example.dto.AuthorizationDto;

import java.util.Map;

public interface OauthService {
    Map<String, Object> generateResponseContainingRefreshAndAccessTokens(String code, String client_id);

    Map<String, Object> generateResponseContainingAccessToken(String refresh_token, String client_id);

    void verify(AuthorizationDto authorizationDto);

    void verifyUser(String userId);
}

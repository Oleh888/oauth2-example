package com.oauth2.server.example.service.impl;

import com.oauth2.server.example.dto.AuthorizationDto;
import com.oauth2.server.example.exception.AuthorizationException;
import com.oauth2.server.example.model.User;
import com.oauth2.server.example.service.OauthService;
import com.oauth2.server.example.service.UserService;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class OauthServiceImpl implements OauthService {
    private static final String CODE = "code";
    private final UserService userService;

    public OauthServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Map<String, Object> generateResponseContainingRefreshAndAccessTokens(String code, String client_id) {
        Map<String, Object> tokensResponse = new HashMap<>();
        tokensResponse.put("access_token", "this is access_token");
        tokensResponse.put("refresh_token", "this is refresh_token");
        tokensResponse.put("token_type", "bearer");
        tokensResponse.put("expires_in", 3600);
        return tokensResponse;
    }

    @Override
    public Map<String, Object> generateResponseContainingAccessToken(String refresh_token, String client_id) {
        Map<String, Object> tokenResponse = new HashMap<>();
        tokenResponse.put("access_token", "this is access_token");
        tokenResponse.put("token_type", "bearer");
        tokenResponse.put("expires_in", 3600);
        return tokenResponse;
    }

    @Override
    public void verify(AuthorizationDto authorizationDto) {
        if (authorizationDto.getUserId() == null || authorizationDto.getRedirectUri() == null) {
            throw new AuthorizationException("Invalid request");
        }

        User byUserId = userService.getById(Long.valueOf(authorizationDto.getUserId()));

        if (!(authorizationDto.getRedirectUri().equals(byUserId.getRedirectUri())
                || authorizationDto.getRedirectUri().equals(byUserId.getTestRedirectUri()))) {
            throw new AuthorizationException("Invalid user");
        }
        if (!authorizationDto.getResponseType().equals(CODE)) {
            throw new AuthorizationException("Invalid request");
        }
    }

    @Override
    public void verifyUser(String userId) {
        if (userId == null || userService.getById(Long.valueOf(userId)) == null) {
            throw new AuthorizationException("Invalid request");
        }
    }
}

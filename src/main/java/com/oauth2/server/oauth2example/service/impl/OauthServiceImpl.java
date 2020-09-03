package com.oauth2.server.oauth2example.service.impl;

import com.oauth2.server.oauth2example.service.OauthService;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class OauthServiceImpl implements OauthService {
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
}

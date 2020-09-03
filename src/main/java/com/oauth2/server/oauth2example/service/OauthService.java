package com.oauth2.server.oauth2example.service;

import java.util.Map;

public interface OauthService {
    Map<String, Object> generateResponseContainingRefreshAndAccessTokens(String code, String client_id);

    Map<String, Object> generateResponseContainingAccessToken(String refresh_token, String client_id);
}

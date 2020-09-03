package com.oauth2.server.oauth2example.controller;

import com.oauth2.server.oauth2example.dto.TokenExchangeDto;
import com.oauth2.server.oauth2example.service.OauthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class TokenExchangeController {
    private final OauthService oauthService;

    public TokenExchangeController(OauthService oauthService) {
        this.oauthService = oauthService;
    }

    @PostMapping("/token")
    public ResponseEntity<Map<String, Object>> token(@RequestBody TokenExchangeDto tokenExchangeDto) {
        if (tokenExchangeDto.getGrant_type().equalsIgnoreCase("authorization_code")) {
            Map<String, Object> tokens = oauthService.generateResponseContainingRefreshAndAccessTokens(
                    tokenExchangeDto.getCode(),
                    tokenExchangeDto.getClient_id());
            return ResponseEntity.ok(tokens);
        } else if (tokenExchangeDto.getGrant_type().equalsIgnoreCase("refresh_token")) {
            Map<String, Object> token = oauthService.generateResponseContainingAccessToken(
                    tokenExchangeDto.getRefresh_token(), tokenExchangeDto.getClient_id());
            return ResponseEntity.ok(token);
        } else {
            throw new RuntimeException("Where is unsupported grant type");
        }
    }
}

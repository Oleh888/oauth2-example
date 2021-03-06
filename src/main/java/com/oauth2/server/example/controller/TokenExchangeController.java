package com.oauth2.server.example.controller;

import com.oauth2.server.example.dto.TokenExchangeDto;
import com.oauth2.server.example.exception.AuthorizationException;
import com.oauth2.server.example.service.OauthService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class TokenExchangeController {
    private final OauthService oauthService;

    public TokenExchangeController(OauthService oauthService) {
        this.oauthService = oauthService;
    }

    @PostMapping(value = "/token", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> token(TokenExchangeDto tokenExchangeDto) {
        if (tokenExchangeDto.getGrant_type().equalsIgnoreCase("authorization_code")) {
            Map<String, Object> tokens = oauthService.generateResponseContainingRefreshAndAccessTokens(
                    tokenExchangeDto.getCode(),
                    tokenExchangeDto.getUserId());
            return ResponseEntity.ok(tokens);
        } else if (tokenExchangeDto.getGrant_type().equalsIgnoreCase("refresh_token")) {
            Map<String, Object> token = oauthService.generateResponseContainingAccessToken(
                    tokenExchangeDto.getRefresh_token(), tokenExchangeDto.getUserId());
            return ResponseEntity.ok(token);
        } else {
            throw new AuthorizationException("There is unsupported grant type");
        }
    }

    @GetMapping("/test-token")
    @ResponseBody
    public String testToken(@RequestHeader(value = "access_token") String accessToken) {
        if (!accessToken.equals("this is access_token")) {
            throw new AuthorizationException("Access token " + accessToken + " is not valid!");
        }
        return "You have been authorized with token!";
    }
}

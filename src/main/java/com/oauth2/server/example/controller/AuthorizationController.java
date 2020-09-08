package com.oauth2.server.example.controller;

import com.oauth2.server.example.dto.AuthorizationDto;
import com.oauth2.server.example.dto.LoginFormDto;
import com.oauth2.server.example.service.OauthService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class AuthorizationController {
    private final OauthService oauthService;

    public AuthorizationController(OauthService oauthService) {
        this.oauthService = oauthService;
    }

    @GetMapping("/authorize")
    public String authorizeGet(String userId, String redirectUri, String responseType) {
        AuthorizationDto authorizationDto = new AuthorizationDto(userId, redirectUri, responseType);
        oauthService.verify(authorizationDto);
        return "login";
    }

    @PostMapping(value = {"/authorize"}, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void authorizePost(LoginFormDto loginFormDto, HttpServletResponse response) throws IOException {
        oauthService.verifyUser(loginFormDto.getUserId());
        if (loginFormDto.getRedirectUri() != null) {
            response.sendRedirect(loginFormDto.getRedirectUri() + "?code=authorization_code");
        }
    }
}

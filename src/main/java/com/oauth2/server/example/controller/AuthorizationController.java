package com.oauth2.server.example.controller;

import com.oauth2.server.example.dto.AuthorizationDto;
import com.oauth2.server.example.dto.LoginFormDto;
import com.oauth2.server.example.exception.ExceptionInfo;
import com.oauth2.server.example.service.OauthService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthorizationController {
    private final OauthService oauthService;

    public AuthorizationController(OauthService oauthService) {
        this.oauthService = oauthService;
    }

    @GetMapping("/authorize")
    public String authorizeGet(@RequestParam String userId,
                            @RequestParam String redirectUri,
                            @RequestParam String responseType) {
        AuthorizationDto authorizationDto = new AuthorizationDto(userId, redirectUri, responseType);
        oauthService.verify(authorizationDto);
        return "login";
    }

    @PostMapping("/authorize")
    public String authorizePost(@ModelAttribute(name = "loginFormDto") LoginFormDto loginFormDto, BindingResult bindingResult) {
        oauthService.verifyUser(loginFormDto.getUserId());
        if (bindingResult.hasErrors()) {
            ExceptionInfo errorInfo = new ExceptionInfo();
            errorInfo.setErrorMsg("Please fill all fields");
            return "login";
        }
        return "index";
    }
}

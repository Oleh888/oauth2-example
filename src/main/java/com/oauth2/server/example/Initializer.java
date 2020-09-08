package com.oauth2.server.example;

import com.oauth2.server.example.model.User;
import com.oauth2.server.example.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Initializer implements CommandLineRunner {
    private final static Long TOKEN_EXPIRATION_TIME = 3600L;
    private final static String REDIRECT_URL = "https://oauth2-example.herokuapp.com/";
    private final UserService userService;

    public Initializer(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        User anton = new User();
        anton.setName("Anton");
        anton.setRedirectUri(REDIRECT_URL);
        anton.setTokenExpirationTime(TOKEN_EXPIRATION_TIME);
        userService.create(anton);

        User max = new User();
        max.setName("Max");
        max.setRedirectUri(REDIRECT_URL);
        anton.setTokenExpirationTime(TOKEN_EXPIRATION_TIME);
        userService.create(max);
    }
}

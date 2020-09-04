package com.oauth2.server.example.service;

import com.oauth2.server.example.model.User;

public interface UserService {
    User getById(Long id);

    User create(User user);
}

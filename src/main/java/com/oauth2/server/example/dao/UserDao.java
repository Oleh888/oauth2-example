package com.oauth2.server.example.dao;

import com.oauth2.server.example.model.User;

public interface UserDao {
    User getByUserName(String name);

    User create(User user);

    User getByUserId(Long id);
}

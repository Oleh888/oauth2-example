package com.oauth2.server.example.service.impl;

import com.oauth2.server.example.dao.UserDao;
import com.oauth2.server.example.model.User;
import com.oauth2.server.example.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getById(Long id) {
        return userDao.getByUserId(id);
    }

    @Override
    public User create(User user) {
        return userDao.create(user);
    }
}

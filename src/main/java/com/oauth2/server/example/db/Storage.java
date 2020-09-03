package com.oauth2.server.example.db;

import com.oauth2.server.example.exception.UserNotFoundException;
import com.oauth2.server.example.model.User;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static final List<User> users = new ArrayList<>();
    private static long id = 0L;

    public static User add(User user) {
        user.setId(String.valueOf(id++));
        users.add(user);
        return user;
    }

    public static User getByName(String name) {
        return users.stream()
                .filter(user -> user.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("Can not find user with name " + name));
    }

    public static User getById(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(String.valueOf(id)))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("Can not find user with id " + id));
    }
}

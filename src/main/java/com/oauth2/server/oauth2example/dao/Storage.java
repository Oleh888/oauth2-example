package com.oauth2.server.oauth2example.dao;

import com.oauth2.server.oauth2example.model.User;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    public static final List<User> users = new ArrayList<>();
    private static Long userId = 0L;

    public static void addUser(User user) {
        user.setId(userId++);
        users.add(user);
    }
}

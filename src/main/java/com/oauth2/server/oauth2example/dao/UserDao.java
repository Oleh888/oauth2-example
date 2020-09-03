package com.oauth2.server.oauth2example.dao;

import com.oauth2.server.oauth2example.model.User;
import java.util.List;
import java.util.Optional;

public interface UserDao {

    User create(User user);

    Optional<User> get(Long id);

    List<User> getAll();

    User update(User user);

    boolean delete(Long id);

    Optional<User> findByName(String name);
}

package com.oauth2.server.oauth2example.dao.impl;

import com.oauth2.server.oauth2example.dao.Storage;
import com.oauth2.server.oauth2example.dao.UserDao;
import com.oauth2.server.oauth2example.model.User;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public User create(User user) {
        Storage.addUser(user);
        return user;
    }

    @Override
    public Optional<User> get(Long id) {
        return Storage.users
                .stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<User> getAll() {
        return Storage.users;
    }

    @Override
    public User update(User user) {
        IntStream.range(0, Storage.users.size())
                .filter(userId -> user.getId().equals(Storage.users.get(userId).getId()))
                .forEach(userId -> Storage.users.set(userId, user));
        return user;
    }

    @Override
    public boolean delete(Long id) {
        return Storage.users.removeIf(user -> user.getId().equals(id));
    }

    @Override
    public Optional<User> findByName(String name) {
        return Storage.users.stream()
                .filter(user -> user.getName().equals(name))
                .findFirst();
    }
}

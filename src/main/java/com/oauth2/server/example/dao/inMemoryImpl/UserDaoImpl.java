package com.oauth2.server.example.dao.inMemoryImpl;

import com.oauth2.server.example.dao.UserDao;
import com.oauth2.server.example.db.Storage;
import com.oauth2.server.example.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public User getByUserName(String name) {
        return Storage.getByName(name);
    }

    @Override
    public User create(User user) {
        return Storage.add(user);
    }

    @Override
    public User getByUserId(Long id) {
        return Storage.getById(id);
    }
}

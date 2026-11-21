package com.joysistvi.recordingstudio.repository;

import com.joysistvi.recordingstudio.model.User;
import java.util.List;

public interface UserRepository {

    List<User> findAll();

    void save(User user);

    void update(User user);

    void deleteById(int id);

    User findByUserName(String userName);
}
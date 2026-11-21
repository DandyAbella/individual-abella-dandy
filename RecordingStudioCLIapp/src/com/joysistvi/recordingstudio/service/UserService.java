package com.joysistvi.recordingstudio.service;

import com.joysistvi.recordingstudio.model.User;
import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void createUser(
            String fullName,
            String userName,
            String userPassword
    );

    void updateUser(
            int id,
            String fullName,
            String userName,
            String userPassword
    );

    void deleteUser(int id);

    User findUserByUserName(String userName);
}
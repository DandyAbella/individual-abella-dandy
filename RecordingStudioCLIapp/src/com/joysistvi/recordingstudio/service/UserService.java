package com.joysistvi.recordingstudio.service;

import com.joysistvi.recordingstudio.model.User;
import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void createUser(
            String fullName,
            String userName,
            String userPassword,
            String role
    );

    void updateUser(
            int id,
            String fullName,
            String userName,
            String userPassword,
            String role
    );

    void deleteUser(int id);

    User findUserByUserName(String userName);

    boolean login(String userName, String password);
}
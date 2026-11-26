package com.prestigegym.service;

import com.prestigegym.model.User;
import java.util.List;

public interface UserService {

    User login(String username, String password);

    void saveUser(User user);

    List<User> getAllUsers();

    User findById(int id);

    void updateUser(User user);

    void archiveUser(int id);

    List<User> getArchivedUsers();

    void restoreUser(int id);

}
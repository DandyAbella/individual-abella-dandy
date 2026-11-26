package com.prestigegym.repository;

import com.prestigegym.model.User;
import java.util.List;

public interface UserRepository {

    List<User> findAll();

    User findById(int id);

    User login(String username, String password);

    void save(User user);

    void update(User user);

    void delete(int id);

    void archive(int id);

    List<User> findArchivedUsers();

    void restore(int id);


}

package com.prestigegym.service;

import com.prestigegym.model.User;
import com.prestigegym.repository.UserRepository;
import com.prestigegym.repository.UserRepositoryImpl;
import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository =
            new UserRepositoryImpl();

    @Override
    public User login(String username, String password) {
        return userRepository.login(username, password);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}

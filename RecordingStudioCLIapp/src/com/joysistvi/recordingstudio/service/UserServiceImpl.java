package com.joysistvi.recordingstudio.service;

import com.joysistvi.recordingstudio.model.User;
import com.joysistvi.recordingstudio.repository.UserRepository;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public void createUser(
            String fullName,
            String userName,
            String userPassword
    ) {

        if (fullName == null || fullName.trim().isEmpty()) {
            System.out.println("Validation Error");
            return;
        }

        User user = new User();

        user.setFullName(fullName);
        user.setUserName(userName);
        user.setUserPassword(userPassword);

        repository.save(user);
    }

    @Override
    public void updateUser(
            int id,
            String fullName,
            String userName,
            String userPassword
    ) {

        User user = new User();

        user.setId(id);
        user.setFullName(fullName);
        user.setUserName(userName);
        user.setUserPassword(userPassword);

        repository.update(user);
    }

    @Override
    public void deleteUser(int id) {
        repository.deleteById(id);
    }

    @Override
    public User findUserByUserName(String userName) {
        return repository.findByUserName(userName);
    }
}
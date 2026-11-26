package com.prestigegym.service;

import com.prestigegym.model.User;
import com.prestigegym.repository.UserRepository;
import com.prestigegym.repository.UserRepositoryImpl;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository =
            new UserRepositoryImpl();

    @Override
    public User login(String username, String password) {

        User user = userRepository.login(username, password);

        if (user == null) {
            return null;
        }

        if (BCrypt.checkpw(password, user.getPassword())) {
            return user;
        }

        return null;
    }

    @Override
    public void saveUser(User user) {
        String hashedPassword =
                BCrypt.hashpw(
                        user.getPassword(),
                        BCrypt.gensalt());

        user.setPassword(hashedPassword);

        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void updateUser(User user) {
        userRepository.update(user);
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public void archiveUser(int id) {
        userRepository.archive(id);
    }

    @Override
    public List<User> getArchivedUsers() {
        return userRepository.findArchivedUsers();
    }

    @Override
    public void restoreUser(int id) {
        userRepository.restore(id);
    }

}

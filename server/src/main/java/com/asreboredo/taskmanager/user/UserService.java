package com.asreboredo.taskmanager.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserService
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        this.userRepository.findAll().forEach(users::add);
        return users;
    }

    public Optional<User> getUser(Long id) {
        return this.userRepository.findById(id);
    }

    public void addUser(User user) {
        this.userRepository.save(user);
    }

    public void updateUser(User user, Long id) {
        // Simple check for user id in request body. This prevents reaching the Database
        // in that case
        if (user.getId().equals(id))
            this.userRepository.save(user);
    }

    public void deleteUser(User user) {
        this.userRepository.delete(user);
    }
}
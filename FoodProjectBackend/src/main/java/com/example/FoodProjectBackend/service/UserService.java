package com.example.FoodProjectBackend.service;


import com.example.FoodProjectBackend.entity.User;
import com.example.FoodProjectBackend.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public Optional<User> getUserById(int id) {
        return userRepo.findById(id);
    }

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public Optional<User> updateUser(int id, User userDetails) {
        return userRepo.findById(id).map(user -> {
            user.setUsername(userDetails.getUsername());
            user.setPassword(userDetails.getPassword());
            user.setEmail(userDetails.getEmail());
            return userRepo.save(user);
        });
    }

    public boolean deleteUser(int id) {
        if (userRepo.existsById(id)) {
        	userRepo.deleteById(id);
            return true;
        }
        return false;
    }
}

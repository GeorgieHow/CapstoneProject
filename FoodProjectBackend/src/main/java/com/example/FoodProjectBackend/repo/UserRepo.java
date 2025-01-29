package com.example.FoodProjectBackend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FoodProjectBackend.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}

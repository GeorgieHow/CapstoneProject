package com.example.FoodProjectBackend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FoodProjectBackend.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Integer>{

}

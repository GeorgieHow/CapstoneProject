package com.example.FoodProjectBackend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FoodProjectBackend.entity.Restaurant;

public interface RestaurantRepo extends JpaRepository<Restaurant, Integer>{
	
}

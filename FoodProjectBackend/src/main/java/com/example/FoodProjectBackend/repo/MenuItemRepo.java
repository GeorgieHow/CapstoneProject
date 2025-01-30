package com.example.FoodProjectBackend.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FoodProjectBackend.entity.MenuItem;
import com.example.FoodProjectBackend.entity.Restaurant;

public interface MenuItemRepo extends JpaRepository<MenuItem, Integer>{

	List<MenuItem> findByRestaurant(Restaurant restaurant);

}

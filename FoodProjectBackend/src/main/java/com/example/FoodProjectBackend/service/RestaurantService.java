package com.example.FoodProjectBackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.FoodProjectBackend.entity.Restaurant;
import com.example.FoodProjectBackend.repo.RestaurantRepo;

@Service
public class RestaurantService {

	private final RestaurantRepo restaurantRepo;
	
	public RestaurantService(RestaurantRepo restaurantRepo) {
		this.restaurantRepo = restaurantRepo;
	}
	
	public List<Restaurant> getAllRestaurants() {
		return restaurantRepo.findAll();
	}
	
    public Optional<Restaurant> getRestaurantById(int id) {
        return restaurantRepo.findById(id);
    }

    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepo.save(restaurant);
    }
    
    public Optional<Restaurant> updateRestaurant(int id, Restaurant restaurantDetails) {
        return restaurantRepo.findById(id).map(restaurant -> {
            restaurant.setName(restaurantDetails.getName());
            restaurant.setLocation(restaurantDetails.getLocation());
            restaurant.setRating(restaurantDetails.getRating());
            
            if (restaurantDetails.getMenu() != null && !restaurantDetails.getMenu().isEmpty()) {
            	restaurant.setMenu(restaurantDetails.getMenu());
            }
            return restaurantRepo.save(restaurant); 
        });
    }

    public boolean deleteRestaurant(int id) {
        if (restaurantRepo.existsById(id)) {
        	restaurantRepo.deleteById(id);
            return true;
        }
        return false;
    }
}

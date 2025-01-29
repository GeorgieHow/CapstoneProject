package com.example.FoodProjectBackend.entity;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "restaurants")
public class Restaurant {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private Double rating;

    @ElementCollection
    @CollectionTable(name = "restaurant_menu", joinColumns = @JoinColumn(name = "restaurant_id"))
    @Column(name = "menu_item") 
    private List<String> menu;
    
    public Restaurant() {
    	
    }
    
	public Restaurant(Long id, String name, String location, Double rating, List<String> menu) {
		this.id = id;
		this.name = name;
		this.location = location;
		this.rating = rating;
		this.menu = menu;
	}

	public Restaurant(String name, String location, Double rating, List<String> menu, List<Order> orders) {
		this.name = name;
		this.location = location;
		this.rating = rating;
		this.menu = menu;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public List<String> getMenu() {
		return menu;
	}

	public void setMenu(List<String> menu) {
		this.menu = menu;
	}

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", location=" + location + ", rating=" + rating + ", menu="
				+ menu + "]";
	}
}

import { Component, OnInit } from '@angular/core';
import { Restaurant } from '../model/restaurant';
import { RestaurantService } from '../service/restaurant.service';

@Component({
  selector: 'app-restaurant-list',
  standalone: false,
  
  templateUrl: './restaurant-list.component.html',
  styleUrl: './restaurant-list.component.css'
})
export class RestaurantListComponent {
  restaurants: Restaurant[] = [];

  constructor(private restaurantService: RestaurantService) { }

  ngOnInit(): void {
    this.restaurantService.getAllRestaurants().subscribe(
      (restaurants) => {
        console.log('Fetched restaurants:', restaurants); 
        this.restaurants = restaurants;
      },
      (error) => {
        console.error('Error fetching restaurants:', error); 
      }
    );
  }
}

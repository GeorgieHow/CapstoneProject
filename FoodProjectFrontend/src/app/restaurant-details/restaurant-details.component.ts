import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';  
import { RestaurantService } from '../service/restaurant.service';
import { MenuDetailsService } from '../service/menu-details.service';
import { Restaurant } from '../model/restaurant';
import { MenuItem } from '../model/menu-item';

@Component({
  selector: 'app-restaurant-details',
  standalone: false,
  templateUrl: './restaurant-details.component.html',
  styleUrls: ['./restaurant-details.component.css']
})
export class RestaurantDetailsComponent implements OnInit {
  restaurantId: string | null = null;
  restaurant: Restaurant | null = null;
  menuItems: MenuItem[] = [];

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private restaurantService: RestaurantService,
    private menuDetailsService: MenuDetailsService
  ) {}

  ngOnInit(): void {
    this.restaurantId = this.route.snapshot.paramMap.get('id');
    
    if (this.restaurantId) {
      this.restaurantService.getRestaurantById(Number(this.restaurantId)).subscribe((data) => {
        this.restaurant = data;
      });

      this.menuDetailsService.getMenuItemsByRestaurantId(Number(this.restaurantId)).subscribe((data) => {
        this.menuItems = data;
      });
    }
  }

  goBack() {
    this.router.navigate(['/restaurants']);
  }
}
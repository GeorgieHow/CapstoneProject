import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

  private apiUrl = "http://localhost:8080/api/restaurants";

  constructor(private http: HttpClient) { }

}

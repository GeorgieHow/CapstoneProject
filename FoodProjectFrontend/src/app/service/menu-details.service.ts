import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MenuItem } from '../model/menu-item';

@Injectable({
  providedIn: 'root'
})
export class MenuDetailsService {

  private apiUrl = "http://localhost:8080/api/menu-items";

  constructor(private http: HttpClient) { }

  getAllMenuItems(): Observable<MenuItem[]> {
    return this.http.get<MenuItem[]>(this.apiUrl);
  }

  getMenuItemsByRestaurantId(id: number): Observable<MenuItem[]> {
    return this.http.get<MenuItem[]>(`${this.apiUrl}/restaurant/${id}`);
  }

  addMenuItem(menuItem: MenuItem, restaurantId: number): Observable<MenuItem> {
    const params = new HttpParams().set('restaurantId', restaurantId.toString());
    return this.http.post<MenuItem>(this.apiUrl, menuItem, { params });
  }
}

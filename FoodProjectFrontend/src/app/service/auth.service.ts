import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private loggedInStatus = new BehaviorSubject<boolean>(false);

  constructor() { }

  get isLoggedIn() {
    return this.loggedInStatus.asObservable();
  }

  login() {
    this.loggedInStatus.next(true);
  }

  logout() {
    this.loggedInStatus.next(false);
    localStorage.removeItem('user');
  }
}

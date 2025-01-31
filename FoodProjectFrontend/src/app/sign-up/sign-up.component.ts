import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { User } from '../model/user';
import { UserService } from '../service/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sign-up',
  standalone: false,
  
  templateUrl: './sign-up.component.html',
  styleUrl: './sign-up.component.css'
})
export class SignUpComponent {

  constructor(private userService: UserService, private router: Router) { }

  onSubmit(form: NgForm): void {
    if (form.valid) {
      const newUser: User = form.value;
      this.userService.createUser(newUser).subscribe(
        response => {
          console.log('User created successfully', response);
          this.router.navigate(['/restaurants']);
        },
        error => {
          console.error('Error creating user', error);
   
        }
      );
    }
  }
}
import { Component } from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  username = '';
  password = '';

  constructor(private http: HttpClient, private router: Router) {}

  onLogin() {
    const loginUrl = 'http://localhost:8080/api/auth/login';
    const body = {
      username: this.username,
      password: this.password
    };

    this.http.post(loginUrl, body).subscribe({
      next: (response: any) => {
        console.log('Login Successful!', response);

        localStorage.setItem('token', response.token);

        this.router.navigate(['/tickets']);
      },
      error: (error) => {
        console.log('Login Failed', error);
        alert('Login failed! Check your username/password.');
      }
    })
  }
}

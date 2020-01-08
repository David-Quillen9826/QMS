import { Injectable } from '@angular/core';
import { ReplaySubject, Subject } from 'rxjs';
import { Router } from '@angular/router';
import { AppUser } from '../models/app-user';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private currentUserStream = new ReplaySubject<AppUser>(1);
  $currentUser = this.currentUserStream.asObservable();

  private loginErrorStream = new Subject<string>();
  $loginError = this.loginErrorStream.asObservable();


  constructor(private httpClient: HttpClient, private router: Router) {
    this.httpClient.get<AppUser>('http://localhost:8080/Project4/auth/session-user', {
      withCredentials: true
    }).subscribe(
      data => {
        console.log('logged in');
        console.log(data);
        this.currentUserStream.next(data);
      },
      err => {
        console.log('not currently logged in')
      }
    );
  }

  login(credentials) {
    this.httpClient.post<AppUser>('http://localhost:8080/Project4/auth/login', credentials, {
      withCredentials: true
    }).subscribe(
      data => {
        console.log('logged in');
        this.router.navigateByUrl('/home');
        this.currentUserStream.next(data);
      },
      err => {
        console.log(err);
        this.loginErrorStream.next('Failed to Login');
      }
    );
  }
}

import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  credentials = {
    username: '',
    password: ''
  };
  
  errorMessage = '';
  errorMessageSubscription: Subscription;

  constructor(private authService: AuthService) { }

  ngOnInit() {
    // every time the subject publishes new content 
    // it will invoke the subscriber method
    this.errorMessageSubscription = this.authService.$loginError.subscribe(errorMessage => {
      this.errorMessage = errorMessage;
    });
  }

  login() {
    this.authService.login(this.credentials);
  }


  ngOnDestroy() {
    this.errorMessageSubscription.unsubscribe();
  }
}

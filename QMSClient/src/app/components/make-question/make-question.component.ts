import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-make-question',
  templateUrl: './make-question.component.html',
  styleUrls: ['./make-question.component.css']
})
export class MakeQuestionComponent implements OnInit {

  errorMessage = '';
  errorMessageSubscription: Subscription;

  make = {
    question: '',
    correct: '',
    wrong1: '',
    wrong2: '',
    wrong3: ''
  };
  constructor() { }

  ngOnInit() {
  }

}

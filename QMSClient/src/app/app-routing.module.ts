import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { GradesComponent } from './components/grades/grades.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { MakeQuestionComponent } from './components/make-question/make-question.component';


const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'grades',
    component: GradesComponent
  },
  {
    path: 'make-question',
    component: MakeQuestionComponent
  },
  {
    path: 'make-quiz',
    component: MakeQuestionComponent
  },
  {
    path: '**',
    pathMatch: 'full',
    component: NotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

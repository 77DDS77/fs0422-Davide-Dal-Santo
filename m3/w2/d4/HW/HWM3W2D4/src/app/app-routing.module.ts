import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AllTodoComponent } from './pages/all-todo/all-todo.component';
import { AllUserComponent } from './pages/all-user/all-user.component';
import { HomeComponent } from './pages/home/home.component';
import { NewTodoComponent } from './pages/new-todo/new-todo.component';
import { NewUserComponent } from './pages/new-user/new-user.component';

const routes: Routes = [
  {
    path:'',
    component: HomeComponent
  },
  {
    path:'all-todos',
    component: AllTodoComponent,
  },
  {
    path:'all-users',
    component: AllUserComponent
  },
  {
    path:'new-user',
    component: NewUserComponent
  },
  {
    path:'new-todo',
    component: NewTodoComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

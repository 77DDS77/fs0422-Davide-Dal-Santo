import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NavigationGuard } from './Guards/navigation.guard';
import { LoginComponent } from './Pages/Auth/login/login.component';
import { RegisterComponent } from './Pages/Auth/register/register.component';
import { NewPostComponent } from './Pages/new-post/new-post.component';
import { PostsComponent } from './Pages/posts/posts.component';
import { ProfileComponent } from './Pages/profile/profile.component';
import { UsersComponent } from './Pages/users/users.component';

const routes: Routes = [
  {
    path: '',
    component: LoginComponent
  },
  {
    path: 'register',
    component: RegisterComponent
  },
  {
    path: 'profile/:name',
    component: ProfileComponent,
    canActivate: [NavigationGuard],
    children:[
      {
        path:'new-post',
        component: NewPostComponent
      }
    ]
  },
  {
    path:'posts',
    component: PostsComponent
  },
  {
    path:'users',
    component: UsersComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

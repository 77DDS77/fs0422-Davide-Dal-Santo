import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ActivePostComponent } from './pages/active-post/active-post.component';
import { HomeComponent } from './pages/home/home.component';
import { InactivePostComponent } from './pages/inactive-post/inactive-post.component';

const routes: Routes = [
  {
    path:'',
    component:HomeComponent,
  },
  {
    path:'active-post',
    component:ActivePostComponent
  },
  {
    path:'inactive-post',
    component:InactivePostComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

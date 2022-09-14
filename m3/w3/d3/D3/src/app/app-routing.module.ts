import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { PizzeDetailComponent } from './pizze/pizze-detail/pizze-detail.component';
import { PizzeListComponent } from './pizze/pizze-list/pizze-list.component';
import { PizzeComponent } from './pizze/pizze/pizze.component';


const routes: Routes = [
  {
    path:'',
    component: HomeComponent
  },
  {
    path:'pizze',
    component: PizzeComponent,
    children:[
      {
        path:'',
        component: PizzeListComponent
      },
      {
        path:'detail/:id',
        component: PizzeDetailComponent
      }
    ]
  },
  // {
  //   path:'primi',
  //   loadChildren: () => import('./primi/primi.module').then(m => m.PrimiModule)
  // }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

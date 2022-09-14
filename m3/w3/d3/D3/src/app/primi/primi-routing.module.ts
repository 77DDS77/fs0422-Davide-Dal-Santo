import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { PrimiComponent } from './primi/primi.component';
import { PrimiListComponent } from './primi-list/primi-list.component';
import { PrimiDetailComponent } from './primi-detail/primi-detail.component';

const routes:Routes = [
  {
    path:'primi',
    component: PrimiComponent,
    children:[
      {
        path:'',
        component: PrimiListComponent
      },
      {
        path:'detail/:id',
        component: PrimiDetailComponent
      }
    ]
  }
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class PrimiRoutingModule { }

import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './Pages/home/home.component';
import { ReactFormsComponent } from './Pages/react-forms/react-forms.component';
import { TDFormComponent } from './Pages/tdform/tdform.component';

const routes: Routes = [
  {
    path:'',
    component: HomeComponent
  },
  {
    path:'template-driven-form',
    component: TDFormComponent
  },
  {
    path:'reactive-form',
    component: ReactFormsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

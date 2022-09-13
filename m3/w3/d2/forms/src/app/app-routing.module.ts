import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormsComponent } from './pages/forms/forms.component';
import { NgModelGroupComponent } from './pages/ng-model-group/ng-model-group.component';
import { NgSubmitComponent } from './pages/ng-submit/ng-submit.component';
import { ReactiveFormsComponent } from './pages/reactive-forms/reactive-forms.component';

const routes: Routes = [
  {
    path:'',
    component: FormsComponent
  },
  {
    path:'ngsubmit',
    component: NgSubmitComponent
  },
  {
    path:'ngmodelgroup',
    component: NgModelGroupComponent
  },
  {
    path:'reactive-forms',
    component: ReactiveFormsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

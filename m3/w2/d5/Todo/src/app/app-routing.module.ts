import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CompletedComponent } from './Pages/completed/completed.component';
import { TodoComponent } from './Pages/todo/todo.component';

const routes: Routes = [
  {
    path:'',
    component: TodoComponent
  },
  {
    path:'completed',
    component: CompletedComponent
  },
  {
    path:'**',
    component: TodoComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

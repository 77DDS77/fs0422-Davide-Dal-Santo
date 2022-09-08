import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './pages/home/home.component';
import { NewUserComponent } from './pages/new-user/new-user.component';
import { NewTodoComponent } from './pages/new-todo/new-todo.component';
import { AllUserComponent } from './pages/all-user/all-user.component';
import { AllTodoComponent } from './pages/all-todo/all-todo.component';
import { ToMaiuscPipe } from './Pipes/to-maiusc.pipe';
import { HiglightDirective } from './Directives/higlight.directive';
import { HeaderComponent } from './Main/header/header.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NewUserComponent,
    NewTodoComponent,
    AllUserComponent,
    AllTodoComponent,
    ToMaiuscPipe,
    HiglightDirective,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

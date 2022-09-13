import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './Pages/home/home.component';
import { TDFormComponent } from './Pages/tdform/tdform.component';
import { ReactFormsComponent } from './Pages/react-forms/react-forms.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    TDFormComponent,
    ReactFormsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

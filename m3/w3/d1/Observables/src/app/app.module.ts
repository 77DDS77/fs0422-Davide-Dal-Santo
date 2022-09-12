import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './pages/home/home.component';
import { IntervalComponent } from './pages/interval/interval.component';
import { Interval2Component } from './pages/interval2/interval2.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    IntervalComponent,
    Interval2Component
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

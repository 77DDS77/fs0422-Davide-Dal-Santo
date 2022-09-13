import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsComponent } from './pages/forms/forms.component';
import { NgSubmitComponent } from './pages/ng-submit/ng-submit.component';
import { NgModelGroupComponent } from './pages/ng-model-group/ng-model-group.component';
import { ReactiveFormsComponent } from './pages/reactive-forms/reactive-forms.component';

@NgModule({
  declarations: [
    AppComponent,
    FormsComponent,
    NgSubmitComponent,
    NgModelGroupComponent,
    ReactiveFormsComponent
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

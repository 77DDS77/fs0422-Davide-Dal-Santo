import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ColoraDirective } from './colora.directive';
import { CutPipe } from './cut.pipe';

@NgModule({
  declarations: [
    AppComponent,
    ColoraDirective,
    CutPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

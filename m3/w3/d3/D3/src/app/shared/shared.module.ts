import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ListComponent } from './list/list.component';
import { ItemComponent } from './item/item.component';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    ListComponent,
    ItemComponent
  ],
  imports: [
    CommonModule,
    FormsModule //importo ed esporto forms module cosi tutti i comp che usano lo shared ce l'hanno
  ],
  exports:[
    ItemComponent,
    ListComponent,
    FormsModule
  ]
})
export class SharedModule { }

import { Component } from '@angular/core';

import {MatDialog} from '@angular/material/dialog';
import { ModalContentComponent } from './modal-content/modal-content.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  constructor(public dialog: MatDialog) {}

  title = 'material';

  name:string = 'Material'

  dati:any = {dati: this.name}

  openDialog(){
    const dialogRef = this.dialog.open(ModalContentComponent,{
      width:'300px',
      data: this.dati.dati
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
    });

  }

  // esperimenti cdk

  items:any[] = Array(100000).fill(1).map((_,i) => `Elemento num. ${i}` )

  ngOnInit(){
    console.log(this.items);

  }



}

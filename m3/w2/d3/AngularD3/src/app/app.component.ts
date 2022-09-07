import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { User } from './Models/user';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {


  allUsers:User[] = [];

  addUser(event:User){
    let userCopy:User = Object.assign({}, event)
    this.allUsers.push(userCopy);
  }

  visible:boolean = true;
  visibleCSS:boolean = true;

  @ViewChild('pippo') pippo!:ElementRef;

  log(): void {
    console.log(this.pippo);
    this.pippo.nativeElement.style.color = 'red';
  }

}

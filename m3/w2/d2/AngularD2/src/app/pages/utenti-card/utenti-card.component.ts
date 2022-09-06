import { Component, Input, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';

@Component({
  selector: 'app-utenti-card',
  templateUrl: './utenti-card.component.html',
  styleUrls: ['./utenti-card.component.scss']
})
export class UtentiCardComponent implements OnInit {

  @Input() utenti!:User[];

  constructor() { }

  ngOnInit(): void {
  }

}

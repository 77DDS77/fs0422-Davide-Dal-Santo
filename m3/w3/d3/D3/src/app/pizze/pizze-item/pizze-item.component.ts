import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-pizze-item',
  templateUrl: './pizze-item.component.html',
  styleUrls: ['./pizze-item.component.scss']
})
export class PizzeItemComponent implements OnInit {

  @Input() pizza!:string
  constructor() { }

  ngOnInit(): void {
  }

}

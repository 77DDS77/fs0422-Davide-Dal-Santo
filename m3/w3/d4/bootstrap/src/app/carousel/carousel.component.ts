import { Component, OnInit } from '@angular/core';

type slide = {
  image:string,
  title:string,
  caption:string
}


@Component({
  selector: 'app-carousel',
  templateUrl: './carousel.component.html',
  styleUrls: ['./carousel.component.scss']
})
export class CarouselComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  images:string[] = [
    "https://images.unsplash.com/photo-1602246256440-bbaab6274ea9?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1032&q=80",
    "https://images.unsplash.com/photo-1628346149786-f17dd358292f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80",
    "https://images.unsplash.com/photo-1625619302238-b6075341feab?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=877&q=80"
  ];

  slides:slide[] = [
    {
      image:"https://images.unsplash.com/photo-1602246256440-bbaab6274ea9?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1032&q=80",

      title:'Primo titolo',
      caption:'Prima caption'
    },
    {
      image:"https://images.unsplash.com/photo-1628346149786-f17dd358292f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80",

      title:'Secondo titolo',
      caption:'Seconda caption'
    },
    {
      image:"https://images.unsplash.com/photo-1625619302238-b6075341feab?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=877&q=80",

      title:'Terzo titolo',
      caption:'Terza caption'
    }

  ]

}

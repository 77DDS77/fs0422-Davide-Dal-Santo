import { Component, OnInit } from '@angular/core';

/**
 * su selector posso metterci ad esempio
 * ".app-button" e posso chiamare sull'HTML
 * un div class="app-button" e mi schiaffa dentro il component
 */

@Component({
  selector: 'app-button',
  templateUrl: './button.component.html',
  styleUrls: ['./button.component.css'],
})
export class ButtonComponent implements OnInit {
  constructor() {}

  ngOnInit(): void {}

  // toggle botone
  mostra: boolean = false;

  toggle() {
    this.mostra = !this.mostra;
  }
}

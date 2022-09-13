import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Hero } from 'src/app/Class/hero';





@Component({
  selector: 'app-tdform',
  templateUrl: './tdform.component.html',
  styleUrls: ['./tdform.component.scss']
})
export class TDFormComponent implements OnInit {

  @ViewChild('form') form!:NgForm;

  constructor() { }

  ngOnInit(): void {
  }

  allHeroes:Hero[] = [];

  heroForm:Hero = {
    name:'',
    alterEgo:'',
    power:'',
    enemy:'',
    planet:'',
    weakness:''
  }

  submit(form:NgForm){
    console.log(form);
    this.allHeroes.push(form.form.value)
    this.form.reset();
  }

}

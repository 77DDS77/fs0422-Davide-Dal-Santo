import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-ng-model-group',
  templateUrl: './ng-model-group.component.html',
  styleUrls: ['./ng-model-group.component.scss']
})
export class NgModelGroupComponent implements OnInit {

  @ViewChild('form') form!:NgForm;

  constructor() { }

  ngOnInit(): void {
  }


  userForm:any =
  {
    name:'',
    lastname:'',
    street:'',
    city:'',
    zipcode:''
  }

  submit(form:NgForm){
    console.log(form);

    //reset sbagliato, mi scattan ole validazioni per dirty/touched
    /**
     *
     this.userForm =
     {
       name:'',
       lastname:'',
       street:'',
       city:'',
       zipcode:''
      }
    */

    //reset giusto
    this.form.reset();

  }

  // setValue vuole che gli sian opassati TUTTI i dati
  //per ogni campo del form
  riempi(){
    console.log(this.form);
    this.form.form.setValue({
      name:'Rossana',
      lastname:'Bianchi',
      userAddress:{
        street:'Via Roma 5',
        city:'Milano',
        zipcode:'54336'
      }
    })

  }

  // patchValue a differenza di setValue non ha bisogno
  //di tutti i dati, posso passarne un parziale
  aggiorna(){
    this.form.form.patchValue({
      userAddress:{
        street:'Via Roma 5',
        city:'Milano',
        zipcode:'54336'
      }
    })
  }

}

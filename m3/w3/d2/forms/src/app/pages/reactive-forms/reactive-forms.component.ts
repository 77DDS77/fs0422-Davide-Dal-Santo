import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormArray, FormControl, FormGroup, ValidationErrors, Validators } from '@angular/forms';

@Component({
  selector: 'app-reactive-forms',
  templateUrl: './reactive-forms.component.html',
  styleUrls: ['./reactive-forms.component.scss']
})
export class ReactiveFormsComponent implements OnInit {

  // DA IMPORTARE SU APP.MODULE
  // import { FormsModule, ReactiveFormsModule } from '@angular/forms';

  //agli input non do piu l'attributo name ma
  //formControlName="name"

  /**
   * nei Validators
   * .min(5) e' per far inserire un NUMERO che sia almeno 5 EX Eta minima 18
   * .minLength(5) e' per far inserire una stringa lunga MINIMO 5 caratteri
  */

  constructor() { }

  form!:FormGroup

  ngOnInit(): void {

    this.form = new FormGroup({
      name:new FormControl(null, [Validators.required, this.usernameValidator]),
      lastname:new FormControl(null, [Validators.required, Validators.minLength(3)]),
      email:new FormControl(null,
        [Validators.required, Validators.email],
        [this.emailAllowedValidator]),
      userAddress: new FormGroup({
        address:new FormControl(null),
        city:new FormControl(null),
        zipcode:new FormControl(null)
      }),
      sports: new FormArray([])
    })

  }

  submit(){
    console.log(this.form);
    console.log(this.form.value);
  }

  getControl(name:string){
    return this.form.get(name)
  }

  checkFullValidity(name:string){
    return this.getControl(name)?.invalid && this.getControl(name)?.touched && this.getControl(name)?.dirty
  }

  getSports(){
    return (this.form.get('sports') as FormArray).controls
  }

  addSport(){
    let control:FormControl = new FormControl(null)
    let sports = <FormArray>this.form.get('sports')
    sports.push(control)
  }


  /**
   * CUSTOM VALIDATORS
  */

  usernameProibiti:string[] = ['admin', 'administrator']

  usernameValidator = (control:FormControl) => {
    if(this.usernameProibiti.includes(control.value?.toLowerCase())){
      return {proibiuto:true}//invalido il campo
    }
    return null;//lascio che il campo resti/diventi valido
  }

  /**
   * VALIDATORE ASINCRONO
  */
  emailProibile:string[] = ['admin@admin.it', 'administrator@administrator.it']
  emailAllowedValidator = (control:AbstractControl) => {
    return new Promise<ValidationErrors | null>((resolve) => {
      setTimeout(() => {

        if(this.emailProibile.includes(control.value?.toLowerCase())){
          resolve({emailProibita:true})
        }else{
          resolve(null)
        }

      },2000)
    })
  }


}

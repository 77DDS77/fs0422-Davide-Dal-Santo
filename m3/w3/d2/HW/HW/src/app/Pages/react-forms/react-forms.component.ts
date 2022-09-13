import { Component, OnInit } from '@angular/core';
import { FormArray, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-react-forms',
  templateUrl: './react-forms.component.html',
  styleUrls: ['./react-forms.component.scss']
})
export class ReactFormsComponent implements OnInit {

  constructor() { }

  form!:FormGroup
  allHeroes:any[] = [];

  ngOnInit(): void {
    this.form = new FormGroup({
      name: new FormControl(null, Validators.required),
      alterEgo: new FormControl(null, Validators.required),
      enemy: new FormControl(null,[Validators.required, Validators.maxLength(10)]),
      planet: new FormControl(null, [Validators.required, Validators.minLength(5)]),
      power: new FormArray([new FormControl(null)]),
      weakness: new FormArray([])
    })

  }

  submit(){
    this.allHeroes.push(this.form.value)
    console.log(this.form);
  }

  addPower(){
    let control:FormControl = new FormControl(null);
    let powers = <FormArray>this.form.get('power')
    powers.push(control)
  }

  getPowers(){
    return (this.form.get('power') as FormArray).controls
  }

  addWeakness(){
    let control:FormControl = new FormControl(null);
    let weakness = <FormArray>this.form.get('weakness')
    weakness.push(control)
  }

  getWeakness(){
    return (this.form.get('weakness') as FormArray).controls
  }

}

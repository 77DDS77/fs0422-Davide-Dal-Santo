import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService, ILogin } from 'src/app/Services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  form!: FormGroup

  constructor(
    private auth: AuthService,
    private router: Router
    ) { }

  ngOnInit(): void {
    this.form = new FormGroup({
      name: new FormControl(null),
      email: new FormControl(null),
      password: new FormControl(null)
    })
  }

  submit(){
    this.auth.register(this.form.value)
    .subscribe(res => {
      alert(`User ${res.user.name} registered successfully`) //togliere alert

      let loginObj:ILogin = {
        email: this.form.value.email,
        password: this.form.value.password
      }

      this.auth.login(loginObj)
      .subscribe(res => {
        this.auth.saveAccessData(res)
        console.log('utente loggato');
        //togliere log e aggiungere redirect
      })
      this.form.reset();
    })
  }

}

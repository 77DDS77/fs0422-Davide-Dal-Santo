import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  form!: FormGroup;
  formIsValid!: boolean;

  constructor(
    private auth:AuthService,
    private router:Router
    ) { }

  ngOnInit(): void {
    this.form = new FormGroup({
      username: new FormControl(null, Validators.required),
      password: new FormControl(null, Validators.required),
    })
  }

  login():void{
    if(this.form.valid){

      this.auth.login(this.form.value)
      .subscribe(res => {
        this.auth.saveAccessData(res);
        this.router.navigate(['/customers'])
        this.form.reset();
      })
    }
    else{
      this.formIsValid = false;
    }
  }

}

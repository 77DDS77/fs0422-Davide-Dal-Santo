import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/Classes/user';
import { AuthService } from 'src/app/Services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  form!: FormGroup
  formIsValid!: boolean;
  userNameParam:string = this.auth.isUserLogged() ? this.auth.getLoggedUser().slug : '';

  constructor(
    private auth: AuthService,
    private router: Router
  ) { }

  ngOnInit(): void {
    if(this.userNameParam == ''){
      this.form = new FormGroup({
        email: new FormControl(null, Validators.required),
        password: new FormControl(null, Validators.required),
      })
    }else{
      this.router.navigate(['/profile', this.userNameParam])
    }
  }

  login(){
    if(this.form.valid){

      this.auth.login(this.form.value)
      .subscribe(res => {
        this.auth.saveAccessData(res);
        this.router.navigate(['/profile/'+User.slugify(res.user.name)]);
        this.form.reset();
      })
    }
    else{
      this.formIsValid = false;
    }
  }

}

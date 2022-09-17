import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
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
  userNameParam:string = this.auth.isUserLogged() ? this.auth.getLoggedUser().slug : '';

  constructor(
    private auth: AuthService,
    private router: Router
  ) { }

  ngOnInit(): void {
    if(this.userNameParam == ''){
      this.form = new FormGroup({
        email: new FormControl(null),
        password: new FormControl(null),
      })
    }else{
      this.router.navigate(['/profile', this.userNameParam])
    }
  }

  login(){
    this.auth.login(this.form.value)
    .subscribe(res => {
      this.auth.saveAccessData(res);
      this.router.navigate(['/profile/'+User.slugify(res.user.name)]);
      this.form.reset();
    })
  }

}

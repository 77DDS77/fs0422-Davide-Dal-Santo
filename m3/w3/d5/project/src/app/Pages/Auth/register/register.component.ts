import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/Classes/user';
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
    this.auth.register(new User(this.form.value.name, this.form.value.email, this.form.value.password))
    .subscribe(res => {
      alert(`User ${res.user.name} registered successfully`) //togliere alert

      this.auth.saveAccessData(res)
      console.log('utente loggato');
      this.router.navigate(['/profile/'+User.slugify(res.user.name)]);
      //togliere log e aggiungere redirect
      this.form.reset();
    })
  }

}

import { Component, OnInit, TemplateRef } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
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
    private router: Router,
    private modalService: NgbModal
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
      // alert(`User ${res.user.name} registered successfully`) //togliere alert
      this.auth.saveAccessData(res)
      this.router.navigate(['/profile/'+User.slugify(res.user.name)]);
      this.form.reset();
    })
  }

  openVerticallyCentered(content:any) {
    this.modalService.open(content, { centered: true })
  }

}

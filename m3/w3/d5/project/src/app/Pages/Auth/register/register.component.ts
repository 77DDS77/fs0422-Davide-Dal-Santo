import { Component, OnInit, TemplateRef } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
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
  isFormValid!: boolean;

  constructor(
    private auth: AuthService,
    private router: Router,
    private modalService: NgbModal
    ) { }

  ngOnInit(): void {
    this.form = new FormGroup({
      name: new FormControl(null, Validators.required),
      email: new FormControl(null, Validators.required),
      password: new FormControl(null, Validators.required)
    })

  }

  submit(){
    if(this.form.valid){
      this.auth.register(new User(this.form.value.name, this.form.value.email, this.form.value.password))
      .subscribe(res => {
        this.auth.saveAccessData(res)
        this.router.navigate(['/profile/'+User.slugify(res.user.name)]);
        this.form.reset();
      })
    }else{
      console.log('aasgas');

      this.isFormValid = false;
    }
  }

  openVerticallyCentered(content:any) {
    this.modalService.open(content, { centered: true })
  }

}

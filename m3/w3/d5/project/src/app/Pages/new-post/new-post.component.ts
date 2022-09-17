import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Post } from 'src/app/Classes/post';
import { AuthService } from 'src/app/Services/auth.service';
import { PostService } from 'src/app/Services/post.service';

@Component({
  selector: 'app-new-post',
  templateUrl: './new-post.component.html',
  styleUrls: ['./new-post.component.scss']
})
export class NewPostComponent implements OnInit {

  form!: FormGroup
  submitBtn!:HTMLButtonElement
  formIsValid!: boolean

  constructor(
    private postSvc: PostService,
    private auth: AuthService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.form = new FormGroup({
      postTitle: new FormControl(null, [Validators.required, Validators.minLength(1)]),
      postContent: new FormControl(null, Validators.required),
      postOwner: new FormControl(this.auth.getLoggedUser().id)
    })

  }

  submit(){
    if(this.form.valid){

      this.postSvc.addPost(
        new Post(
          this.form.value.postTitle,
          this.form.value.postContent,
          this.form.value.postOwner,
          this.auth.getLoggedUser().name
          ))
      .subscribe(res => {
        this.router.navigate(['/profile', this.auth.getLoggedUser().slug]);
      })

    }else{
      this.formIsValid = false;

    }
  }


}

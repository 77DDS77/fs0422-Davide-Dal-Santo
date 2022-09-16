import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
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

  constructor(
    private postSvc: PostService,
    private auth: AuthService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.form = new FormGroup({
      postTitle: new FormControl(null),
      postContent: new FormControl(null),
      postOwner: new FormControl(this.auth.getLoggedUser().id)
    })

  }

  submit(){
    this.postSvc.addPost(new Post(this.form.value.postTitle, this.form.value.postContent, this.form.value.postOwner))
    .subscribe(res => {
      this.router.navigate(['/profile', this.auth.getLoggedUser().slug]);
    })
  }


}

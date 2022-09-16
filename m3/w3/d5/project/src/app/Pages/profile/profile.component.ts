import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, NavigationEnd, NavigationStart, Router } from '@angular/router';
import { filter } from 'rxjs';
import { Post } from 'src/app/Classes/post';
import { User } from 'src/app/Classes/user';
import { AuthService } from 'src/app/Services/auth.service';
import { PostService } from 'src/app/Services/post.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent {

  constructor(
    private activeRoute: ActivatedRoute,
    private auth: AuthService,
    private postSvc: PostService,
    private router: Router
  )
  {
    this.user = this.auth.getLoggedUser()
    this.router.events.subscribe((event) => {
      this.getMyPosts();
    })
  }

  user!: User;
  userNameParam!:string;
  allPostsByUser:Post[] = [];

  getMyPosts():void{
    this.postSvc.getPostByOwner(this.auth.getLoggedUser().id)
    .subscribe(posts => {
      console.log(posts)
      this.allPostsByUser = posts;
    })
  }

  deleteMyPost(post:Post){
    this.postSvc.deletePost(post)
    .subscribe(() =>{
      let index = this.allPostsByUser.findIndex(p => p.id === post.id)
      this.allPostsByUser.splice(index, 1)
    })
  }



}



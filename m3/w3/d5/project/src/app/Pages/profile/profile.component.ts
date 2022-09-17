import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
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
    private auth: AuthService,
    private postSvc: PostService,
    private router: Router,
    private modalService: NgbModal
  )
  {
    if(this.auth.isUserLogged()){
      this.user = this.auth.getLoggedUser()
      this.router.events.subscribe((event) => {
        this.getMyPosts();
      })
    }
  }

  user!: User;
  userNameParam:string = this.auth.getLoggedUser().slug;
  allPostsByUser:Post[] = [];

  getMyPosts():void{
    this.postSvc.getPostByOwner(this.auth.getLoggedUser().id)
    .subscribe(posts => {
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

  openVerticallyCentered(content:any) {
    this.modalService.open(content, { centered: true })
  }
}



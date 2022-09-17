import { Component, OnInit } from '@angular/core';
import { Post } from 'src/app/Classes/post';
import { User } from 'src/app/Classes/user';
import { PostService } from 'src/app/Services/post.service';
import { UserService } from 'src/app/Services/user.service';

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.scss']
})
export class PostsComponent implements OnInit {

  allPosts: Post[] = [];
  allUsers: User[] = [];
  postOwnerName!:string;

  constructor(
    private postSvc: PostService,
    private userSvc: UserService
  ) { }

  ngOnInit(): void {
    this.getAllPostsAndOwnerNames();
  }

  getAllPostsAndOwnerNames(){
    this.postSvc.getAllPosts()
    .subscribe(posts => {
      this.allPosts = posts;
      this.userSvc.getAllUsers()
      .subscribe(users => {
        this.allUsers = users;
        for(let post of posts){
          console.log(users.filter(user => user.id == post.ownerId));

          this.postOwnerName = users.filter(user => user.id == post.ownerId)[0].name;
        }
      })

    })
  }



}

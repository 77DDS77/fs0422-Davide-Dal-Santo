import { Component, OnInit } from '@angular/core';
import { Post } from 'src/app/Classes/post';
import { PostService } from 'src/app/Services/post.service';

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.scss']
})
export class PostsComponent implements OnInit {

  allPosts: Post[] = [];

  constructor(private postSvc: PostService) { }

  ngOnInit(): void {
    this.getAllPosts();
  }

  getAllPosts(){
    this.postSvc.getAllPosts()
    .subscribe(posts => {
      this.allPosts = posts;
    })
  }



}

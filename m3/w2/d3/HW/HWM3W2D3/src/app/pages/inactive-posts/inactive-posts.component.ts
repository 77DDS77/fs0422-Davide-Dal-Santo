import { Component, OnInit } from '@angular/core';
import { Post } from 'src/app/modules/post';
import { PostService } from 'src/app/services/post.service';

@Component({
  selector: 'app-inactive-posts',
  templateUrl: './inactive-posts.component.html',
  styleUrls: ['./inactive-posts.component.css']
})
export class InactivePostsComponent implements OnInit {

  constructor(private postSvc: PostService) { }

  ngOnInit(): void {
    this.getInactivePosts()
  }

  inactivePosts: Post[] = [];
  allPosts: Post[] = [];

  getInactivePosts():void {
    this.postSvc.getAllPosts().then(res => {
      this.inactivePosts = res.filter(post => post.active == true)
    });
  }

}

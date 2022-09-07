import { Component, OnInit } from '@angular/core';
import { Post } from 'src/app/modules/post';
import { PostService } from 'src/app/services/post.service';

@Component({
  selector: 'app-active-posts',
  templateUrl: './active-posts.component.html',
  styleUrls: ['./active-posts.component.css']
})
export class ActivePostsComponent implements OnInit {

  constructor(private postSvc: PostService) { }

  ngOnInit(): void {
    this.getActivePosts()
  }

  activePosts: Post[] = [];
  allPosts: Post[] = [];

  getActivePosts():void {
    this.postSvc.getAllPosts().then(res => {
      this.activePosts = res.filter(post => post.active == true)
    });
  }





}

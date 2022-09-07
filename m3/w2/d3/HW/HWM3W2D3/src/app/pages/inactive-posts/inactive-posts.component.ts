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
      this.inactivePosts = res.filter(post => post.active == false)
    });
  }

  changeStatus(id:number|undefined):void{
    let thisPost:Post|undefined = this.inactivePosts.find(post => post.id == id);
    let thisPostIndex:number|undefined = this.inactivePosts.findIndex(post => post.id == id);
    if(thisPost){
      thisPost.active = !thisPost.active;
      this.inactivePosts.slice(thisPostIndex, 1)
    }

    let option = {
      method: "PATCH",
      body: JSON.stringify(thisPost),
      headers: {
          "content-type": "application/json"
      }
    }

    fetch('http://localhost:3000/posts/' + id, option)
    .then(res => res.json())
  }

}

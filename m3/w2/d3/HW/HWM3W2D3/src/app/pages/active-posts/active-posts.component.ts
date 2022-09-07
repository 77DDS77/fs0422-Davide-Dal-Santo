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

  changeStatus(id:number|undefined):void{
    let thisPost:Post|undefined = this.activePosts.find(post => post.id == id);
    let thisPostIndex:number|undefined = this.activePosts.findIndex(post => post.id == id);
    if(thisPost){
      thisPost.active = !thisPost.active;
      this.activePosts.slice(thisPostIndex, 1)
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

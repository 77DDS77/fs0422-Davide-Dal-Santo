import { Component, OnInit } from '@angular/core';
import { Post } from 'src/app/models/post';

@Component({
  selector: 'app-active-post',
  templateUrl: './active-post.component.html',
  styleUrls: ['./active-post.component.scss']
})
export class ActivePostComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    this.getPosts();
  }

  activePosts:Post[] = [];

  getPosts(){
    fetch('http://localhost:3000/posts')
    .then(res => res.json())
    .then(res => {
      this.activePosts =res.filter((post:Post) => post.active == true)
    })
  }

}

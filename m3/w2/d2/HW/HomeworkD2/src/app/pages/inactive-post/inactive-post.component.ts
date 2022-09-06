import { Component, OnInit } from '@angular/core';
import { Post } from 'src/app/models/post';

@Component({
  selector: 'app-inactive-post',
  templateUrl: './inactive-post.component.html',
  styleUrls: ['./inactive-post.component.scss']
})
export class InactivePostComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    this.getPosts();
  }

  inactivePosts:Post[] = [];

  getPosts(){
    fetch('http://localhost:3000/posts')
    .then(res => res.json())
    .then(res => {
      this.inactivePosts = res.filter((post:Post) => post.active == false)
    })
  }

}

import { Component, OnInit } from '@angular/core';
import { Post } from 'src/app/Models/post';

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.scss']
})
export class PostsComponent implements OnInit {

  allPosts:Post[] = [];

  constructor() { }

  ngOnInit(): void {
  }

}

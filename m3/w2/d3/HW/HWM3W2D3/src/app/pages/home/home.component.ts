import { Component, OnInit } from '@angular/core';
import { Post } from 'src/app/modules/post';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  newPost:Post = new Post('','', '');

  addNewPost():void{
    let postCopy = Object.assign({}, this.newPost)

    let option = {
      method: "POST",
      body: JSON.stringify(postCopy),
      headers: {
          "content-type": "application/json"
      }
    }

    fetch('http://localhost:3000/posts', option)
    .then(res => res.json())
    .then(() => {
      this.newPost = new Post('', '', '')
    })
  }
}

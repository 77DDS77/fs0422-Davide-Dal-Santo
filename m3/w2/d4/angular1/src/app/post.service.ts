import { Injectable } from '@angular/core';
import { Post } from './Models/post';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor() { }

  allPosts: Post[] = [];

  lastId: number = 0;

  getAllPosts(){
    return this.allPosts
  }

  getPostById(id:number|undefined):Post|null{
    let foundPost = this.allPosts.find((post:Post) => post.id === id)
    return foundPost || null;
  }

  addPost(post: Post):void{
    this.lastId++
    post = Object.assign({}, post);
    post.id = this.lastId
    this.allPosts.push(post);
  }

  deletePost(id: number|undefined):void{
    this.allPosts = this.allPosts.filter((p:Post) => p.id != id);
  }

  editPost(post:Post){
    let index = this.allPosts.findIndex((p:Post) => p.id == post.id);
    this.allPosts.splice(index, 1, post);
  }

}

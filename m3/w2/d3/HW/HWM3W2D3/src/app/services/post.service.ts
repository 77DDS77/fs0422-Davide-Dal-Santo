import { Injectable } from '@angular/core';
import { Post } from '../modules/post';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor() { }

  getAllPosts():Promise<Post[]>{
    return fetch('http://localhost:3000/posts').then(res => res.json())
  }

}

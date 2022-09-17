import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Post } from '../Classes/post';

@Injectable({
  providedIn: 'root',
})
export class PostService {
  constructor(private http: HttpClient) {}

  apiUrl: string = 'http://localhost:3000/posts';
  allPosts: Post[] = [];

  getAllPosts(): Observable<Post[]> {
    return this.http.get<Post[]>(this.apiUrl);
  }

  getPostById2(id: number): Post | null {
    this.getAllPosts().subscribe((posts) => (this.allPosts = posts));
    let foundPost = this.allPosts.find((post: Post) => Number(post.id) === id);
    return foundPost || null;
  }

  getPostById(id: Number): Observable<Post> {
    return this.http.get<Post>('http://localhost:3000/posts/' + id);
  }

  addPost(post: Post): Observable<Post> {
    return this.http.post<Post>(this.apiUrl, post);
  }

  editPost(post: Post, id:number): Observable<Post> {
    return this.http.patch<Post>(this.apiUrl + '/' + id, post);
  }

  deletePost(post: Post): Observable<Post> {
    return this.http.delete<Post>(this.apiUrl + '/' + post.id);
  }

  getPostByOwner(userId: number): Observable<Post[]> {
    return this.http.get<Post[]>(this.apiUrl + '/?ownerId=' + userId);
  }
}
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../Classes/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  apiUrl:string = 'http://localhost:3000/posts'

  getAllUsers():Observable<User[]>{
    return this.http.get<User[]>(this.apiUrl)
  }

  addUser(post:User):Observable<User>{
    return this.http.post<User>(this.apiUrl, post)
  }

  editUser(post:User):Observable<User>{
    return this.http.patch<User>(this.apiUrl + '/' + post.id, post)
  }

  deleteUser(post:User):Observable<User>{
    return this.http.delete<User>(this.apiUrl + '/' + post.id)
  }
}

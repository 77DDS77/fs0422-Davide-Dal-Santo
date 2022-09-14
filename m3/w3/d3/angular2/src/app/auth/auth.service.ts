import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ILogin } from './Models/login';
import { IRegister } from './Models/register';



@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http:HttpClient) { }

  apiUrl:string = 'http://localhost:3000'

  register(registerData:IRegister){
    return this.http.post(this.apiUrl + '/register', registerData)
  }

  login(loginData:ILogin){
    return this.http.post(this.apiUrl + '/login', loginData)
  }

}

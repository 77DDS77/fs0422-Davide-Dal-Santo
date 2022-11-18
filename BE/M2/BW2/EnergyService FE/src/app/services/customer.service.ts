import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { apiUrl } from 'src/environments/environment';
import { Customer } from '../models/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http:HttpClient) { }

  allCustomers:Customer[] = [];

  getAllCustomers():Observable<Customer[]> {
    return this.http.get<Customer[]>(apiUrl + '/customers');
  }

  getById(id:number):Observable<Customer> {
    return this.http.get<Customer>(apiUrl + '/customers/' + id);
  }

  searchByName(name:string):Observable<Customer[]> {
    return this.http.get<Customer[]>(apiUrl +"/customers/filtered/nome-contatto?nomeContatto="+name);
  }

  postNewCustomer(customer: Customer):Observable<Customer>{
    return this.http.post<Customer>(apiUrl + "/customers/new", customer)
  }
}

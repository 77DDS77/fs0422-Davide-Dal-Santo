import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { apiUrl } from 'src/environments/environment';
import { Invoice } from '../models/invoice';

@Injectable({
  providedIn: 'root'
})
export class InvoiceService {

  constructor(private http:HttpClient) { }

  allInvoices:Invoice[]=[];

  getAllInvoices():Observable<Invoice[]>{
    return this.http.get<Invoice[]>(apiUrl + '/invoices');
  }

  getByCustomerID(id:number):Observable<Invoice[]>{
    return this.http.get<Invoice[]>(apiUrl + '/invoices/filtered/customer-id/' + id);
  }

  postNewInvoice(inv:Invoice):Observable<Invoice>{
    console.log(inv);
    return this.http.post<Invoice>(apiUrl + '/invoices/new', inv);
  }

  // ACTIONS
  sendInvoice(id:number):Observable<Invoice>{
    return this.http.put<Invoice>(apiUrl + '/invoices/' + id + '/send', null);
  }

  acceptInvoice(id:number):Observable<Invoice>{
    return this.http.put<Invoice>(apiUrl + '/invoices/' + id + '/accept', null);
  }

  denyInvoice(id:number):Observable<Invoice>{
    return this.http.put<Invoice>(apiUrl + '/invoices/' + id + '/deny', null);
  }

  searchByNumber(num:number):Observable<Invoice[]>{
    return this.http.get<Invoice[]>(apiUrl + '/invoices/filtered/invoice-number?num='+num);
  }


}

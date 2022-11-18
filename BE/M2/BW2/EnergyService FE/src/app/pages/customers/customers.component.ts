import { Component, OnInit } from '@angular/core';
import { Customer } from 'src/app/models/customer';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.scss']
})
export class CustomersComponent implements OnInit {

  allCustomers:Customer[] = [];

  constructor(private custSvc: CustomerService) { }

  ngOnInit(): void {
    this.getAllCustomers();
  }

  getAllCustomers(){
    this.custSvc.getAllCustomers()
    .subscribe(res => {
      this.allCustomers = res;
    })
  }

  customerSearch(name:string){
    this.custSvc.searchByName(name)
    .subscribe(res =>{
      this.allCustomers = res;
    })
  }
}

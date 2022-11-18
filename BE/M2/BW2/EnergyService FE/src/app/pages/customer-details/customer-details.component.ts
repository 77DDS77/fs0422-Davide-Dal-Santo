import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Customer } from 'src/app/models/customer';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-customer-details',
  templateUrl: './customer-details.component.html',
  styleUrls: ['./customer-details.component.scss']
})
export class CustomerDetailsComponent implements OnInit {

  userId!:number;
  customer!:Customer;

  constructor(
    private custSvc:CustomerService,
    private route: ActivatedRoute
    ) { }

  ngOnInit(): void {
    this.route.params
    .subscribe(res => {
      this.userId = res['id'];
    })

    this.getCustomerById(this.userId);
  }

  getCustomerById(id:number){
    this.custSvc.getById(id)
    .subscribe(res => {
      this.customer = res;
    })
  }

}

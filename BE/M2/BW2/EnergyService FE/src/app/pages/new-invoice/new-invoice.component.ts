import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Customer } from 'src/app/models/customer';
import { Invoice } from 'src/app/models/invoice';
import { CustomerService } from 'src/app/services/customer.service';
import { InvoiceService } from 'src/app/services/invoice.service';

@Component({
  selector: 'app-new-invoice',
  templateUrl: './new-invoice.component.html',
  styleUrls: ['./new-invoice.component.scss']
})
export class NewInvoiceComponent implements OnInit {

  form!:FormGroup;
  today:string = new Date(Date.now()).toLocaleDateString();
  allCustomer:Customer[] = [];

  constructor(
    private invSvc:InvoiceService,
    private cusSvc:CustomerService,
    private router:Router
    ) { }

  ngOnInit(): void {

    this.searchCustomer();

    this.form = new FormGroup({
      data: new FormControl(this.today),
      importo: new FormControl(null),
      numeroFattura: new FormControl(null),
      customer: new FormControl(null),
    })
  }

  submit(){
    if(this.form.valid){


      this.invSvc.postNewInvoice(
        new Invoice(
          this.form.value.importo,
          this.form.value.numeroFattura,
          this.form.value.customer
        )
      )
      .subscribe(res =>{
        this.form.reset();
        this.router.navigate(["/invoices"])
      })
    }
  }

  searchCustomer(){
    this.cusSvc.getAllCustomers()
    .subscribe(res =>  {
      this.allCustomer = res;
    })
  }

}

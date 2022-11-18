import { Component, OnInit } from '@angular/core';
import { Invoice } from 'src/app/models/invoice';
import { InvoiceService } from 'src/app/services/invoice.service';

@Component({
  selector: 'app-invoices',
  templateUrl: './invoices.component.html',
  styleUrls: ['./invoices.component.scss']
})
export class InvoicesComponent implements OnInit {

  allInvoices:Invoice[] = [];

  constructor(private invSvc:InvoiceService) { }

  ngOnInit(): void {
    this.getAllInvoices();
  }

  getAllInvoices():void{
    this.invSvc.getAllInvoices()
    .subscribe(res => {
      this.allInvoices = res;
    })
  }
}

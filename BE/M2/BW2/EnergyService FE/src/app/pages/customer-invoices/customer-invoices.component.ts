import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Invoice } from 'src/app/models/invoice';
import { InvoiceService } from 'src/app/services/invoice.service';

@Component({
  selector: 'app-customer-invoices',
  templateUrl: './customer-invoices.component.html',
  styleUrls: ['./customer-invoices.component.scss'],
})
export class CustomerInvoicesComponent implements OnInit {
  userId!: number;
  custInvoices: Invoice[] = [];
  searchedInvoices:Invoice[] = [];

  constructor(private invSvc: InvoiceService, private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.route.params.subscribe((res) => {
      this.userId = res['id'];
    });

    this.invSvc.getByCustomerID(this.userId).subscribe((res) => {
      this.custInvoices = res;
    });
  }

  send(inv: Invoice) {
    this.invSvc.sendInvoice(inv.id).subscribe({
      complete: () => this.changeStatusUI(inv, 'INVIATA'),
    });
  }

  accept(inv: Invoice) {
    this.invSvc.acceptInvoice(inv.id).subscribe({
      complete: () => this.changeStatusUI(inv, 'ACCETTATA'),
    });
  }

  deny(inv: Invoice) {
    this.invSvc.denyInvoice(inv.id).subscribe({
      complete: () => this.changeStatusUI(inv, 'RIFIUTATA'),
    });
  }

  changeStatusUI(inv: Invoice, stato: string) {
    inv.statoFattura = stato;
  }

  invoiceSearch(invNum:string){
    // if(invNum != ""){
      let invNumber = parseInt(invNum, 10)
      this.invSvc.searchByNumber(invNumber)
      .subscribe(res => {
        this.searchedInvoices = res;
      })
    // }
  }
}

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomerDetailsComponent } from './pages/customer-details/customer-details.component';
import { CustomerInvoicesComponent } from './pages/customer-invoices/customer-invoices.component';
import { CustomersComponent } from './pages/customers/customers.component';
import { InvoicesComponent } from './pages/invoices/invoices.component';
import { LoginComponent } from './pages/login/login.component';
import { NewCustomerComponent } from './pages/new-customer/new-customer.component';
import { NewInvoiceComponent } from './pages/new-invoice/new-invoice.component';

const routes: Routes = [
  {
    path: '',
    component: LoginComponent
  },
  {
    path: 'customers',
    component: CustomersComponent
  },
  {
    path: 'new-customer',
    component: NewCustomerComponent
  },
  {
    path: 'invoices',
    component: InvoicesComponent
  },
  {
    path: 'invoices-of/:id',
    component: CustomerInvoicesComponent
  },
  {
    path: 'customer-details/:id',
    component: CustomerDetailsComponent
  },
  {
    path: 'new-invoice',
    component: NewInvoiceComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './pages/login/login.component';
import { CustomersComponent } from './pages/customers/customers.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthInterceptor } from './interceptors/auth.interceptor';
import { NewCustomerComponent } from './pages/new-customer/new-customer.component';
import { AddressFormComponent } from './pages/address-form/address-form.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { InvoicesComponent } from './pages/invoices/invoices.component';
import { CustomerInvoicesComponent } from './pages/customer-invoices/customer-invoices.component';
import { CustomerDetailsComponent } from './pages/customer-details/customer-details.component';
import { NewInvoiceComponent } from './pages/new-invoice/new-invoice.component';
import { TestComponent } from './pages/test/test.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    CustomersComponent,
    NewCustomerComponent,
    AddressFormComponent,
    NavBarComponent,
    InvoicesComponent,
    CustomerInvoicesComponent,
    CustomerDetailsComponent,
    NewInvoiceComponent,
    TestComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [
    {
      provide:HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi:true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { CustomersComponent } from './customers/customers.component';
import { AccountsComponent } from './accounts/accounts.component';
import {HttpClientModule} from "@angular/common/http";
import {ReactiveFormsModule} from "@angular/forms";
import { NewCustomerComponent } from './new-customer/new-customer.component';
<<<<<<< HEAD
import { CustomerAccountsComponent } from './customer-accounts/customer-accounts.component';
=======
>>>>>>> 892645581ff12c43f5590c01145f00bc9d90886b

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    CustomersComponent,
    AccountsComponent,
<<<<<<< HEAD
    NewCustomerComponent,
    CustomerAccountsComponent
=======
    NewCustomerComponent
>>>>>>> 892645581ff12c43f5590c01145f00bc9d90886b
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

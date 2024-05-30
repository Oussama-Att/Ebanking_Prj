import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CustomersComponent} from "./customers/customers.component";
import {AccountsComponent} from "./accounts/accounts.component";
import {NewCustomerComponent} from "./new-customer/new-customer.component";
<<<<<<< HEAD
import {CustomerAccountsComponent} from "./customer-accounts/customer-accounts.component";
=======
>>>>>>> 892645581ff12c43f5590c01145f00bc9d90886b

const routes: Routes = [
  { path : "customers",component : CustomersComponent},
  { path : "accounts",component : AccountsComponent},
<<<<<<< HEAD
  { path : "new-customer",component : NewCustomerComponent},
  { path : "customer-accounts/:id",component : CustomerAccountsComponent}
=======
  { path : "new-customer",component : NewCustomerComponent}

>>>>>>> 892645581ff12c43f5590c01145f00bc9d90886b
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

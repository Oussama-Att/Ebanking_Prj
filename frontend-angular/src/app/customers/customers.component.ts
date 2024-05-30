import { Component, OnInit } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { CustomerService } from "../services/customer.service";
import {catchError, map, Observable, throwError} from "rxjs";
import { Customer } from "../model/customer.model";
import { FormBuilder, FormGroup } from "@angular/forms";
<<<<<<< HEAD
import {Router} from "@angular/router";
=======
>>>>>>> 892645581ff12c43f5590c01145f00bc9d90886b

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css']
})
export class CustomersComponent implements OnInit {

  customers!: Observable<Array<Customer>>;
  errorMessage!: string;
  searchFormGroup!: FormGroup;

<<<<<<< HEAD
  constructor(private customerService: CustomerService, private fb: FormBuilder,private router : Router) {}
=======
  constructor(private customerService: CustomerService, private fb: FormBuilder) {}
>>>>>>> 892645581ff12c43f5590c01145f00bc9d90886b

  ngOnInit(): void {
    this.searchFormGroup = this.fb.group({
      keyword: this.fb.control("")
    });

    this.customers = this.customerService.getCustomers().pipe(
      catchError(err => {
        this.errorMessage = err.message;
        return throwError(err);
      }),
    );
  }

  handleSearchCustomers(): void {
    let kw = this.searchFormGroup.value.keyword;
    this.customers = this.customerService.searchCustomers(kw).pipe(
      catchError(err => {
        this.errorMessage = err.message;
        return throwError(err);
      }),
    );
  }

  handleDeleteCustomer(c: Customer) {
    let conf = confirm("Are you sure?.")
    if(!conf) return;
    this.customerService.deleteCustomers(c.id).subscribe({
      next : (resp) => {
        this.customers = this.customers.pipe(
          map(data =>{
            let index = data.indexOf(c);
            data.slice(index,1)
            return data;
          })
        )
       },
      error : err => {
        console.log(err);
      }
    });
  }
<<<<<<< HEAD

  handleCustomerAccount(customer: Customer) {
    this.router.navigateByUrl("/customer-accounts/"+customer.id,{state : customer})
  }
=======
>>>>>>> 892645581ff12c43f5590c01145f00bc9d90886b
}

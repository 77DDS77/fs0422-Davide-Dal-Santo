import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerService } from 'src/app/services/customer.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Customer } from 'src/app/models/customer';
import { Address } from 'src/app/models/address';
import { ComuneService } from 'src/app/services/comune.service';
import { Comune } from 'src/app/models/comune';

@Component({
  selector: 'app-new-customer',
  templateUrl: './new-customer.component.html',
  styleUrls: ['./new-customer.component.scss'],
})
export class NewCustomerComponent implements OnInit {
  form!: FormGroup;
  legaleForm!: FormGroup;
  operativaForm!: FormGroup;
  submitBtn!: HTMLButtonElement;
  formIsValid!: boolean;
  operativaLegale: boolean = false;

  constructor(
    private custSvc: CustomerService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.legaleForm = new FormGroup({
      via: new FormControl(null),
      civico: new FormControl(null),
      cap: new FormControl(null),
      comune: new FormControl(null),
      provincia: new FormControl(null),
    });

    this.operativaForm = new FormGroup({
      via: new FormControl(null),
      civico: new FormControl(null),
      cap: new FormControl(null),
      comune: new FormControl(null),
      provincia: new FormControl(null),
    });

    this.form = new FormGroup({
      ragioneSociale: new FormControl(null),
      partitaIVA: new FormControl(null),
      email: new FormControl(null),
      fatturatoAnnuale: new FormControl(null),
      pec: new FormControl(null),
      telefono: new FormControl(null),
      emailContatto: new FormControl(null),
      nomeContatto: new FormControl(null),
      cognomeContatto: new FormControl(null),
      telefonoContatto: new FormControl(null),
      sedeLegale: this.legaleForm,
      sedeOperativa: this.operativaForm,
      tipoAzienda: new FormControl('SRL'),
    });

    this.operativaForm.disable();
  }

  submit(){
    this.custSvc
    .postNewCustomer(
      new Customer(
        this.form.value.ragioneSociale,
        this.form.value.partitaIVA,
        this.form.value.email,
        this.form.value.fatturatoAnnuale,
        this.form.value.pec,
        this.form.value.telefono,
        this.form.value.emailContatto,
        this.form.value.nomeContatto,
        this.form.value.cognomeContatto,
        this.form.value.telefonoContatto,
        new Address(
          this.form.value.sedeLegale.via,
          this.form.value.sedeLegale.civico,
          this.form.value.sedeLegale.cap,
          this.form.value.sedeLegale.comune,
        ),
        this.operativaLegale
          ? new Address(
              this.form.value.sedeOperativa.via,
              this.form.value.sedeOperativa.civico,
              this.form.value.sedeOperativa.cap,
              this.form.value.sedeLegale.comune,
            )
          : null,

        this.form.value.tipoAzienda
      )
    )
    .subscribe((res) => {
      this.router.navigate(['/customers']);
    });
  }

  updateOperativa() {
    this.operativaLegale = !this.operativaLegale;

    this.operativaForm.reset();

    if (this.operativaLegale) {
      this.operativaForm.enable();
    } else {
      this.operativaForm.disable();
    }
  }
}

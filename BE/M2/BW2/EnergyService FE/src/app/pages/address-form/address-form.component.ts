import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Comune } from 'src/app/models/comune';
import { Provincia } from 'src/app/models/provincia';
import { ComuneService } from 'src/app/services/comune.service';
import { ProvinciaService } from 'src/app/services/provincia.service';

@Component({
  selector: 'app-address-form',
  templateUrl: './address-form.component.html',
  styleUrls: ['./address-form.component.scss'],
})
export class AddressFormComponent implements OnInit {
  @Input() addressForm!: FormGroup;
  provincie!: Provincia[];
  comuni!: Comune[];

  constructor(private provSvc: ProvinciaService, private comunSvc: ComuneService) {}

  ngOnInit(): void {
    this.getAllProvincie();

    this.addressForm.controls['comune'].disable();
  }

  submit() {}

  getAllProvincie() {
    this.provSvc.getAllProvincie().subscribe((prov) => (this.provincie = prov));
  }

  getComuni(provincia : Provincia){
    this.comunSvc.getComuniByProv(provincia).subscribe((comu)=>(this.comuni = comu))
  }

  updateComuni() {
    this.addressForm.controls['comune'].reset();

    if (this.addressForm.controls['provincia'].value != "null") {
      this.addressForm.controls['comune'].enable();

      this.getComuni(this.addressForm.controls['provincia'].value)

    } else {
      this.addressForm.controls['comune'].disable();

    }
  }
}

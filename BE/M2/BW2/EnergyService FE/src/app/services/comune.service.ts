import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { apiUrl } from 'src/environments/environment';
import { Comune } from '../models/comune';
import { Provincia } from '../models/provincia';

@Injectable({
  providedIn: 'root'
})
export class ComuneService {

  constructor(private http:HttpClient) { }

  getComuniByProv(provincia: Provincia){
    return this.http.get<Comune[]>(apiUrl + '/comuni/provincia?provincia=' + provincia);
  }

  getComuneByName(comune:String){
    return this.http.get<Comune>(apiUrl + '/comuni/comune?comune=' + comune);
  }
}

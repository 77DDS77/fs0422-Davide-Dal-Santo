import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Provincia } from '../models/provincia';
import { apiUrl } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProvinciaService {

  constructor(private http:HttpClient) { }

  getAllProvincie():Observable<Provincia[]> {
    return this.http.get<Provincia[]>(apiUrl + '/provincie');
  }
}

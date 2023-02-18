import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Medico } from '../models/Medico';

const httpOptions : any    = {
  headers: new HttpHeaders({
    // 'Content-Type':  'application/json',
    'Access-Control-Allow-Headers': 'Content-Type',
    'Access-Control-Allow-Methods': 'GET',
    'Access-Control-Allow-Origin': '*'
  })
};

@Injectable({
  providedIn: 'root'
})
export class MedicoService {

  constructor(private hC: HttpClient) { }

  getAllMedici(){
    return this.hC.get<Medico[]>('http://localhost:8080/segretaria/medico/list');
  }
}

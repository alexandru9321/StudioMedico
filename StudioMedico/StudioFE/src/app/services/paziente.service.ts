import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Paziente } from '../models/Paziente';
import { Obj } from '@popperjs/core';


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
export class PazienteService {

  constructor(private hC: HttpClient) { }


  getAllPazienti() {
    return this.hC.get<Paziente[]>('http://localhost:8080/segretaria/paziente/list');
  }

  findByNomeECognome(nome: string, cognome: string){
    return this.hC.get<Paziente[]>(`http://localhost:8080/segretaria/paziente/nomeECognome?nome=${nome}&cognome=${cognome}`);
  }

  insertPaziente(paziente: Paziente): Observable<Object>{
    const headers = {'Content-Type': 'application/json', 'Access-Control-Allow-Origin' : '*', };
    let a = JSON.stringify(paziente);
  console.log(a);  
  return this.hC.post(`http://localhost:8080/segretaria/paziente/insert`, a,  {headers,  observe: 'response',
  params: {},
  reportProgress: false,
  responseType: 'json',
  withCredentials: false} );
}
}

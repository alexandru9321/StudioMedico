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

  // findByNomeECognome(nome: string, cognome: string){
  //   return this.hC.get<Paziente[]>(`http://localhost:8080/segretaria/paziente/nomeECognome?nome=${nome}&cognome=${cognome}`);
  // }

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

 delete(paziente: Paziente): Observable<Paziente> {
  return this.hC.delete<Paziente>('http://localhost:8080/segretaria/paziente/delete', { body: paziente });
}

// Ricerca per un parametro
trovaPerNome(nome: string): Observable<Paziente[]> {
  return this.hC.get<Paziente[]>(`http://localhost:8080/segretaria/pazienti/cerca-per-nome?nome=${nome}`);
}

trovaPerCognome(cognome: string): Observable<Paziente[]> {
  return this.hC.get<Paziente[]>(`http://localhost:8080/segretaria/pazienti/cerca-per-cognome?cognome=${cognome}`);
}

trovaPerCodiceFiscale(codiceFiscale: string): Observable<Paziente[]> {
  return this.hC.get<Paziente[]>(`http://localhost:8080/segretaria/pazienti/cerca-per-codice-fiscale?codiceFiscale=${codiceFiscale}`);
}

trovaPerIdMedico(idMedico: number): Observable<Paziente[]> {
  return this.hC.get<Paziente[]>(`http://localhost:8080/segretaria/pazienti/cerca-per-medico?idMedico=${idMedico}`);
}

// Ricerca per due parametri
trovaPerNomeECognome(nome: string, cognome: string): Observable<Paziente[]> {
  return this.hC.get<Paziente[]>(`http://localhost:8080/segretaria/pazienti/cerca-per-nome-e-cognome?nome=${nome}&cognome=${cognome}`);
}

trovaPerNomeECodiceFiscale(nome: string, codiceFiscale: string): Observable<Paziente[]> {
  return this.hC.get<Paziente[]>(`http://localhost:8080/segretaria/pazienti/cerca-per-nome-e-codice-fiscale?nome=${nome}&codiceFiscale=${codiceFiscale}`);
}

trovaPerNomeEIdMedico(nome: string, idMedico: number): Observable<Paziente[]> {
  return this.hC.get<Paziente[]>(`http://localhost:8080/segretaria/pazienti/cerca-per-nome-e-id-medico?nome=${nome}&idMedico=${idMedico}`);
}

trovaPerCognomeECodiceFiscale(cognome: string, codiceFiscale: string): Observable<Paziente[]> {
  return this.hC.get<Paziente[]>(`http://localhost:8080/segretaria/pazienti/cerca-per-cognome-e-codice-fiscale?cognome=${cognome}&codiceFiscale=${codiceFiscale}`);
}

trovaPerCognomeEIdMedico(cognome: string, idMedico: number): Observable<Paziente[]> {
  return this.hC.get<Paziente[]>(`http://localhost:8080/segretaria/pazienti/cerca-per-cognome-e-id-medico?cognome=${cognome}&idMedico=${idMedico}`);
}



}

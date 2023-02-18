import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Prenotazione } from '../models/Prenotazione';

@Injectable({
  providedIn: 'root'
})
export class PrenotazioneService {

  constructor(private hc: HttpClient) { }


  getAllPrenotazioni(){
    return this.hc.get<Prenotazione[]>('http://localhost:8080/segretaria/prenotazione/list')
  }
}

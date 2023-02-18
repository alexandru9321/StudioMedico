import { Component, OnInit } from '@angular/core';
import { Prenotazione } from 'src/app/models/Prenotazione';
import { PrenotazioneService } from 'src/app/services/prenotazione.service';

@Component({
  selector: 'app-insert-prenotazione',
  templateUrl: './insert-prenotazione.component.html',
  styleUrls: ['./insert-prenotazione.component.css']
})
export class InsertPrenotazioneComponent implements OnInit {

  prenotazioni!: Prenotazione[];

constructor(private prenotazioniService: PrenotazioneService) {}

ngOnInit(): void {
  
}



}

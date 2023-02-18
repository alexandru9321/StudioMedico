import { Component, OnInit } from '@angular/core';
import { Prenotazione } from 'src/app/models/Prenotazione';
import { PrenotazioneService } from 'src/app/services/prenotazione.service';

@Component({
  selector: 'app-lista-prenotazioni',
  templateUrl: './lista-prenotazioni.component.html',
  styleUrls: ['./lista-prenotazioni.component.css']
})
export class ListaPrenotazioniComponent implements OnInit {

  prenotazioni!: Prenotazione[];

constructor(private prenotazioniService: PrenotazioneService) {}

ngOnInit(): void {
  this.getAllPrenotazioni();
}

getAllPrenotazioni(){
  this.prenotazioniService.getAllPrenotazioni().subscribe( response => {
    console.log(response)
    this.prenotazioni = response;
  }
  );
}

// deletePaziente(prenotazione: Prenotazione) {
//   this.prenotazioniService.delete(paziente).subscribe(
//     () => {
//       // Rimuovi il paziente dalla lista
//       const index = this.pazientiList.indexOf(paziente);
//       if (index > -1) {
//         this.pazientiList.splice(index, 1);
//       }
//     },
//     error => console.error(error)
//   );
// }

}

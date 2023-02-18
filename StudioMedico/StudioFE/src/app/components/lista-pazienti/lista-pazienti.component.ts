import { Component, OnInit } from '@angular/core';
import { Paziente } from 'src/app/models/Paziente';
import { PazienteService } from 'src/app/services/paziente.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-lista-pazienti',
  templateUrl: './lista-pazienti.component.html',
  styleUrls: ['./lista-pazienti.component.css']
})
export class ListaPazientiComponent implements OnInit {

pazientiList!: Paziente[];

constructor(private pazienteService: PazienteService, private location: Location) {}

  ngOnInit(): void {
    this.getAllPazienti();
  }

  getAllPazienti(){
    this.pazienteService.getAllPazienti().subscribe(
      response => {
        console.log(response);
        this.pazientiList = response;
      }
    );
  }
  goBack(): void {
    this.location.back();
  }

  // deletePaziente(paziente: Paziente) {
  //   console.log(paziente.nome)
  //   this.pazienteService.delete(paziente).subscribe(
  //     response => {
  //       console.log("L'utente " + paziente.nome + "e stato eliminato!");
  //     }
  //   )
  // }

  deletePaziente(paziente: Paziente) {
    this.pazienteService.delete(paziente).subscribe(
      () => {
        // Rimuovi il paziente dalla lista
        const index = this.pazientiList.indexOf(paziente);
        if (index > -1) {
          this.pazientiList.splice(index, 1);
        }
      },
      error => console.error(error)
    );
  }
}

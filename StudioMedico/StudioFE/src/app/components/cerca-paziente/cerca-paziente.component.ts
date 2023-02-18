import { Component, OnInit } from '@angular/core';
import { Medico } from 'src/app/models/Medico';
import { Paziente } from 'src/app/models/Paziente';
import { MedicoService } from 'src/app/services/medico.service';
import { PazienteService } from 'src/app/services/paziente.service';

@Component({
  selector: 'app-cerca-paziente',
  templateUrl: './cerca-paziente.component.html',
  styleUrls: ['./cerca-paziente.component.css']
})
export class CercaPazienteComponent implements OnInit {

  show: boolean = false;

  nome: string = " ";
  idMedico!: number;
  cognome: string = " ";
  codiceFiscale: string = " ";
  pazienti!: Paziente[];
  mediciList!: Medico[];
  empty: boolean = false;

  constructor(private pazienteService: PazienteService,
    private medicoService: MedicoService) { }

  ngOnInit(): void {
    this.getAllMedici();
  }

  getAllMedici() {
    this.medicoService.getAllMedici().subscribe(result => {
      this.mediciList = result;
    })
  }

  getAllPazienti() {
    this.pazienteService.getAllPazienti().subscribe(result => {
      this.pazienti = result;
    })
  }

  cercaPerNome() {
    this.pazienteService.trovaPerNome(this.nome.trim()).subscribe(result => {
      this.pazienti = result;
    });
  }

  cercaPerCognome() {
    this.pazienteService.trovaPerCognome(this.cognome.trim()).subscribe(result => {
      this.pazienti = result;
    });
  }

  findByNomeECognome() {
    this.pazienteService.trovaPerNomeECognome(this.nome.trim(), this.cognome.trim()).subscribe(response => {
      this.pazienti = response;
    },
      error => console.log(error));
  }


  isNullOrEmpty(value: any): boolean {
    return value === '' || value === 0 || value === null;
  }


  submitByAll() {

    if (this.isNullOrEmpty(this.nome.trim()) && this.isNullOrEmpty(this.cognome.trim())) {
      console.log("Vuoto");
      this.empty = true;
      this.getAllPazienti();
      this.show = true;
    } else if (this.isNullOrEmpty(this.nome.trim())) {
      console.log("Cognome" + this.cognome)
      this.cercaPerCognome();
      this.show = true;
    } else if (this.isNullOrEmpty(this.cognome.trim())) {
      console.log("Nome" + this.nome)
      this.cercaPerNome();
      this.show = true;
    } else {
      console.log("Nome e Cognome" + this.nome + this.cognome)
      this.findByNomeECognome();
      this.show = true;
    }
  }


}






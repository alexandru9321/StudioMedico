import { Component, OnInit } from '@angular/core';
import { Paziente } from 'src/app/models/Paziente';
import { PazienteService } from 'src/app/services/paziente.service';

@Component({
  selector: 'app-cerca-paziente',
  templateUrl: './cerca-paziente.component.html',
  styleUrls: ['./cerca-paziente.component.css']
})
export class CercaPazienteComponent implements OnInit {

  show: boolean = false;
  nome: string = " ";
  cognome: string = " ";
  pazientiList!: Paziente[];

  constructor(private pazienteService: PazienteService) {}

  ngOnInit(): void {
  }



  findByNomeECognome(){
    this.pazienteService.findByNomeECognome(this.nome, this.cognome).subscribe( response => {
      console.log(this.nome);
      console.log(this.cognome);
      console.log(response);
      this.pazientiList = response;
    },
    error => console.log(error));
  }

  submitByNomeECognome(){
    this.show = true;
    this.findByNomeECognome();
    console.log(this.nome);
    console.log(this.cognome);
  }

}

import { Component, OnInit } from '@angular/core';
import { Medico } from 'src/app/models/Medico';
import { Paziente } from 'src/app/models/Paziente';
import { MedicoService } from 'src/app/services/medico.service';
import { PazienteService } from 'src/app/services/paziente.service';

@Component({
  selector: 'app-insert-paziente',
  templateUrl: './insert-paziente.component.html',
  styleUrls: ['./insert-paziente.component.css']
})
export class InsertPazienteComponent implements OnInit {

  paziente: Paziente = new Paziente();
  mediciList!: Medico[];

  constructor(private pazienteService: PazienteService,
    private medicoService: MedicoService) {}


  ngOnInit(): void {
    this.getAllMedici();
  }

  trimLeftInputValue(input: string): string {
    return input.trimLeft();
  }
  

  submitInsert(){
    console.log(this.paziente);
    this.InsertPaziente();
  }

  getAllMedici(){
    this.medicoService.getAllMedici().subscribe(
      response => {
        console.log(response);
        this.mediciList = response;
        console.log("getAllMedici called");
      }
    );
  }

  InsertPaziente(){
    this.pazienteService.insertPaziente(this.paziente).subscribe(data => {
      console.log(data);
      console.log(this.paziente.nome);
    },
    error => console.log(error));
  }

}

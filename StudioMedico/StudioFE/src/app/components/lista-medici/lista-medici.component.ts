import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Medico } from 'src/app/models/Medico';
import { MedicoService } from 'src/app/services/medico.service';

@Component({
  selector: 'app-lista-medici',
  templateUrl: './lista-medici.component.html',
  styleUrls: ['./lista-medici.component.css']
})
export class ListaMediciComponent implements OnInit {

  mediciList!: Medico[];

  constructor(private medicoService: MedicoService, private location: Location) {}

  ngOnInit(): void {
    this.getAllMedici();
  }

  getAllMedici(){
    this.medicoService.getAllMedici().subscribe(
      response => {
        console.log(response);
        this.mediciList = response;
      }
    );
  }

  goBack(): void {
    this.location.back();
  }
}

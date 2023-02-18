import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CercaPazienteComponent } from './components/cerca-paziente/cerca-paziente.component';
import { HomeComponent } from './components/home/home.component';
import { InsertPazienteComponent } from './components/insert-paziente/insert-paziente.component';
import { ListaMediciComponent } from './components/lista-medici/lista-medici.component';
import { ListaPazientiComponent } from './components/lista-pazienti/lista-pazienti.component';
import { SegreteriaComponent } from './components/segreteria/segreteria.component';
import { MedicoComponent } from './medico/medico.component';
import { PazienteComponent } from './paziente/paziente.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'segretaria', component: SegreteriaComponent },
  { path: 'paziente', component: PazienteComponent },
  { path: 'medico', component: MedicoComponent },
  { path: 'listaPazienti', component: ListaPazientiComponent },
  { path: 'listaMedici', component: ListaMediciComponent },
  { path: 'insertPaziente', component: InsertPazienteComponent },
  { path: 'searchPaziente', component: CercaPazienteComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { SegreteriaComponent } from './components/segreteria/segreteria.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MedicoComponent } from './medico/medico.component';
import { PazienteComponent } from './paziente/paziente.component';
import { ListaPazientiComponent } from './components/lista-pazienti/lista-pazienti.component';
import { HttpClientModule } from '@angular/common/http';
import { InsertPazienteComponent } from './components/insert-paziente/insert-paziente.component';
import { ListaMediciComponent } from './components/lista-medici/lista-medici.component';
import { CercaPazienteComponent } from './components/cerca-paziente/cerca-paziente.component';
import { FormsModule } from '@angular/forms';
import { HomeComponent } from './components/home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    SegreteriaComponent,
    MedicoComponent,
    PazienteComponent,
    ListaPazientiComponent,
    InsertPazienteComponent,
    ListaMediciComponent,
    CercaPazienteComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

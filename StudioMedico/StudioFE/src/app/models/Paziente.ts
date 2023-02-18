import { Medico } from "./Medico";

export class Paziente{
    public id?: number;
    public nome?: string;
    public cognome?: string;
    public telefono?: string;
    public email?: string;
    public dataNascita?: Date;
    public codiceFiscale?: string;
    public medico?: Medico;

}
  
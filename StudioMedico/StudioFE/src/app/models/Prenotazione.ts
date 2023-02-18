import { Medico } from "./Medico";
import { Paziente } from "./Paziente";

export class Prenotazione{
    public id?: number;
    public dataPrenotazione?: Date;
    public oraPrenotazione?: Date;
    public statusPrenotazione?: string;
    public note?: string;
    public paziente?: Paziente;
    public medico?: Medico;
}
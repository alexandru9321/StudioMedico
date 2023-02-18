import { Medico } from "./Medico";

export class Segreteria{
    public id?: number;
    public nome?: string;
    public cognome?: string;
    public telefono?: number;
    public emailSegretaria?: string;
    public giorniLavorativi?: number;
    public medico?: Medico
}
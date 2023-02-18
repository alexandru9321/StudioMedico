package com.StudioMedico.service;

import com.StudioMedico.entity.Medico;
import com.StudioMedico.entity.Paziente;
import com.StudioMedico.entity.Prenotazione;
import com.StudioMedico.repository.PazienteRepository;
import com.StudioMedico.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PazienteService {

    @Autowired
    private PazienteRepository pazienteRepository;

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private SegretariaService segretariaService;

    public List<Paziente> findPazientiByMedico(Medico medico) {
        List<Paziente> pazientiList = pazienteRepository.findByMedico(medico);
        return pazientiList;
    }

    public void deleteById(Paziente paziente){
        int id = paziente.getId();
        pazienteRepository.deleteById(id);
    }


    public Prenotazione richiediPrenotazione(int idPaziente, LocalDateTime dataOraPrenotazione) {
        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setPaziente(pazienteRepository.findById(idPaziente));
        LocalDate data = dataOraPrenotazione.toLocalDate();
        LocalDateTime ora = dataOraPrenotazione;
        prenotazione.setDataPrenotazione(data);
        prenotazione.setOraPrenotazione(ora);
        return prenotazione;
    }


    // Ricerca per un parametro
    public List<Paziente> trovaPerNome(String nome) {
        return pazienteRepository.findByNome(nome);
    }

    public List<Paziente> trovaPerCognome(String cognome) {
        return pazienteRepository.findByCognome(cognome);
    }

    public List<Paziente> trovaPerCodiceFiscale(String codiceFiscale) {
        return pazienteRepository.findByCodiceFiscale(codiceFiscale);
    }

    public List<Paziente> trovaPerIdMedico(int idMedico) {
        return pazienteRepository.findByMedicoId(idMedico);
    }

    // Ricerca per due parametri
    public List<Paziente> trovaPerNomeECognome(String nome, String cognome) {
        return pazienteRepository.findByNomeAndCognome(nome, cognome);
    }

    public List<Paziente> trovaPerNomeECodiceFiscale(String nome, String codiceFiscale) {
        return pazienteRepository.findByNomeAndCodiceFiscale(nome, codiceFiscale);
    }

    public List<Paziente> trovaPerNomeEIdMedico(String nome, int idMedico) {
        return pazienteRepository.findByNomeAndMedicoId(nome, idMedico);
    }

    public List<Paziente> trovaPerCognomeECodiceFiscale(String cognome, String codiceFiscale) {
        return pazienteRepository.findByCognomeAndCodiceFiscale(cognome, codiceFiscale);
    }

    public List<Paziente> trovaPerCognomeEIdMedico(String cognome, int idMedico) {
        return pazienteRepository.findByCognomeAndMedicoId(cognome, idMedico);
    }

    public List<Paziente> trovaPerCodiceFiscaleEIdMedico(String codiceFiscale, int idMedico) {
        return pazienteRepository.findByCodiceFiscaleAndMedicoId(codiceFiscale, idMedico);
    }

    // Ricerca per tre parametri
    public List<Paziente> trovaPerNomeECognomeECodiceFiscale(String nome, String cognome, String codiceFiscale) {
        return pazienteRepository.findByNomeAndCognomeAndCodiceFiscale(nome, cognome, codiceFiscale);
    }

    public List<Paziente> trovaPerNomeECognomeEIdMedico(String nome, String cognome, int idMedico) {
        return pazienteRepository.findByNomeAndCognomeAndMedicoId(nome, cognome, idMedico);
    }

    public List<Paziente> trovaPerNomeECodiceFiscaleEIdMedico(String nome, String codiceFiscale, int idMedico) {
        return pazienteRepository.findByNomeAndCodiceFiscaleAndMedicoId(nome, codiceFiscale, idMedico);
    }

    public List<Paziente> trovaPerCognomeECodiceFiscaleEIdMedico(String cognome, String codiceFiscale, int idMedico) {
        return pazienteRepository.findByCognomeAndCodiceFiscaleAndMedicoId(cognome, codiceFiscale, idMedico);
    }

    // Ricerca per tutti e quattro i parametri
    public List<Paziente> trovaPerNomeECognomeECodiceFiscaleEIdMedico(String nome, String cognome, String codiceFiscale, int idMedico) {
        return pazienteRepository.findByNomeAndCognomeAndCodiceFiscaleAndMedicoId(nome, cognome, codiceFiscale, idMedico);
    }


}

package com.StudioMedico.service;

import com.StudioMedico.entity.Medico;
import com.StudioMedico.entity.Paziente;
import com.StudioMedico.entity.Prenotazione;
import com.StudioMedico.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;


    public List<Prenotazione> findByDataPrenotazione(LocalDate dataPrenotazione) {
        return prenotazioneRepository.findByDataPrenotazione(dataPrenotazione);
    }

    public List<Prenotazione> findByStatusPrenotazione(String statusPrenotazione) {
        return prenotazioneRepository.findByStatusPrenotazione(statusPrenotazione);
    }

    public List<Prenotazione> findByPaziente(Paziente paziente) {
        return prenotazioneRepository.findByPaziente(paziente);
    }

    public List<Prenotazione> findByMedico(Medico medico) {
        return prenotazioneRepository.findByMedico(medico);
    }

    public List<Prenotazione> findByDataPrenotazioneAndStatusPrenotazione(LocalDate dataPrenotazione, String statusPrenotazione) {
        return prenotazioneRepository.findByDataPrenotazioneAndStatusPrenotazione(dataPrenotazione, statusPrenotazione);
    }

    public List<Prenotazione> findByDataPrenotazioneAndPaziente(LocalDate dataPrenotazione, Paziente paziente) {
        return prenotazioneRepository.findByDataPrenotazioneAndPaziente(dataPrenotazione, paziente);
    }

    public List<Prenotazione> findByDataPrenotazioneAndMedico(LocalDate dataPrenotazione, Medico medico) {
        return prenotazioneRepository.findByDataPrenotazioneAndMedico(dataPrenotazione, medico);
    }

    public List<Prenotazione> findByStatusPrenotazioneAndPaziente(String statusPrenotazione, Paziente paziente) {
        return prenotazioneRepository.findByStatusPrenotazioneAndPaziente(statusPrenotazione, paziente);
    }

    public List<Prenotazione> findByStatusPrenotazioneAndMedico(String statusPrenotazione, Medico medico) {
        return prenotazioneRepository.findByStatusPrenotazioneAndMedico(statusPrenotazione, medico);
    }

    public List<Prenotazione> findByPazienteAndMedico(Paziente paziente, Medico medico) {
        return prenotazioneRepository.findByPazienteAndMedico(paziente, medico);
    }

    public List<Prenotazione> findByDataPrenotazioneAndStatusPrenotazioneAndPaziente(LocalDate dataPrenotazione, String statusPrenotazione, Paziente paziente) {
        return prenotazioneRepository.findByDataPrenotazioneAndStatusPrenotazioneAndPaziente(dataPrenotazione, statusPrenotazione, paziente);
    }

    public List<Prenotazione> findByDataPrenotazioneAndStatusPrenotazioneAndMedico(LocalDate dataPrenotazione, String statusPrenotazione, Medico medico) {
        return prenotazioneRepository.findByDataPrenotazioneAndStatusPrenotazioneAndMedico(dataPrenotazione, statusPrenotazione, medico);
    }

    public List<Prenotazione> findByDataPrenotazioneAndPazienteAndMedico(LocalDate dataPrenotazione, Paziente paziente, Medico medico) {
        return prenotazioneRepository.findByDataPrenotazioneAndPazienteAndMedico(dataPrenotazione, paziente, medico);
    }

    public List<Prenotazione> findByStatusPrenotazioneAndPazienteAndMedico(String statusPrenotazione, Paziente paziente, Medico medico) {
        return prenotazioneRepository.findByStatusPrenotazioneAndPazienteAndMedico(statusPrenotazione, paziente, medico);
    }

    public List<Prenotazione> findByDataPrenotazioneAndStatusPrenotazioneAndPazienteAndMedico(LocalDate dataPrenotazione, String statusPrenotazione, Paziente paziente, Medico medico) {
        return prenotazioneRepository.findByDataPrenotazioneAndStatusPrenotazioneAndPazienteAndMedico(dataPrenotazione, statusPrenotazione, paziente, medico);
    }
}

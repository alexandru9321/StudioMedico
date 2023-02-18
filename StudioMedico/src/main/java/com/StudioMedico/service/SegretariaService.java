package com.StudioMedico.service;

import com.StudioMedico.entity.Medico;
import com.StudioMedico.entity.Paziente;
import com.StudioMedico.entity.Prenotazione;
import com.StudioMedico.repository.MedicoRepository;
import com.StudioMedico.repository.PazienteRepository;
import com.StudioMedico.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class SegretariaService {

    @Autowired
    private PazienteRepository pazienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Transactional
    public void savePaziente(Paziente paziente){
        pazienteRepository.save(paziente);
    }

    public List<Paziente> getAllPazienti(){
        List<Paziente> pazientiList = pazienteRepository.findAll();
        return pazientiList;
    }

    public List<Medico> getAllMedici(){
        List<Medico> medicoList = medicoRepository.findAll();
        return medicoList;
    }

    public Paziente getById (int id) {
        return pazienteRepository.findById(id);
    }

    public void delete (Paziente paziente){
        pazienteRepository.delete(paziente);
    }

    public void savePrenotazione (Prenotazione prenotazione) {prenotazioneRepository.save(prenotazione); }

    public List<Prenotazione> getAllPrenotazione(){
        List<Prenotazione> prenotazioniList = prenotazioneRepository.findAll();
        return prenotazioniList;
    }

    public List<Paziente> findByNomeECognome(String nome, String cognome){
        return pazienteRepository.findByNomeContainsAndCognomeContains(nome, cognome);
    }
}


package com.StudioMedico.repository;

import com.StudioMedico.entity.Medico;
import com.StudioMedico.entity.Paziente;
import com.StudioMedico.entity.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer> {

    List<Prenotazione> findByDataPrenotazione(LocalDate dataPrenotazione);

    List<Prenotazione> findByStatusPrenotazione(String statusPrenotazione);

    List<Prenotazione> findByPaziente(Paziente paziente);

    List<Prenotazione> findByMedico(Medico medico);



    List<Prenotazione> findByDataPrenotazioneAndStatusPrenotazione(LocalDate dataPrenotazione, String statusPrenotazione);

    List<Prenotazione> findByDataPrenotazioneAndPaziente(LocalDate dataPrenotazione, Paziente paziente);

    List<Prenotazione> findByDataPrenotazioneAndMedico(LocalDate dataPrenotazione, Medico medico);

    List<Prenotazione> findByStatusPrenotazioneAndPaziente(String statusPrenotazione, Paziente paziente);

    List<Prenotazione> findByStatusPrenotazioneAndMedico(String statusPrenotazione, Medico medico);

    List<Prenotazione> findByPazienteAndMedico(Paziente paziente, Medico medico);



    List<Prenotazione> findByDataPrenotazioneAndStatusPrenotazioneAndPaziente(LocalDate dataPrenotazione, String statusPrenotazione, Paziente paziente);

    List<Prenotazione> findByDataPrenotazioneAndStatusPrenotazioneAndMedico(LocalDate dataPrenotazione, String statusPrenotazione, Medico medico);

    List<Prenotazione> findByDataPrenotazioneAndPazienteAndMedico(LocalDate dataPrenotazione, Paziente paziente, Medico medico);

    List<Prenotazione> findByStatusPrenotazioneAndPazienteAndMedico(String statusPrenotazione, Paziente paziente, Medico medico);



    List<Prenotazione> findByDataPrenotazioneAndStatusPrenotazioneAndPazienteAndMedico(LocalDate dataPrenotazione, String statusPrenotazione, Paziente paziente, Medico medico);

}

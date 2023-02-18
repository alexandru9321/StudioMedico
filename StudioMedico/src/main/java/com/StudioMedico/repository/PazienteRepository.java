package com.StudioMedico.repository;

import com.StudioMedico.entity.Medico;
import com.StudioMedico.entity.Paziente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PazienteRepository extends JpaRepository<Paziente, Integer> {

  List<Paziente> findByMedico(Medico medico);
  Paziente findById(int idPaziente);
  List<Paziente> findByNomeContainsAndCognomeContains(String nome, String cognome);

//  Optional<List<Book>> findByTitoloContainsAndAutoreContains(String titolo, String autore);





    // Ricerca per un parametro
    List<Paziente> findByNome(String nome);
    List<Paziente> findByCognome(String cognome);
    List<Paziente> findByCodiceFiscale(String codiceFiscale);
    List<Paziente> findByMedicoId(int idMedico);

    // Ricerca per due parametri
    List<Paziente> findByNomeAndCognome(String nome, String cognome);
    List<Paziente> findByNomeAndCodiceFiscale(String nome, String codiceFiscale);
    List<Paziente> findByNomeAndMedicoId(String nome, int idMedico);
    List<Paziente> findByCognomeAndCodiceFiscale(String cognome, String codiceFiscale);
    List<Paziente> findByCognomeAndMedicoId(String cognome, int idMedico);
    List<Paziente> findByCodiceFiscaleAndMedicoId(String codiceFiscale, int idMedico);

    // Ricerca per tre parametri
    List<Paziente> findByNomeAndCognomeAndCodiceFiscale(String nome, String cognome, String codiceFiscale);
    List<Paziente> findByNomeAndCognomeAndMedicoId(String nome, String cognome, int idMedico);
    List<Paziente> findByNomeAndCodiceFiscaleAndMedicoId(String nome, String codiceFiscale, int idMedico);
    List<Paziente> findByCognomeAndCodiceFiscaleAndMedicoId(String cognome, String codiceFiscale, int idMedico);

    // Ricerca per tutti e quattro i parametri
    List<Paziente> findByNomeAndCognomeAndCodiceFiscaleAndMedicoId(String nome, String cognome, String codiceFiscale, int idMedico);



}

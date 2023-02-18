package com.StudioMedico.controller;

import com.StudioMedico.entity.Medico;
import com.StudioMedico.entity.Paziente;
import com.StudioMedico.entity.Prenotazione;
import com.StudioMedico.repository.PrenotazioneRepository;
import com.StudioMedico.service.PazienteService;
import com.StudioMedico.service.PrenotazioneService;
import com.StudioMedico.service.SegretariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/segretaria")
@CrossOrigin(origins = "http://localhost:4200")
public class SegretariaController {

    @Autowired
    private SegretariaService segretariaService;

    @Autowired
    private PrenotazioneService prenotazioneService;

    @Autowired
    private PazienteService pazienteService;


    @PostMapping("/paziente/insert")
    public ResponseEntity<Paziente> savePaziente(@RequestBody Paziente paziente) {
          segretariaService.savePaziente(paziente);
          System.out.println("Paziente " + paziente.getId() + paziente.getNome() + paziente.getCognome()    +  " inserito");
          return new ResponseEntity<Paziente>(paziente, HttpStatus.OK);
    }

    @GetMapping("/paziente/list")
    public ResponseEntity<List<Paziente>> findAllPazienti(){
        List<Paziente> pazientiList = segretariaService.getAllPazienti();
        return new ResponseEntity<List<Paziente>>(pazientiList, HttpStatus.OK);
    }

    @GetMapping("/medico/list")
    public ResponseEntity<List<Medico>> findAllMedici(){
        List<Medico> mediciList = segretariaService.getAllMedici();
        return new ResponseEntity<List<Medico>>(mediciList, HttpStatus.OK);
    }

    @GetMapping("/paziente/{id}")
    public ResponseEntity<Paziente> findById(@PathVariable("id") int id){
        Paziente paziente = segretariaService.getById(id);
        return new ResponseEntity<Paziente>(paziente, HttpStatus.OK);
    }

    @DeleteMapping("/paziente/delete")
    public ResponseEntity<Paziente> deletePaziente(@RequestBody Paziente paziente) {
        segretariaService.delete(paziente);
        return new ResponseEntity<Paziente>(paziente, HttpStatus.OK);
    }

    @GetMapping("/prenotazione/list")
    public ResponseEntity<List<Prenotazione>> findAllPrenotazioni(){
        List<Prenotazione> prenotazioniList = segretariaService.getAllPrenotazione();
        return new ResponseEntity<List<Prenotazione>>(prenotazioniList, HttpStatus.OK);
    }

    @PostMapping("prenotazione/insert")
    public ResponseEntity<Prenotazione> savePrenotazione(@RequestBody Prenotazione prenotazione) {
        segretariaService.savePrenotazione(prenotazione);
        return new ResponseEntity<Prenotazione>(prenotazione, HttpStatus.OK);
    }

    @GetMapping("/paziente/nomeECognome")
    public ResponseEntity<List<Paziente>> findByNomeECognome(@RequestParam (value = "nome", required = true) String nome,
                                                             @RequestParam (value = "cognome", required = true) String cognome){
        List<Paziente> pazientiList = segretariaService.findByNomeECognome(nome, cognome);
        return new ResponseEntity<List<Paziente>>(pazientiList, HttpStatus.OK);
    }




    // RICERCA COMPLETA PRENOTAZIONE

    @GetMapping("/byDataPrenotazione")
    public ResponseEntity<List<Prenotazione>> getPrenotazioniByDataPrenotazione(@RequestParam("dataPrenotazione") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataPrenotazione) {
        List<Prenotazione> prenotazioni = prenotazioneService.findByDataPrenotazione(dataPrenotazione);
        return ResponseEntity.ok().body(prenotazioni);
    }

    @GetMapping("/byStatusPrenotazione")
    public ResponseEntity<List<Prenotazione>> getPrenotazioniByStatusPrenotazione(@RequestParam("statusPrenotazione") String statusPrenotazione) {
        List<Prenotazione> prenotazioni = prenotazioneService.findByStatusPrenotazione(statusPrenotazione);
        return ResponseEntity.ok().body(prenotazioni);
    }

    @GetMapping("/byPaziente")
    public ResponseEntity<List<Prenotazione>> getPrenotazioniByPaziente(@RequestParam("idPaziente") int idPaziente) {
        Paziente paziente = new Paziente();
        paziente.setId(idPaziente);
        List<Prenotazione> prenotazioni = prenotazioneService.findByPaziente(paziente);
        return ResponseEntity.ok().body(prenotazioni);
    }

    @GetMapping("/byMedico")
    public ResponseEntity<List<Prenotazione>> getPrenotazioniByMedico(@RequestParam("idMedico") int idMedico) {
        Medico medico = new Medico();
        medico.setId(idMedico);
        List<Prenotazione> prenotazioni = prenotazioneService.findByMedico(medico);
        return ResponseEntity.ok().body(prenotazioni);
    }

    @GetMapping("/byDataPrenotazioneAndStatusPrenotazione")
    public ResponseEntity<List<Prenotazione>> getPrenotazioniByDataPrenotazioneAndStatusPrenotazione(@RequestParam("dataPrenotazione") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataPrenotazione, @RequestParam("statusPrenotazione") String statusPrenotazione) {
        List<Prenotazione> prenotazioni = prenotazioneService.findByDataPrenotazioneAndStatusPrenotazione(dataPrenotazione, statusPrenotazione);
        return ResponseEntity.ok().body(prenotazioni);
    }

    @GetMapping("/byDataPrenotazioneAndPaziente")
    public ResponseEntity<List<Prenotazione>> getPrenotazioniByDataPrenotazioneAndPaziente(@RequestParam("dataPrenotazione") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataPrenotazione, @RequestParam("idPaziente") int idPaziente) {
        Paziente paziente = new Paziente();
        paziente.setId(idPaziente);
        List<Prenotazione> prenotazioni = prenotazioneService.findByDataPrenotazioneAndPaziente(dataPrenotazione, paziente);
        return ResponseEntity.ok().body(prenotazioni);
    }


    //    RICERCA COMPLETA PAZIENTI

    // Ricerca per un parametro
    @GetMapping("/pazienti/cerca-per-nome")
    public ResponseEntity<List<Paziente>> trovaPerNome(@RequestParam String nome) {
        List<Paziente> pazienti = pazienteService.trovaPerNome(nome);
        return ResponseEntity.ok(pazienti);
    }

    @GetMapping("/pazienti/cerca-per-cognome")
    public ResponseEntity<List<Paziente>> trovaPerCognome(@RequestParam String cognome) {
        List<Paziente> pazienti = pazienteService.trovaPerCognome(cognome);
        return ResponseEntity.ok(pazienti);
    }

    @GetMapping("/pazienti/cerca-per-codice-fiscale")
    public ResponseEntity<List<Paziente>> trovaPerCodiceFiscale(@RequestParam String codiceFiscale) {
        List<Paziente> pazienti = pazienteService.trovaPerCodiceFiscale(codiceFiscale);
        return ResponseEntity.ok(pazienti);
    }

    @GetMapping("/pazienti/cerca-per-medico")
    public ResponseEntity<List<Paziente>> trovaPerIdMedico(@RequestParam int idMedico) {
        List<Paziente> pazienti = pazienteService.trovaPerIdMedico(idMedico);
        return ResponseEntity.ok(pazienti);
    }

    // Ricerca per due parametri
    @GetMapping("/pazienti/cerca-per-nome-e-cognome")
    public ResponseEntity<List<Paziente>> trovaPerNomeECognome(@RequestParam String nome, @RequestParam String cognome) {
        List<Paziente> pazienti = pazienteService.trovaPerNomeECognome(nome, cognome);
        return ResponseEntity.ok(pazienti);
    }

    @GetMapping("/pazienti/cerca-per-nome-e-codice-fiscale")
    public ResponseEntity<List<Paziente>> trovaPerNomeECodiceFiscale(@RequestParam String nome, @RequestParam String codiceFiscale) {
        List<Paziente> pazienti = pazienteService.trovaPerNomeECodiceFiscale(nome, codiceFiscale);
        return ResponseEntity.ok(pazienti);
    }

    @GetMapping("/pazienti/cerca-per-nome-e-medico")
    public ResponseEntity<List<Paziente>> trovaPerNomeEIdMedico(@RequestParam String nome, @RequestParam int idMedico) {
        List<Paziente> pazienti = pazienteService.trovaPerNomeEIdMedico(nome, idMedico);
        return ResponseEntity.ok(pazienti);
    }

    @GetMapping("/pazienti/cerca-per-cognome-e-codice-fiscale")
    public ResponseEntity<List<Paziente>> trovaPerCognomeECodiceFiscale(@RequestParam String cognome, @RequestParam String codiceFiscale) {
        List<Paziente> pazienti = pazienteService.trovaPerCognomeECodiceFiscale(cognome, codiceFiscale);
        return ResponseEntity.ok(pazienti);
    }

    @GetMapping("/pazienti/cognome-medico")
    public ResponseEntity<List<Paziente>> trovaPerCognomeEIdMedico(@RequestParam String cognome, @RequestParam int idMedico) {
        List<Paziente> pazienti = pazienteService.trovaPerCognomeEIdMedico(cognome, idMedico);
        return ResponseEntity.ok(pazienti);
    }

    @GetMapping("/pazienti/codice-fiscale-medico")
    public ResponseEntity<List<Paziente>> trovaPerCodiceFiscaleEIdMedico(@RequestParam String codiceFiscale, @RequestParam int idMedico) {
        List<Paziente> pazienti = pazienteService.trovaPerCodiceFiscaleEIdMedico(codiceFiscale, idMedico);
        return ResponseEntity.ok(pazienti);
    }

    // Ricerca per tre parametri
    @GetMapping("/pazienti/trovaPerNomeECognomeECodiceFiscale")
    public List<Paziente> trovaPerNomeECognomeECodiceFiscale(@RequestParam String nome, @RequestParam String cognome, @RequestParam String codiceFiscale) {
        return pazienteService.trovaPerNomeECognomeECodiceFiscale(nome, cognome, codiceFiscale);
    }

    @GetMapping("/pazienti/trovaPerNomeECognomeEIdMedico")
    public List<Paziente> trovaPerNomeECognomeEIdMedico(@RequestParam String nome, @RequestParam String cognome, @RequestParam int idMedico) {
        return pazienteService.trovaPerNomeECognomeEIdMedico(nome, cognome, idMedico);
    }

    @GetMapping("/pazienti/trovaPerNomeECodiceFiscaleEIdMedico")
    public List<Paziente> trovaPerNomeECodiceFiscaleEIdMedico(@RequestParam String nome, @RequestParam String codiceFiscale, @RequestParam int idMedico) {
        return pazienteService.trovaPerNomeECodiceFiscaleEIdMedico(nome, codiceFiscale, idMedico);
    }

    @GetMapping("/pazienti/trovaPerCognomeECodiceFiscaleEIdMedico")
    public List<Paziente> trovaPerCognomeECodiceFiscaleEIdMedico(@RequestParam String cognome, @RequestParam String codiceFiscale, @RequestParam int idMedico) {
        return pazienteService.trovaPerCognomeECodiceFiscaleEIdMedico(cognome, codiceFiscale, idMedico);
    }

    // Ricerca per tutti e quattro i parametri
    @GetMapping("/pazienti/trovaPerNomeECognomeECodiceFiscaleEIdMedico")
    public List<Paziente> trovaPerNomeECognomeECodiceFiscaleEIdMedico(@RequestParam String nome, @RequestParam String cognome, @RequestParam String codiceFiscale, @RequestParam int idMedico) {
        return pazienteService.trovaPerNomeECognomeECodiceFiscaleEIdMedico(nome, cognome, codiceFiscale, idMedico);
    }
}

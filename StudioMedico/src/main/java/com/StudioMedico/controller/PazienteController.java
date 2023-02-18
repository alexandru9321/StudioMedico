package com.StudioMedico.controller;

import com.StudioMedico.entity.Prenotazione;
import com.StudioMedico.model.RichiestaPrenotazioneModel;
import com.StudioMedico.service.PazienteService;
import com.StudioMedico.service.SegretariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/paziente")
@CrossOrigin(origins = "http://localhost:4200")
public class PazienteController {

    @Autowired
    private PazienteService pazienteService;

    @Autowired
    private SegretariaService segretariaService;


    @PostMapping("/prenotazione")
    public ResponseEntity<Prenotazione> savePrenotazione (@RequestBody RichiestaPrenotazioneModel richiestaPrenotazioneModel){
        Prenotazione prenotazione = pazienteService.richiediPrenotazione(richiestaPrenotazioneModel.getIdPaziente(), richiestaPrenotazioneModel.getDataOraPrenotazione());
        segretariaService.savePrenotazione(prenotazione);
        return new ResponseEntity<Prenotazione>(prenotazione, HttpStatus.OK);
    }


}
package com.StudioMedico.controller;

import com.StudioMedico.entity.Medico;
import com.StudioMedico.entity.Paziente;
import com.StudioMedico.service.MedicoService;
import com.StudioMedico.service.PazienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medico")
@CrossOrigin(origins = "http://localhost:4200")
public class MedicoController {

    @Autowired
    private PazienteService pazienteService;

    @Autowired
    private MedicoService medicoService;

    @GetMapping("/findByMedico")
    public ResponseEntity<List<Paziente>> findByMedico(@RequestBody Medico medico){
        List<Paziente> pazientiList = pazienteService.findPazientiByMedico(medico);
        return new ResponseEntity<List<Paziente>>(pazientiList, HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Medico>> findAll(){
        List<Medico> mediciList = medicoService.findAll();
        return new ResponseEntity<List<Medico>>(mediciList, HttpStatus.OK);
    }

}

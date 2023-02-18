package com.StudioMedico.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class Prenotazione implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "data_prenotazione")
    private LocalDate dataPrenotazione;

    @Column(name = "ora_prenotazione")
    private LocalDateTime oraPrenotazione;

    @Column(name = "status_prenotazione")
    private String statusPrenotazione;

    @Column(name = "note")
    private String note;

    @ManyToOne
    @JoinColumn(name="id_paziente")
    private Paziente paziente;

    @ManyToOne
    @JoinColumn(name="id_medico")
    private Medico medico;

}

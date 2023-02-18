package com.StudioMedico.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
public class Paziente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "email")
    private String email;

    @Column(name="data_nascita")
    private LocalDate dataNascita;

    @Column(name = "codice_fiscale")
    private String codiceFiscale;

    @ManyToOne
    @JoinColumn(name="id_medico")
    private Medico medico;


}
package com.StudioMedico.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
public class Segretaria implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "telefono")
    private int telefono;

    @Column(name = "email_segreteria")
    private String emailSegreteria;

    @Column(name = "giorniLavorativi")
    private int giorniLavorativi;

    @OneToMany
    @Column(name="id_medico")
    private Set<Medico> medico;
}

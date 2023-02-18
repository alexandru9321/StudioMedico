package com.StudioMedico.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RichiestaPrenotazioneModel {

    private int idPaziente;

    private LocalDateTime dataOraPrenotazione;

}

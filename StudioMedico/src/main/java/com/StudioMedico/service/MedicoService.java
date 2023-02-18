package com.StudioMedico.service;

import com.StudioMedico.entity.Medico;
import com.StudioMedico.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public List<Medico> findAll (){
        List<Medico> medicoList = medicoRepository.findAll();
        return medicoList;
    }
}

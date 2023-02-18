package com.StudioMedico.repository;

import com.StudioMedico.entity.Medico;
import com.StudioMedico.entity.Segretaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SegretariaRepository extends JpaRepository<Segretaria, Integer> {

}
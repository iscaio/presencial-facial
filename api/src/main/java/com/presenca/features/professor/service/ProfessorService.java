package com.presenca.features.professor.service;

import com.presenca.features.professor.dto.ProfessorRequestDTO;
import com.presenca.features.professor.dto.ProfessorResponseDTO;

import java.util.List;
import java.util.UUID;

public interface ProfessorService {
    List<ProfessorResponseDTO> findAll();
    ProfessorResponseDTO findById(UUID id);
    ProfessorResponseDTO findByNome(String nome);
    ProfessorResponseDTO findByMatricula(String matricula);
    ProfessorResponseDTO create(ProfessorRequestDTO dto);
    void delete(UUID id);
}

package com.presenca.features.aluno.services;

import com.presenca.features.aluno.dto.AlunoRequestDTO;
import com.presenca.features.aluno.dto.AlunoResponseDTO;

import java.util.List;
import java.util.UUID;

public interface AlunoService {
    List<AlunoResponseDTO> findAll();
    AlunoResponseDTO findById(UUID id);
    AlunoResponseDTO create(AlunoRequestDTO dto);
    void delete (UUID id);
}

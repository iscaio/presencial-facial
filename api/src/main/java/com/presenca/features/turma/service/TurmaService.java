package com.presenca.features.turma.service;

import com.presenca.features.turma.dto.TurmaRequestDTO;
import com.presenca.features.turma.dto.TurmaResponseDTO;

import java.util.List;
import java.util.UUID;

public interface TurmaService {
    List<TurmaResponseDTO> findAll();
    TurmaResponseDTO findById(UUID id);
    TurmaResponseDTO findByNome(String nome);      // era findByName
    TurmaResponseDTO findByCodigo(String codigo);
    TurmaResponseDTO create(TurmaRequestDTO dto);
    void delete(UUID id);
}

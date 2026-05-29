package com.presenca.features.turma.dto;

import com.presenca.features.aluno.dto.AlunoResponseDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record TurmaResponseDTO(
        UUID id,
        String nome,
        String codigo,
        String descricao,
        Integer cargaHoraria,
        boolean ativa,
        UUID professorId,       // evita referência circular
        String professorNome,
        List<AlunoResponseDTO> alunos,
        LocalDate createdAt
) {}

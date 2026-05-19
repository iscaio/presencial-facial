package com.presenca.features.aluno.dto;

import java.time.LocalDate;
import java.util.UUID;

public record AlunoResponseDTO(
        UUID id,
        String nome,
        String matricula,
        boolean ativo,
        LocalDate createAt
) {}

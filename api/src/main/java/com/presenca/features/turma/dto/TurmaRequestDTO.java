package com.presenca.features.turma.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record TurmaRequestDTO(
        @NotBlank String nome,
        @NotBlank String codigo,
        @NotBlank String descricao,
        @NotNull Integer cargaHoraria,
        @NotNull(message = "O professor é obrigatório")
        UUID professorId   // recebe só o ID, não o objeto inteiro
) {}

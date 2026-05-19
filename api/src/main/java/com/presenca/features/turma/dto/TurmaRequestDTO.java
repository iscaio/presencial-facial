package com.presenca.features.turma.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TurmaRequestDTO(
        @NotBlank(message = "O Campo não pode ser nulo")
        String nome,
        @NotBlank(message = "O Campo não pode ser nulo")
        String codigo,
        @NotBlank(message = "O Campo não pode ser nulo")
        String descricao,
        @NotNull(message = "O Campo não pode ser nulo")
        Integer cargaHoraria
) {}

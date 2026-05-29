package com.presenca.features.professor.dto;

import jakarta.validation.constraints.NotBlank;

public record ProfessorRequestDTO (
        @NotBlank(message = "Esse campo precisa ser preenchido.")
        String nome,
        @NotBlank(message = "Esse campo precisa ser preenchido.")
        String matricula
) {}

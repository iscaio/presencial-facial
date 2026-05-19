package com.presenca.features.aluno.dto;


import jakarta.validation.constraints.NotBlank;

public record AlunoRequestDTO(
        @NotBlank(message = "O Campo precisa ser preenchido")
        String nome,

        @NotBlank(message = "O Campo precisa ser preenchido")
        String matricula
) {}

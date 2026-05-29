package com.presenca.features.professor.dto;

import java.time.LocalDate;
import java.util.UUID;

public record ProfessorResponseDTO(
   UUID id,
   String nome,
   String matricula,
   LocalDate createdAt
) {}

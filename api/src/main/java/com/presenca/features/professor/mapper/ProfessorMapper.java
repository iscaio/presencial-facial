package com.presenca.features.professor.mapper;

import com.presenca.features.professor.dto.ProfessorRequestDTO;
import com.presenca.features.professor.dto.ProfessorResponseDTO;
import com.presenca.features.professor.entity.Professor;

public class ProfessorMapper {

    public static Professor toEntity (ProfessorRequestDTO dto){
        return Professor.builder()
                .nome(dto.nome())
                .matricula(dto.matricula())
                .build();
    }

    public static ProfessorResponseDTO toDTO(Professor professor){
        return new ProfessorResponseDTO(
                professor.getId(),
                professor.getNome(),
                professor.getMatricula(),
                professor.getCreatedAt()
        );
    }
}

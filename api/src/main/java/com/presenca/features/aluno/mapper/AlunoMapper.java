package com.presenca.features.aluno.mapper;

import com.presenca.features.aluno.dto.AlunoRequestDTO;
import com.presenca.features.aluno.dto.AlunoResponseDTO;
import com.presenca.features.aluno.entity.Aluno;

public class AlunoMapper {

    public static Aluno toEntity(AlunoRequestDTO dto){
        return Aluno.builder()
                .nome(dto.nome())
                .matricula(dto.matricula())
                .build();
    }

    public static AlunoResponseDTO toDTO(Aluno aluno){
        return new AlunoResponseDTO(
                aluno.getId(),
                aluno.getNome(),
                aluno.getMatricula(),
                aluno.isAtivo(),
                aluno.getCreatedAt()
        );
    }
}

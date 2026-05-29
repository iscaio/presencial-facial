package com.presenca.features.turma.mapper;

import com.presenca.features.aluno.dto.AlunoResponseDTO;
import com.presenca.features.aluno.mapper.AlunoMapper;
import com.presenca.features.professor.entity.Professor;
import com.presenca.features.turma.dto.TurmaRequestDTO;
import com.presenca.features.turma.dto.TurmaResponseDTO;
import com.presenca.features.turma.entity.Turma;

import java.util.List;

public class TurmaMapper {

    public static TurmaResponseDTO toDTO(Turma turma) {
        List<AlunoResponseDTO> alunosDTO = turma.getAlunos() == null
                ? List.of()
                : turma.getAlunos().stream()
                  .map(AlunoMapper::toDTO)
                  .toList();

        return new TurmaResponseDTO(
                turma.getId(),
                turma.getNome(),
                turma.getCodigo(),
                turma.getDescricao(),
                turma.getCargaHoraria(),
                turma.isAtiva(),
                turma.getProfessor().getId(),       // só o ID
                turma.getProfessor().getNome(),     // e o nome
                alunosDTO,
                turma.getCreatedAt()
        );
    }

    public static Turma toEntity(TurmaRequestDTO dto, Professor professor) {
        return Turma.builder()
                .nome(dto.nome())
                .codigo(dto.codigo())
                .descricao(dto.descricao())
                .cargaHoraria(dto.cargaHoraria())
                .professor(professor)
                .build();
    }
}

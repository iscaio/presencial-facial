package com.presenca.features.aluno.services;

import com.presenca.features.aluno.dto.AlunoRequestDTO;
import com.presenca.features.aluno.dto.AlunoResponseDTO;
import com.presenca.features.aluno.entity.Aluno;
import com.presenca.features.aluno.mapper.AlunoMapper;
import com.presenca.features.aluno.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AlunoServiceImp implements AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public List<AlunoResponseDTO> findAll() {
        return alunoRepository.findAll()
                .stream()
                .map(AlunoMapper::toDTO)
                .toList();
    }

    @Override
    public AlunoResponseDTO findById(UUID id) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com esse ID"));

        return AlunoMapper.toDTO(aluno);

    }

    @Override
    public AlunoResponseDTO create(AlunoRequestDTO dto) {
        if (alunoRepository.existsByMatricula(dto.matricula())) {
            throw new IllegalArgumentException("Já existe um aluno com essa matrícula");
        }
        Aluno aluno = AlunoMapper.toEntity(dto);
        Aluno alunoSalvo = alunoRepository.save(aluno);
        return AlunoMapper.toDTO(alunoSalvo);
    }

    @Override
    public void delete(UUID id) {
        findById(id);
        alunoRepository.deleteById(id);
    }
}

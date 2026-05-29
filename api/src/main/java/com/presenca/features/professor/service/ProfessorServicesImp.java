package com.presenca.features.professor.service;

import com.presenca.features.professor.dto.ProfessorRequestDTO;
import com.presenca.features.professor.dto.ProfessorResponseDTO;
import com.presenca.features.professor.entity.Professor;
import com.presenca.features.professor.mapper.ProfessorMapper;
import com.presenca.features.professor.repository.ProfessorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProfessorServicesImp implements ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public List<ProfessorResponseDTO> findAll() {
        return professorRepository.findAll()
                .stream()
                .map(ProfessorMapper::toDTO)
                .toList();
    }

    @Override
    public ProfessorResponseDTO findById(UUID id) {
        return professorRepository.findById(id)
                .map(ProfessorMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Professor não encontrado com o ID: " + id));
    }

    @Override
    public ProfessorResponseDTO findByNome(String nome) {
        return professorRepository.findByNome(nome)
                .map(ProfessorMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Professor não encontrado com o nome: " + nome));
    }

    @Override
    public ProfessorResponseDTO findByMatricula(String matricula) {
        return professorRepository.findByMatricula(matricula)
                .map(ProfessorMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Professor não encontrado com a matrícula: " + matricula));
    }

    @Override
    public ProfessorResponseDTO create(ProfessorRequestDTO dto) {
        if (professorRepository.existsByMatricula(dto.matricula())) {
            throw new IllegalArgumentException("Já existe um professor com a matrícula: " + dto.matricula());
        }

        if (professorRepository.existsByNome(dto.nome())) {
            throw new IllegalArgumentException("Já existe um professor com o nome: " + dto.nome());
        }

        Professor professor = ProfessorMapper.toEntity(dto);
        Professor saved = professorRepository.save(professor);
        return ProfessorMapper.toDTO(saved);
    }

    @Override
    public void delete(UUID id) {
        if (!professorRepository.existsById(id)) {
            throw new EntityNotFoundException("Professor não encontrado com o ID: " + id);
        }
        professorRepository.deleteById(id);
    }
}

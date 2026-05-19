package com.presenca.features.turma.service;

import com.presenca.features.turma.dto.TurmaRequestDTO;
import com.presenca.features.turma.dto.TurmaResponseDTO;
import com.presenca.features.turma.entity.Turma;
import com.presenca.features.turma.mapper.TurmaMapper;
import com.presenca.features.turma.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TurmaServiceImp implements TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    @Override
    public List<TurmaResponseDTO> findAll() {
        return turmaRepository.findAll()
                .stream()
                .map(TurmaMapper::toDTO)
                .toList();
    }

    @Override
    public TurmaResponseDTO findById(UUID id) {
        Turma turma = turmaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada com esse ID"));
        return TurmaMapper.toDTO(turma);
    }

    @Override
    public TurmaResponseDTO findByNome(String nome) {
        Turma turma = turmaRepository.findByNome(nome)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada com esse nome"));
        return TurmaMapper.toDTO(turma);
    }

    @Override
    public TurmaResponseDTO findByCodigo(String codigo) {
        Turma turma = turmaRepository.findByCodigo(codigo)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada com esse código"));
        return TurmaMapper.toDTO(turma);
    }

    @Override
    public TurmaResponseDTO create(TurmaRequestDTO dto) {
        if (turmaRepository.existsByNome(dto.nome())) {
            throw new IllegalArgumentException("Já existe uma turma com esse nome: " + dto.nome());
        }
        if (turmaRepository.existsByCodigo(dto.codigo())) {
            throw new IllegalArgumentException("Já existe uma turma com esse código: " + dto.codigo());
        }
        Turma turma = TurmaMapper.toEntity(dto);
        Turma turmaSalva = turmaRepository.save(turma);
        return TurmaMapper.toDTO(turmaSalva);
    }

    @Override
    public void delete(UUID id) {
        findById(id);
        turmaRepository.deleteById(id);
    }
}

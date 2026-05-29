package com.presenca.features.professor.controller;

import com.presenca.features.professor.dto.ProfessorRequestDTO;
import com.presenca.features.professor.dto.ProfessorResponseDTO;
import com.presenca.features.professor.service.ProfessorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public ResponseEntity<List<ProfessorResponseDTO>> findAll() {
        return ResponseEntity.ok(professorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorResponseDTO> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(professorService.findById(id));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<ProfessorResponseDTO> findByNome(@PathVariable String nome) {
        return ResponseEntity.ok(professorService.findByNome(nome));
    }

    @GetMapping("/matricula/{matricula}")
    public ResponseEntity<ProfessorResponseDTO> findByMatricula(@PathVariable String matricula) {
        return ResponseEntity.ok(professorService.findByMatricula(matricula));
    }

    @PostMapping
    public ResponseEntity<ProfessorResponseDTO> create(@RequestBody @Valid ProfessorRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(professorService.create(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        professorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
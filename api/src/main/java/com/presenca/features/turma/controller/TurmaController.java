package com.presenca.features.turma.controller;

import com.presenca.features.turma.dto.TurmaRequestDTO;
import com.presenca.features.turma.dto.TurmaResponseDTO;
import com.presenca.features.turma.service.TurmaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    //GET
    @GetMapping
    public ResponseEntity<List<TurmaResponseDTO>> findAll(){

        return ResponseEntity.ok(turmaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurmaResponseDTO> findById(@PathVariable  UUID id){
        return ResponseEntity.ok(turmaService.findById(id));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<TurmaResponseDTO> findByNome(@PathVariable  String nome){
        return ResponseEntity.ok(turmaService.findByNome(nome));
    }

    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<TurmaResponseDTO> findByCodigo(@PathVariable String codigo){
        return ResponseEntity.ok(turmaService.findByCodigo(codigo));
    }
    //POST
    @PostMapping
    public ResponseEntity<TurmaResponseDTO> create(@RequestBody @Valid TurmaRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(turmaService.create(dto));
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        turmaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

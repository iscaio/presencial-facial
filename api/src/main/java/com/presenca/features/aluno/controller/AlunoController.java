package com.presenca.features.aluno.controller;

import com.presenca.features.aluno.dto.AlunoRequestDTO;
import com.presenca.features.aluno.dto.AlunoResponseDTO;
import com.presenca.features.aluno.services.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    //GET
    @GetMapping
    public ResponseEntity<List<AlunoResponseDTO>> findAll(){
        return ResponseEntity.ok(alunoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponseDTO> findById (@PathVariable UUID id){
        return ResponseEntity.ok(alunoService.findById(id));
    }
    //POST
    @PostMapping
    public ResponseEntity<AlunoResponseDTO> create(@RequestBody @Valid AlunoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.create(dto));
    }
    //PUT
    //Aqui vai ser colocado quando for criado a turma e relacionar com aluno
    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        alunoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

package com.presenca.features.aluno.repository;

import com.presenca.features.aluno.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AlunoRepository extends JpaRepository <Aluno, UUID> {
    boolean existsByMatricula(String matricula);
}

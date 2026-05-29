package com.presenca.features.professor.repository;

import com.presenca.features.professor.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProfessorRepository extends JpaRepository<Professor, UUID> {
    Optional<Professor> findByNome(String nome);
    Optional<Professor> findByMatricula(String matricula);
    boolean existsByMatricula(String matricula);
    boolean existsByNome(String nome);
}

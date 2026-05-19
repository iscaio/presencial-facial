package com.presenca.features.turma.repository;

import com.presenca.features.turma.entity.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TurmaRepository extends JpaRepository<Turma, UUID> {
    Optional<Turma> findByNome(String nome);
    Optional<Turma> findByCodigo(String codigo);
    boolean existsByNome(String nome);
    boolean existsByCodigo(String codigo);
}

package com.presenca.features.turma.entity;

import com.presenca.features.aluno.entity.Aluno;
import com.presenca.features.professor.entity.Professor;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Column(nullable = false)
    private String nome;

    @NotBlank
    @Column(nullable = false)
    private String codigo;

    @NotBlank
    @Column(nullable = false)
    private String descricao;

    @NotNull(message = "Carga horária é obrigatória")
    @Column(nullable = false)
    private Integer cargaHoraria;

    @Column(nullable = false)
    private boolean ativa;

    @OneToMany(mappedBy = "turma", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Aluno> alunos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professor_id", nullable = false)
    private Professor professor;

    @Column(nullable = false)
    private LocalDate createdAt;

    @PrePersist
    public void prePersist(){
        this.ativa = true;
        this.createdAt = LocalDate.now();
    }
}

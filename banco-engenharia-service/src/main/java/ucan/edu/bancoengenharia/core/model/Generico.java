package ucan.edu.bancoengenharia.core.model;

import jakarta.persistence.*;
import lombok.Data;
import ucan.edu.bancoengenharia.core.enums.EEstadoTipo;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Generico {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Enumerated(EnumType.STRING)
    private EEstadoTipo estado;
    @Column(nullable = false, updatable = false)
    private LocalDateTime createAt;
    @Column(nullable = false)
    private LocalDateTime updateAt;

    @PrePersist
    protected void criacao() {
        LocalDateTime dataNow = LocalDateTime.now();
        estado = EEstadoTipo.Criado;
        createAt = dataNow;
        updateAt = dataNow;
    }

    @PreUpdate
    protected void atualizacao() {
        if (estado == null || estado.equals(EEstadoTipo.Criado)) {
            estado = EEstadoTipo.Activo;
        }
        updateAt = LocalDateTime.now();
    }
}

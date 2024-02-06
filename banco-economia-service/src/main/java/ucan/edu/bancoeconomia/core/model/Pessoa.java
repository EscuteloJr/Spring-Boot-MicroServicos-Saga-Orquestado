package ucan.edu.bancoeconomia.core.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "pessoa")
public class Pessoa extends  Generico {
    private String nome;
    private String sobrenome;
    private String documento_id;
    private LocalDateTime data_nascimento;
    private String endereco;

}

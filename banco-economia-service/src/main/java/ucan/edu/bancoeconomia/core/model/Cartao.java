package ucan.edu.bancoeconomia.core.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cartao")
public class Cartao extends  Generico{
    private String numero;
    @OneToOne
    private Conta conta;
    private LocalDate dataExpiracao;
    private int pin;
}

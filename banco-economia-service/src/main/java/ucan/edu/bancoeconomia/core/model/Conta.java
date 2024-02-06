package ucan.edu.bancoeconomia.core.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "conta")
public class Conta extends  Generico{

    private String numero;
    private String iban;
    private BigDecimal saldo;
    @ManyToOne
    private Entidade entidade;
}

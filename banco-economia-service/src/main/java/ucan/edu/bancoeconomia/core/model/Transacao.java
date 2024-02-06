package ucan.edu.bancoeconomia.core.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "transacao")
public class Transacao extends  Generico{
    @OneToOne
    private Conta conta;
    private BigDecimal montante;
    private BigDecimal saldoAnterior;
    private BigDecimal saldoAposOMovimento;
    
}

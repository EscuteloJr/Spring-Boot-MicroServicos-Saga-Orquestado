package ucan.edu.bancoeconomia.core.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "entidade")
public class Entidade extends  Generico{

    private String chave;
    @ManyToMany
    List<Pessoa> pessoa;

}

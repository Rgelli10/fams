package fams.com.br.model;

import fams.com.br.model.record.TemporadaCadastro;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Temporada {
    private Integer numeroTemporada;
    private String descricao;
    private String classificacaoTemporada;

    public Temporada(TemporadaCadastro cadastro){
        this.numeroTemporada = cadastro.numeroTemporada();
        this.descricao = cadastro.descricao();
        this.classificacaoTemporada = cadastro.classificacaoTemporada();
    }
}

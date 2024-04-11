package fams.com.br.model;

import fams.com.br.model.record.DadosFamsCadastro;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class DadosFams {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String genero;
    private String descricao;

    private String temporadas;

    private String classificacao;

    public DadosFams(DadosFamsCadastro cadastro){
        this.id = cadastro.id();
        this.nome = cadastro.nome();
        this.genero = cadastro.genero();
        this.descricao = cadastro.descricao();
        this.temporadas = cadastro.temporadas();
        this.classificacao = cadastro.classificacao();
    }

}

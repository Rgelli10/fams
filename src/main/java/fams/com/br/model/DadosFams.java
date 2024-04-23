package fams.com.br.model;

import fams.com.br.model.record.DadosFamsCadastro;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class DadosFams {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String[] genero;
    private String descricao;
    private List<Integer> temporadas;
    private Integer classificacao;

    public DadosFams(DadosFamsCadastro cadastro){
        this.id = cadastro.id();
        this.nome = cadastro.nome();
        this.genero = cadastro.genero();
        this.descricao = cadastro.descricao();
        this.temporadas = cadastro.temporadas();
        this.classificacao = cadastro.classificacao();
    }

    public void atualizaFams(DadosFamsCadastro cadastro){
        this.id = cadastro.id();
        this.nome = cadastro.nome();
        this.genero = cadastro.genero();
        this.descricao = cadastro.descricao();
        this.temporadas = cadastro.temporadas();
        this.classificacao = cadastro.classificacao();
    }

}

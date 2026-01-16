package fams.com.br.model.entidade;

import fams.com.br.model.enums.GeneroEnum;
import jakarta.persistence.*;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricaoGeral;

    @Enumerated(EnumType.STRING)
    private GeneroEnum genero;

    private Integer temporadas; // nullable

    private Double classificacaoGeral;

    private Integer totalAvaliacoes;

    @PrePersist
    public void init() {
        this.classificacaoGeral = 0.0;
        this.totalAvaliacoes = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricaoGeral() {
        return descricaoGeral;
    }

    public void setDescricaoGeral(String descricaoGeral) {
        this.descricaoGeral = descricaoGeral;
    }

    public GeneroEnum getGenero() {
        return genero;
    }

    public void setGenero(GeneroEnum genero) {
        this.genero = genero;
    }

    public Integer getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(Integer temporadas) {
        this.temporadas = temporadas;
    }

    public Double getClassificacaoGeral() {
        return classificacaoGeral;
    }

    public void setClassificacaoGeral(Double classificacaoGeral) {
        this.classificacaoGeral = classificacaoGeral;
    }

    public Integer getTotalAvaliacoes() {
        return totalAvaliacoes;
    }

    public void setTotalAvaliacoes(Integer totalAvaliacoes) {
        this.totalAvaliacoes = totalAvaliacoes;
    }
}

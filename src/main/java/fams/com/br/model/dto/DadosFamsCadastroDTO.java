package fams.com.br.model.dto;

import fams.com.br.model.entidade.Temporada;

import java.util.List;

public class DadosFamsCadastroDTO {
    private Long id;
    private String nome;
    private String[] genero;
    private String descricaoGeral;
    private List<Temporada> temporadas;
    private Integer classificacaoGeral;
}

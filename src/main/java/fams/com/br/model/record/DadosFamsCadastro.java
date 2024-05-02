package fams.com.br.model.record;

import fams.com.br.model.DadosFams;
import fams.com.br.model.Temporada;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@ToString
@EqualsAndHashCode(callSuper = false)
public record DadosFamsCadastro(
        Long id,
        String nome,
        String[] genero,
        String descricao,
        List<Temporada> temporadas,
        Integer classificacao) {}

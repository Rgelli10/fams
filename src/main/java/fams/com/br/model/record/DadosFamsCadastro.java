package fams.com.br.model.record;

import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@ToString
@EqualsAndHashCode
public record DadosFamsCadastro(
        Long id,
        String nome,
        String[] genero,
        String descricao,
        List<Integer> temporadas,
        Integer classificacao) {}

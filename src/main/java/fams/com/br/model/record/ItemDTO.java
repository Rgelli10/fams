package fams.com.br.model.record;

import fams.com.br.model.enums.GeneroEnum;

public record ItemDTO(
        Long id,
        String nome,
        String descricaoGeral,
        GeneroEnum genero,
        Integer temporadas,
        Double classificacaoGeral
) {}

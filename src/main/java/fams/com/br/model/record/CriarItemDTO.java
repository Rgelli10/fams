package fams.com.br.model.record;

import fams.com.br.model.enums.GeneroEnum;

public record CriarItemDTO(
        String nome,
        String descricaoGeral,
        GeneroEnum genero,
        Integer temporadas
) {}

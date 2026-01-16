package fams.com.br.model.record;

public record ListaItemRequest(
        String tipo,
        String genero,
        String sinopse,
        Double avaliacao,
        String descricao
) {}


package fams.com.br.model.record.response;

public record ItemResponseDTO(
        Long id,
        String nome,
        String descricao,
        String genero,
        Integer temporadas,
        Double notaGeral
) {}


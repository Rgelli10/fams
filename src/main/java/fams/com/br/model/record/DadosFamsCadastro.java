package fams.com.br.model.record;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DadosFamsCadastro(
        @NotNull
        Long id,
        String nome,
        String genero,
        String descricao,
        String temporadas,
        String classificacao) {}

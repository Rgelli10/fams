package fams.com.br.model.record;

import fams.com.br.model.DadosFams;

import java.util.List;

public record UsuarioFamsCadastro(Long userId, String nome, String email, String senha, List<DadosFams> listaFam) {
}

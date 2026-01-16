package fams.com.br.service;

import fams.com.br.model.entidade.ListaItem;
import fams.com.br.model.entidade.Usuario;
import fams.com.br.model.record.ListaItemRequest;
import fams.com.br.repository.ListaRepository;
import fams.com.br.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ListaService {

    private final ListaRepository repository;
    private final UsuarioRepository usuarioRepository;

    public void criar(ListaItemRequest dto, String email) {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow();

        ListaItem item = new ListaItem();
        item.setUsuario(usuario);
        item.setTipo(dto.tipo());
        item.setGenero(dto.genero());
        item.setSinopse(dto.sinopse());
        item.setAvaliacao(dto.avaliacao());
        item.setDescricao(dto.descricao());

        repository.save(item);
    }

    public Optional<ListaItem> listarDoUsuario(String email) {
        return repository.findByUsuarioEmail(email);
    }
}


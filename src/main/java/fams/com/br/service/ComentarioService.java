package fams.com.br.service;

import fams.com.br.model.entidade.Comentario;
import fams.com.br.model.entidade.Item;
import fams.com.br.model.entidade.Usuario;
import fams.com.br.model.record.ComentarioDTO;
import fams.com.br.repository.ComentarioRepository;
import fams.com.br.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;
    private final ItemRepository itemRepository;

    public ComentarioService(ComentarioRepository comentarioRepository,
                             ItemRepository itemRepository) {
        this.comentarioRepository = comentarioRepository;
        this.itemRepository = itemRepository;
    }

    @Transactional
    public void comentar(Long usuarioId, ComentarioDTO dto) {

        Item item = itemRepository.findById(dto.itemId())
                .orElseThrow(() -> new RuntimeException("Item não encontrado"));

        Comentario comentario = new Comentario();
        comentario.setUsuario(new Usuario(){{
            setId(usuarioId);
        }});
        comentario.setItem(item);
        comentario.setTexto(dto.texto());

        comentarioRepository.save(comentario);
    }
}


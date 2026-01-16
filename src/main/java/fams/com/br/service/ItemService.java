package fams.com.br.service;

import fams.com.br.model.entidade.Item;
import fams.com.br.model.entidade.ListaUsuario;
import fams.com.br.model.entidade.Usuario;
import fams.com.br.model.enums.GeneroEnum;
import fams.com.br.model.record.CriarItemDTO;
import fams.com.br.model.record.ItemDTO;
import fams.com.br.repository.ItemRepository;
import fams.com.br.repository.ListaUsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final ListaUsuarioRepository listaRepository;

    public ItemService(ItemRepository itemRepository,
                       ListaUsuarioRepository listaRepository) {
        this.itemRepository = itemRepository;
        this.listaRepository = listaRepository;
    }

    @Transactional
    public ItemDTO criarItem(Long usuarioId, CriarItemDTO dto) {

        Integer temporadas = dto.genero().possuiTemporada()
                ? dto.temporadas()
                : null;

        Item item = new Item();
        item.setNome(dto.nome());
        item.setDescricaoGeral(dto.descricaoGeral());
        item.setGenero(dto.genero());
        item.setTemporadas(temporadas);

        itemRepository.save(item);

        GeneroEnum genero = dto.genero();

        ListaUsuario lista = listaRepository
                .findByUsuarioIdAndGenero(usuarioId, genero)
                .orElseGet(() -> {
                    ListaUsuario nova = new ListaUsuario();
                    nova.setGenero(genero);

                    Usuario usuario = new Usuario();
                    usuario.setId(usuarioId);
                    nova.setUsuario(usuario);

                    return listaRepository.save(nova);
                });

        lista.getItens().add(item);

        return new ItemDTO(
                item.getId(),
                item.getNome(),
                item.getDescricaoGeral(),
                item.getGenero(),
                item.getTemporadas(),
                item.getClassificacaoGeral()
        );
    }

    @Transactional(readOnly = true)
    public ItemDTO buscarPorId(Long id) {

        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item não encontrado"));

        return new ItemDTO(
                item.getId(),
                item.getNome(),
                item.getDescricaoGeral(),
                item.getGenero(),
                item.getTemporadas(),
                item.getClassificacaoGeral()
        );
    }

}

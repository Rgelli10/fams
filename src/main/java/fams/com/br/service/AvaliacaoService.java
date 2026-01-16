package fams.com.br.service;

import fams.com.br.model.entidade.Avaliacao;
import fams.com.br.model.entidade.Item;
import fams.com.br.model.entidade.Usuario;
import fams.com.br.model.record.AvaliacaoDTO;
import fams.com.br.repository.AvaliacaoRepository;
import fams.com.br.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AvaliacaoService {

    private final AvaliacaoRepository avaliacaoRepository;
    private final ItemRepository itemRepository;

    public AvaliacaoService(AvaliacaoRepository avaliacaoRepository,
                            ItemRepository itemRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
        this.itemRepository = itemRepository;
    }

    @Transactional
    public void avaliar(Long usuarioId, AvaliacaoDTO dto) {

        if (avaliacaoRepository.existsByUsuarioIdAndItemId(usuarioId, dto.itemId())) {
            throw new RuntimeException("Usuário já avaliou este item");
        }

        Item item = itemRepository.findById(dto.itemId())
                .orElseThrow(() -> new RuntimeException("Item não encontrado"));

        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setUsuario(new Usuario(){{
            setId(usuarioId);
        }});
        avaliacao.setItem(item);
        avaliacao.setNota(dto.nota());

        avaliacaoRepository.save(avaliacao);

        double novaMedia =
                ((item.getClassificacaoGeral() * item.getTotalAvaliacoes())
                        + dto.nota())
                        / (item.getTotalAvaliacoes() + 1);

        item.setTotalAvaliacoes(item.getTotalAvaliacoes() + 1);
        item.setClassificacaoGeral(novaMedia);
    }
}


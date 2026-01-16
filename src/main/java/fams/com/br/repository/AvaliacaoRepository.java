package fams.com.br.repository;

import fams.com.br.model.entidade.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
    boolean existsByUsuarioIdAndItemId(Long usuarioId, Long itemId);
}

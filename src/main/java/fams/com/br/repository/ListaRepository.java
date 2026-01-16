package fams.com.br.repository;

import fams.com.br.model.entidade.ListaItem;
import fams.com.br.model.entidade.ListaUsuario;
import fams.com.br.model.enums.GeneroEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ListaRepository extends JpaRepository<ListaItem, Long> {
    Optional<ListaItem> findByUsuarioEmail(String email);
}

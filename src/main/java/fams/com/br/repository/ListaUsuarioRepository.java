package fams.com.br.repository;

import fams.com.br.model.entidade.ListaUsuario;
import fams.com.br.model.enums.GeneroEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ListaUsuarioRepository extends JpaRepository<ListaUsuario, Long> {
    Optional<ListaUsuario> findByUsuarioIdAndGenero(Long usuarioId, GeneroEnum genero);
}

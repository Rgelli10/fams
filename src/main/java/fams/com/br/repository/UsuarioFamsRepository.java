package fams.com.br.repository;

import fams.com.br.model.UsuarioFams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioFamsRepository extends JpaRepository<UsuarioFams, Long> {
}

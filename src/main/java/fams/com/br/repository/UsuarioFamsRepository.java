package fams.com.br.repository;

import fams.com.br.model.entidade.UsuarioFams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioFamsRepository extends JpaRepository<UsuarioFams, Long> {
    Optional<UsuarioFams> findByEmailAndSenha(String email, String senha);
}

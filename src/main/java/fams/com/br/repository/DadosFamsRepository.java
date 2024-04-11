package fams.com.br.repository;

import fams.com.br.model.DadosFams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DadosFamsRepository extends JpaRepository<DadosFams, Long> {
}

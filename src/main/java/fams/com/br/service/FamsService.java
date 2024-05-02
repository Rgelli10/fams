package fams.com.br.service;

import fams.com.br.model.DadosFams;
import fams.com.br.repository.DadosFamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamsService {
    DadosFamsRepository repository;

    public FamsService(DadosFamsRepository repository) {
        this.repository = repository;
    }

    public DadosFams cadastrarFams(DadosFams dadosFams){
        return repository.save(dadosFams);
    }

    public DadosFams atualizarFams(Long id){
        DadosFams dadosFams = new DadosFams();
        DadosFams fams = repository.findById(id).orElseThrow(RuntimeException::new);
        fams.setNome(dadosFams.getNome());
        fams.setDescricaoGeral(dadosFams.getDescricaoGeral());
        fams.setGenero(dadosFams.getGenero());
        fams.setTemporadas(dadosFams.getTemporadas());
        fams.setClassificacaoGeral(dadosFams.getClassificacaoGeral());

        return dadosFams;
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}

package fams.com.br.service;

import fams.com.br.model.DadosFams;
import fams.com.br.model.record.DadosFamsCadastro;
import fams.com.br.repository.DadosFamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamsService {
    @Autowired
    DadosFamsRepository repository;

    public DadosFams cadastrarFams(DadosFams dadosFams){
        return repository.save(dadosFams);
    }

    public DadosFams atualizarFams(Long id){
        DadosFams dadosFams = new DadosFams();
        DadosFams fams = repository.findById(id).orElseThrow(RuntimeException::new);
        fams.setNome(dadosFams.getNome());
        dadosFams.setDescricao(dadosFams.getDescricao());
        dadosFams.setGenero(dadosFams.getGenero());
        dadosFams.setTemporadas(dadosFams.getTemporadas());
        dadosFams.setClassificacao(dadosFams.getClassificacao());
        return dadosFams;
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}

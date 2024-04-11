package fams.com.br;

import fams.com.br.model.DadosFams;
import fams.com.br.model.record.DadosFamsCadastro;
import fams.com.br.repository.DadosFamsRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fams")
public class FamsController {

    @Autowired
    private DadosFamsRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarFams(@RequestBody @Valid DadosFamsCadastro famsCadastro){
        repository.save(new DadosFams(famsCadastro));
    }
}

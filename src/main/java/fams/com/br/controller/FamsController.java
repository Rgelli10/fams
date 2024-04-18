package fams.com.br.controller;

import fams.com.br.model.DadosFams;
import fams.com.br.model.record.DadosFamsCadastro;
import fams.com.br.repository.DadosFamsRepository;
import fams.com.br.service.FamsService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fams")
public class FamsController {

    @Autowired
    DadosFamsRepository repository;
    @Autowired
    FamsService service;

    @PostMapping
    @Transactional
    public DadosFams cadastrarFams(@RequestBody @Valid DadosFams famsCadastro){
        return service.cadastrarFams(famsCadastro);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity delete(Long id){
        service.deletar(id);
        return ResponseEntity.ok().build();
    }
}

package fams.com.br.controller;

import fams.com.br.model.DadosFams;
import fams.com.br.service.FamsService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fams")
public class FamsController {
    @Autowired
    FamsService service;

    @PostMapping
    @Transactional
    public DadosFams cadastrarFams(@RequestBody @Valid DadosFams famsCadastro){
        return service.cadastrarFams(famsCadastro);
    }

    @PutMapping
    @Transactional
    @ApiResponse(responseCode = "STATUS_200")
    public DadosFams atualizarFams(@RequestBody @Valid Long id){
        return service.atualizarFams(id);
    }

    @DeleteMapping
    @Transactional
    public void delete(Long id){
        service.deletar(id);
    }

}

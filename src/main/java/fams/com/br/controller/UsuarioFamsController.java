package fams.com.br.controller;

import fams.com.br.model.UsuarioFams;
import fams.com.br.service.FamsService;
import fams.com.br.service.UsuarioService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UsuarioFamsController {
    UsuarioService service;

    public UsuarioFamsController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    @Transactional
    @ApiResponse(responseCode = "STATUS_200")
    public UsuarioFams cadastrarUsuario(@RequestBody @Valid UsuarioFams usuarioFams){
        return service.cadastrarUsuario(usuarioFams);
    }

    @PutMapping
    @Transactional
    @ApiResponse(responseCode = "STATUS_200")
    public UsuarioFams atualizarUsuario(Long id){
        return service.atualizar(id);
    }

    @DeleteMapping
    @Transactional
    @ApiResponse(responseCode = "STATUS_200")
    public void deletarUsuario(Long id){
        service.deletar(id);
    }
}

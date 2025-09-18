package fams.com.br.controller;

import fams.com.br.model.dto.UsuarioFamsDTO;
import fams.com.br.service.UsuarioService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UsuarioFamsController {

    private final UsuarioService service;

    public UsuarioFamsController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    @Transactional
    @ApiResponse(responseCode = "200", description = "Usuário cadastrado com sucesso")
    public UsuarioFamsDTO cadastrarUsuario(@RequestBody @Valid UsuarioFamsDTO usuarioFamsDTO) {
        return service.cadastrarUsuario(usuarioFamsDTO);
    }

    @PutMapping("/{id}")
    @Transactional
    @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso")
    public UsuarioFamsDTO atualizarUsuario(@PathVariable Long id, @RequestBody @Valid UsuarioFamsDTO usuarioAtualizado) {
        return service.atualizar(id, usuarioAtualizado);
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ApiResponse(responseCode = "200", description = "Usuário deletado com sucesso")
    public void deletarUsuario(@PathVariable Long id) {
        service.deletar(id);
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioFamsDTO> login(@RequestBody UsuarioFamsDTO loginRequest) {
        UsuarioFamsDTO usuario = service.login(loginRequest.getEmail(), loginRequest.getSenha());
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}


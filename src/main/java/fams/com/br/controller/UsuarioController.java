package fams.com.br.controller;

import fams.com.br.model.record.UsuarioCadastroDTO;
import fams.com.br.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody UsuarioCadastroDTO dto) {
        usuarioService.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

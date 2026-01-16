package fams.com.br.controller;

import fams.com.br.model.entidade.Usuario;
import fams.com.br.model.record.ComentarioDTO;
import fams.com.br.service.ComentarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comentarios")
@RequiredArgsConstructor
public class ComentarioController {

    private final ComentarioService comentarioService;

    @PostMapping
    public ResponseEntity<Void> comentar(
            @RequestBody @Valid ComentarioDTO dto,
            @AuthenticationPrincipal Usuario usuario) {

        comentarioService.comentar(usuario.getId(), dto);
        return ResponseEntity.ok().build();
    }
}


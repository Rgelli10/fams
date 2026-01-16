package fams.com.br.controller;

import fams.com.br.model.entidade.Usuario;
import fams.com.br.model.record.AvaliacaoDTO;
import fams.com.br.service.AvaliacaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/avaliacoes")
@RequiredArgsConstructor
public class AvaliacaoController {

    private final AvaliacaoService avaliacaoService;

    @PostMapping
    public ResponseEntity<Void> avaliar(
            @RequestBody @Valid AvaliacaoDTO dto,
            @AuthenticationPrincipal Usuario usuario) {

        avaliacaoService.avaliar(usuario.getId(), dto);
        return ResponseEntity.ok().build();
    }
}


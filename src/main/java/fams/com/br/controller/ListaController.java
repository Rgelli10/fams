package fams.com.br.controller;

import fams.com.br.model.entidade.ListaItem;
import fams.com.br.model.record.ListaItemRequest;
import fams.com.br.service.ListaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/listas")
@RequiredArgsConstructor
public class ListaController {

    private final ListaService listaService;

    @PostMapping
    public ResponseEntity<Void> criar(
            @RequestBody ListaItemRequest request,
            Authentication authentication
    ) {
        listaService.criar(request, authentication.getName());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/minha")
    public ResponseEntity<Optional<ListaItem>> minhaLista(Authentication authentication) {
        return ResponseEntity.ok(
                listaService.listarDoUsuario(authentication.getName())
        );
    }
}


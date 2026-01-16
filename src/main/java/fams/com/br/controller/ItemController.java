package fams.com.br.controller;

import fams.com.br.model.entidade.Usuario;
import fams.com.br.model.record.CriarItemDTO;
import fams.com.br.model.record.ItemDTO;
import fams.com.br.service.ItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    public ResponseEntity<ItemDTO> criarItem(
            @RequestBody @Valid CriarItemDTO dto,
            @AuthenticationPrincipal Usuario usuario) {

        ItemDTO item = itemService.criarItem(usuario.getId(), dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(itemService.buscarPorId(id));
    }
}


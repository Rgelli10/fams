package fams.com.br.controller;

import fams.com.br.model.entidade.Usuario;
import fams.com.br.model.record.LoginDTO;
import fams.com.br.model.record.TokenDTO;
import fams.com.br.service.UsuarioService;
import fams.com.br.service.util.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UsuarioService usuarioService;
    private final JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody LoginDTO dto) {

        Usuario usuario = usuarioService.autenticar(dto.email(), dto.senha());
        String token = jwtService.gerarToken(usuario);

        return ResponseEntity.ok(new TokenDTO(token));
    }
}



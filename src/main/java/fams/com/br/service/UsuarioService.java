package fams.com.br.service;

import fams.com.br.model.dto.UsuarioFamsDTO;
import fams.com.br.model.entidade.UsuarioFams;
import fams.com.br.repository.UsuarioFamsRepository;
import fams.com.br.service.mapper.UsuarioMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioFamsRepository repository;
    private final UsuarioMapper mapper;

    public UsuarioService(UsuarioFamsRepository repository, UsuarioMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public UsuarioFamsDTO cadastrarUsuario(UsuarioFamsDTO dto) {
        UsuarioFams usuario = mapper.toEntity(dto);
        UsuarioFams salvo = repository.save(usuario);
        return mapper.toDTO(Optional.of(salvo));
    }

    public UsuarioFamsDTO atualizar(Long id, UsuarioFamsDTO usuarioAtualizado) {
        UsuarioFams usuarioExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuarioExistente.setNome(usuarioAtualizado.getNome());
        usuarioExistente.setEmail(usuarioAtualizado.getEmail());
        usuarioExistente.setSenha(usuarioAtualizado.getSenha());

        UsuarioFams salvo = repository.save(usuarioExistente);
        return mapper.toDTO(Optional.of(salvo));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public UsuarioFamsDTO login(String email, String senha) {

        Optional<UsuarioFams> usuario = repository.findByEmailAndSenha(email, senha);
        if (usuario != null) {
            return mapper.toDTO(usuario);
        } else {
            return null;
        }
    }

}

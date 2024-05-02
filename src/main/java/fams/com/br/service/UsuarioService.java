package fams.com.br.service;

import fams.com.br.model.UsuarioFams;
import fams.com.br.repository.UsuarioFamsRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    UsuarioFamsRepository repository;

    public UsuarioService(UsuarioFamsRepository repository) {
        this.repository = repository;
    }

    public UsuarioFams cadastrarUsuario(UsuarioFams usuarioFams){
        return repository.save(usuarioFams);
    }

    public UsuarioFams atualizar(Long id) {
        UsuarioFams usuarioFams = new UsuarioFams();
        UsuarioFams usuarioId = repository.findById(id).orElseThrow(RuntimeException::new);
        usuarioId.setNome(usuarioFams.getNome());
        usuarioId.setEmail(usuarioFams.getEmail());
        usuarioId.setSenha(usuarioFams.getSenha());

        return usuarioFams;
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}

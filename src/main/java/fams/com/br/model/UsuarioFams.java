package fams.com.br.model;

import fams.com.br.model.record.UsuarioFamsCadastro;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "userId")
@ToString
public class UsuarioFams {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String nome;
    private String email;
    private String senha;
    private List<DadosFams> listaFams;

    public UsuarioFams(UsuarioFamsCadastro usuario){
        this.userId = usuario.userId();
        this.nome = usuario.nome();
        this.email = usuario.email();
        this.senha = usuario.senha();
        this.listaFams = usuario.listaFam();
    }

}

package fams.com.br.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioFamsDTO {
    private Long userId;
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
}

package br.com.cesjf.trabalhomobile.Model;

import br.com.cesjf.trabalhomobile.Model.Dto.CadastroDto;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "usuario_tb")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Long id;

    @Column(name = "nome_completo", nullable = false)
    private String nomeCompleto;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(unique = true, name = "nome_usuario", nullable = false)
    private String nomeUsuario;

    @OneToMany(mappedBy = "usuario")
    private List<Favorito> favoritos;


    @OneToMany(mappedBy = "usuarioEnvio")
    private List<Compartilhamento> enviados;

    @OneToMany(mappedBy = "usuarioRecebimento")
    private List<Compartilhamento> recebidos;

    public static Usuario createFromCadastro(CadastroDto dto){
        Usuario usuario = new Usuario();
        usuario.setNomeUsuario(dto.getNomeUsuario());
        usuario.setEmail(dto.getEmail());
        usuario.setNomeCompleto(dto.getNomeCompleto());
        usuario.setSenha(dto.getSenha());
        return usuario;
    }

}

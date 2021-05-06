package br.com.cesjf.trabalhomobile.Model;

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

    @Column(name = "nome_completo")
    private String nomeCompleto;

    private String email;

    private String senha;

    @Column(name = "nome_usuario")
    private String nomeUsuario;

    @OneToMany(mappedBy = "usuario")
    private List<Favorito> favoritos;


    @OneToMany(mappedBy = "usuarioEnvio")
    private List<Compartilhamento> enviados;

    @OneToMany(mappedBy = "usuarioRecebimento")
    private List<Compartilhamento> recebidos;

}

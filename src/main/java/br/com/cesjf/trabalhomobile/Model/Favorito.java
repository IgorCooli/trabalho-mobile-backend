package br.com.cesjf.trabalhomobile.Model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "favorito_tb",
        uniqueConstraints={
                @UniqueConstraint(columnNames = {"usuario_id", "heroi_id"})
        })
public class Favorito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "favorito_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "heroi_id")
    private Heroi heroi;

    public static Favorito create(Usuario usuario, Heroi heroi){
        Favorito favorito = new Favorito();
        favorito.setUsuario(usuario);
        favorito.setHeroi(heroi);
        return favorito;
    }

}

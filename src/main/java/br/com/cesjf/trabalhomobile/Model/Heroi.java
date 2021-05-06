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
@Table(name = "heroi_tb")
public class Heroi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "heroi_id")
    private Long id;

    @Column(name = "api_id", unique = true)
    private Long idApi;

    private String nome;

    @Column(name = "alter_ego")
    private String alterEgo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id", referencedColumnName = "status_id")
    private Status status;

    @OneToMany(mappedBy = "heroi")
    private List<Favorito> favoritos;

}

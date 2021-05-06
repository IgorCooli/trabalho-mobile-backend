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
@Table(name = "status_tb")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private Long id;

    @OneToOne(mappedBy = "status")
    private Heroi heroi;

    private String altura;

    private String peso;

    private int inteligencia;

    private int forca;

    private int velocidade;

    private int resistencia;

    private int poder;

    private int combate;

}

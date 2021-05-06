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
@Table(name = "compartilhamento_tb")
public class Compartilhamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "compartilhamento_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_envio_id")
    private Usuario usuarioEnvio;

    @ManyToOne
    @JoinColumn(name = "usuario_recebimento_id")
    private Usuario usuarioRecebimento;

    @ManyToOne
    @JoinColumn(name = "heroi_id")
    private Heroi heroi;

}

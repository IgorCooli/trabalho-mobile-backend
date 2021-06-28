package br.com.cesjf.trabalhomobile.Model;

import br.com.cesjf.trabalhomobile.Model.Dto.CompartilhamentoDto;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "compartilhamento_tb",
        uniqueConstraints={
                @UniqueConstraint(columnNames = {"usuario_envio_id", "usuario_recebimento_id", "heroi_id"})
        })
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

    @Column(name = "data_operacao")
    private Timestamp dataOperação;

    public static Compartilhamento create(Usuario usuarioEnvio, Usuario usuarioRecebimento, Heroi heroi){
        Compartilhamento model = new Compartilhamento();
        model.setDataOperação(Timestamp.valueOf(LocalDateTime.now()));
        model.setHeroi(heroi);
        model.setUsuarioEnvio(usuarioEnvio);
        model.setUsuarioRecebimento(usuarioRecebimento);
        return model;
    }

}

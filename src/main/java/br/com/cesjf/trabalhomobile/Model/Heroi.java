package br.com.cesjf.trabalhomobile.Model;

import br.com.cesjf.trabalhomobile.Model.Dto.HeroiDto;
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

    @Column(name = "url_imagem")
    private String urlImagem;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id", referencedColumnName = "status_id")
    private Status status;

    @OneToMany(mappedBy = "heroi")
    private List<Favorito> favoritos;

    public Heroi(Long id, Long idApi, String nome, String alterEgo, String urlImagem, Status status){
        this.id = id;
        this.idApi = idApi;
        this.nome = nome;
        this.alterEgo = alterEgo;
        this.urlImagem = urlImagem;
        this.status = status;
    }

    public static Heroi create(HeroiDto dto){
        Heroi heroi = new Heroi();
        Status status = new Status();
        heroi.setAlterEgo(dto.getAlterEgo());
        heroi.setIdApi(Long.valueOf(dto.getIdApi()));
        heroi.setNome(dto.getNome());
        heroi.setUrlImagem(dto.getUrlImagem());
        status.setAltura(dto.getAltura());
        status.setCombate(Integer.parseInt(dto.getCombate()));
        status.setForca(Integer.parseInt(dto.getForca()));
        status.setInteligencia(Integer.parseInt(dto.getInteligencia()));
        status.setPeso(dto.getPeso());
        status.setPoder(Integer.parseInt(dto.getPoder()));
        status.setResistencia(Integer.parseInt(dto.getResistencia()));
        status.setVelocidade(Integer.parseInt(dto.getVelocidade()));
        heroi.setStatus(status);
        return heroi;
    }

}

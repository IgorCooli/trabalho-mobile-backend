package br.com.cesjf.trabalhomobile.Model.Dto;

import br.com.cesjf.trabalhomobile.Model.Favorito;
import br.com.cesjf.trabalhomobile.Model.Heroi;
import br.com.cesjf.trabalhomobile.Model.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class HeroiDto {

    private String id;

    private String idApi;

    private String nome;

    private String alterEgo;

    private String urlImagem;

    private String altura;

    private String peso;

    private String inteligencia;

    private String forca;

    private String velocidade;

    private String resistencia;

    private String poder;

    private String combate;

    public static HeroiDto create(Heroi model) {
        HeroiDto dto = new HeroiDto();
        dto.setId(model.getId().toString());
        dto.setIdApi(model.getIdApi().toString());
        dto.setNome(model.getNome());
        dto.setAlterEgo(model.getAlterEgo());
        dto.setUrlImagem(model.getUrlImagem());
        dto.setAltura(model.getStatus().getAltura());
        dto.setPeso(model.getStatus().getPeso());
        dto.setInteligencia(String.valueOf(model.getStatus().getInteligencia()));
        dto.setForca(String.valueOf(model.getStatus().getForca()));
        dto.setVelocidade(String.valueOf(model.getStatus().getVelocidade()));
        dto.setResistencia(String.valueOf(model.getStatus().getResistencia()));
        dto.setPoder(String.valueOf(model.getStatus().getPoder()));
        dto.setCombate(String.valueOf(model.getStatus().getCombate()));
        return dto;
    }
}

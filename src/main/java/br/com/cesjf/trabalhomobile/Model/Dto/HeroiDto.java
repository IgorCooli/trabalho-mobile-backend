package br.com.cesjf.trabalhomobile.Model.Dto;

import br.com.cesjf.trabalhomobile.Model.Favorito;
import br.com.cesjf.trabalhomobile.Model.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
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

}

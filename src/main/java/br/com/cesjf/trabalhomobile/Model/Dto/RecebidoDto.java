package br.com.cesjf.trabalhomobile.Model.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;
import java.util.TimeZone;

@Getter
@Setter
@NoArgsConstructor
public class RecebidoDto {

    private Long usuarioEnvioId;

    private Timestamp dataOperacao;

    private Long id;

    private Long idApi;

    private String nome;

    private String alterEgo;

    private String urlImagem;

    private String altura;

    private String peso;

    private int inteligencia;

    private int forca;

    private int velocidade;

    private int resistencia;

    private int poder;

    private int combate;

    public RecebidoDto(Long usuarioEnvioId, Date dataOperacao, Long id, Long idApi, String nome, String alterEgo, String urlImagem, String altura, String peso, int inteligencia, int forca, int velocidade, int resistencia, int poder, int combate) {
        this.usuarioEnvioId = usuarioEnvioId;
        this.dataOperacao = Timestamp.valueOf(dataOperacao.toString());
        this.id = id;
        this.idApi = idApi;
        this.nome = nome;
        this.alterEgo = alterEgo;
        this.urlImagem = urlImagem;
        this.altura = altura;
        this.peso = peso;
        this.inteligencia = inteligencia;
        this.forca = forca;
        this.velocidade = velocidade;
        this.resistencia = resistencia;
        this.poder = poder;
        this.combate = combate;
    }
}

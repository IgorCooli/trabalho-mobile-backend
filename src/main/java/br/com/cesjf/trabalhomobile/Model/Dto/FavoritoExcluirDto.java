package br.com.cesjf.trabalhomobile.Model.Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FavoritoExcluirDto {

    private Long usuarioId;
    private Long heroiId;

}

package br.com.cesjf.trabalhomobile.Model.Dto;

import br.com.cesjf.trabalhomobile.Model.Compartilhamento;
import br.com.cesjf.trabalhomobile.Model.Favorito;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CadastroDto {

    private String nomeCompleto;

    private String email;

    private String senha;

    private String nomeUsuario;

}

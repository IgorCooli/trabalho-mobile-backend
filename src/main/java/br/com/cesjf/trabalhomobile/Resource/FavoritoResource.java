package br.com.cesjf.trabalhomobile.Resource;

import br.com.cesjf.trabalhomobile.Model.Dto.FavoritarDto;
import br.com.cesjf.trabalhomobile.Model.Dto.FavoritoExcluirDto;
import br.com.cesjf.trabalhomobile.Model.Dto.HeroiDto;
import br.com.cesjf.trabalhomobile.Service.FavoritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/myhero/favoritos")
@CrossOrigin
public class FavoritoResource {

    @Autowired
    FavoritoService service;

    @PostMapping("/favoritar")
    public ResponseEntity<Boolean> favoritar(@RequestBody FavoritarDto dto){
        Boolean response = service.favoritar(dto);
        return response ?
                ResponseEntity.status(HttpStatus.CREATED).body(response)
                : ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(response);
    }

    @GetMapping("/listar/{usuarioId}")
    public List<HeroiDto> listar(@PathVariable Long usuarioId){
        List<HeroiDto> lista = service.listar(usuarioId);
        return lista;
    }

    @PostMapping("/excluir")
    public Boolean excluir(@RequestBody FavoritoExcluirDto dto){
        return service.excluir(dto);
    }

}

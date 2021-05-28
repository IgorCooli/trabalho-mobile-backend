package br.com.cesjf.trabalhomobile.Resource;

import br.com.cesjf.trabalhomobile.Model.Dto.FavoritarDto;
import br.com.cesjf.trabalhomobile.Service.FavoritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}

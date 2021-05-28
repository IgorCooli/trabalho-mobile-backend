package br.com.cesjf.trabalhomobile.Resource;

import br.com.cesjf.trabalhomobile.Model.Dto.HeroiDto;
import br.com.cesjf.trabalhomobile.Service.HeroiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/myhero/herois")
@CrossOrigin
public class HeroiResource {

    @Autowired
    HeroiService heroiService;

    @GetMapping("/buscar-por-nome-api/{nome}")
    public List<HeroiDto> buscarPorNomeAPI(@PathVariable String nome){
        return heroiService.buscarPorNomeAPI(nome);
    }

    @GetMapping("/buscar-por-id-api/{idApi}")
    public HeroiDto buscarPorIdApi(@PathVariable String idApi){
        return heroiService.buscarPorIdApi(idApi);
    }

}

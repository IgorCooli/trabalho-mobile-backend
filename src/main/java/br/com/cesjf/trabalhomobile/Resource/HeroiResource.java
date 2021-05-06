package br.com.cesjf.trabalhomobile.Resource;

import br.com.cesjf.trabalhomobile.Service.HeroiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myhero/herois")
public class HeroiResource {

    @Autowired
    HeroiService heroiService;

    @GetMapping("/buscar-por-nome-api/{nome}")
    public Object buscarPorNomeAPI(@PathVariable String nome){
        return heroiService.buscarPorNomeAPI(nome);
    }

}

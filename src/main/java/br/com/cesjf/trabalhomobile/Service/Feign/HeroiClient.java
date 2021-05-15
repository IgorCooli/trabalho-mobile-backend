package br.com.cesjf.trabalhomobile.Service.Feign;

import br.com.cesjf.trabalhomobile.Model.Dto.HeroiDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "superhero-api", url = "https://superheroapi.com/api/${API_KEY}")
public interface HeroiClient {

    @GetMapping(value = "/search/{nome}", produces = "application/json")
    Object buscarPorNome(@PathVariable String nome);

}

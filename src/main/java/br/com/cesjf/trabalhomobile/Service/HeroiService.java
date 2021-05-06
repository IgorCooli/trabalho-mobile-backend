package br.com.cesjf.trabalhomobile.Service;

import br.com.cesjf.trabalhomobile.Service.Feign.HeroiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeroiService {

    @Autowired
    HeroiClient heroiClient;

    public Object buscarPorNomeAPI(String nome){
        return heroiClient.buscarPorNome(nome);
    }

}

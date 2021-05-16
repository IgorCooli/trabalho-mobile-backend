package br.com.cesjf.trabalhomobile.Service;

import br.com.cesjf.trabalhomobile.Mapper.HeroiApiMapper;
import br.com.cesjf.trabalhomobile.Model.Dto.HeroiDto;
import br.com.cesjf.trabalhomobile.Service.Feign.HeroiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class HeroiService {

    @Autowired
    HeroiClient heroiClient;

    public List<HeroiDto> buscarPorNomeAPI(String nome){
        return HeroiApiMapper.mapper(heroiClient.buscarPorNome(nome));
    }

}

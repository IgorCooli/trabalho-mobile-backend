package br.com.cesjf.trabalhomobile.Service;

import br.com.cesjf.trabalhomobile.Mapper.HeroiApiMapper;
import br.com.cesjf.trabalhomobile.Mapper.HeroisApiMapper;
import br.com.cesjf.trabalhomobile.Model.Dto.HeroiDto;
import br.com.cesjf.trabalhomobile.Model.Heroi;
import br.com.cesjf.trabalhomobile.Repository.HeroiRepository;
import br.com.cesjf.trabalhomobile.Service.Feign.HeroiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroiService {

    @Autowired
    HeroiClient heroiClient;
    @Autowired
    HeroiRepository repository;

    public List<HeroiDto> buscarPorNomeAPI(String nome){
        return HeroisApiMapper.mapper(heroiClient.buscarPorNome(nome));
    }

    public HeroiDto buscarPorIdApi(String idApi){
        return HeroiApiMapper.mapper(heroiClient.buscarPorIdAPi(idApi));
    }

    public Heroi findById(Long id){
        return repository.findById(id).get();
    }

    public Heroi findByIdApi(Long idApi){
        return repository.findByIdApi(idApi).get();
    }

    public void save(Heroi heroi){
        repository.save(heroi);
    }

}

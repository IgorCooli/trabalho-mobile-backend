package br.com.cesjf.trabalhomobile.Service;

import br.com.cesjf.trabalhomobile.Model.Dto.FavoritarDto;
import br.com.cesjf.trabalhomobile.Model.Dto.FavoritoExcluirDto;
import br.com.cesjf.trabalhomobile.Model.Dto.HeroiDto;
import br.com.cesjf.trabalhomobile.Model.Favorito;
import br.com.cesjf.trabalhomobile.Model.Heroi;
import br.com.cesjf.trabalhomobile.Repository.FavoritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavoritoService {

    @Autowired
    FavoritoRepository repository;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    HeroiService heroiService;

    public Boolean favoritar(FavoritarDto dto) {
        Heroi heroi;
        try {
            heroi = heroiService.findByIdApi(Long.valueOf(dto.getIdHeroiApi()));
        }catch (Exception e){
            HeroiDto heroiDto = heroiService.buscarPorIdApi(dto.getIdHeroiApi());
            heroi = Heroi.create(heroiDto);
            heroiService.save(heroi);
        }
        try {
            repository.save(Favorito.create(usuarioService.findById(dto.getUsuarioId()), heroi));
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public List<HeroiDto> listar(Long usuarioId) {
        List<Heroi> lista = repository.listar(usuarioId);
        List<HeroiDto> retorno = new ArrayList<>();
        lista.forEach(heroi -> {
            retorno.add(HeroiDto.create(heroi));
        });
        return retorno;
    }

    public Boolean excluir(FavoritoExcluirDto dto) {
        Boolean retorno = true;
        try {
            Favorito favorito = repository.buscarPorUsuarioEHeroi(dto.getHeroiId(), dto.getUsuarioId());
            repository.delete(favorito);
        }catch (Exception e){
            retorno = false;
        }
        return retorno;
    }
}

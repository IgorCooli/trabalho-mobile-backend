package br.com.cesjf.trabalhomobile.Service;

import br.com.cesjf.trabalhomobile.Model.Dto.FavoritarDto;
import br.com.cesjf.trabalhomobile.Model.Dto.HeroiDto;
import br.com.cesjf.trabalhomobile.Model.Favorito;
import br.com.cesjf.trabalhomobile.Model.Heroi;
import br.com.cesjf.trabalhomobile.Repository.FavoritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

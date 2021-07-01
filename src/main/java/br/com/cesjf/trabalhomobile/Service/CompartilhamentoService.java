package br.com.cesjf.trabalhomobile.Service;

import br.com.cesjf.trabalhomobile.Model.Compartilhamento;
import br.com.cesjf.trabalhomobile.Model.Dto.CompartilhamentoDto;
import br.com.cesjf.trabalhomobile.Model.Dto.HeroiDto;
import br.com.cesjf.trabalhomobile.Model.Dto.RecebidoDto;
import br.com.cesjf.trabalhomobile.Model.Heroi;
import br.com.cesjf.trabalhomobile.Model.Usuario;
import br.com.cesjf.trabalhomobile.Repository.CompartilhamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompartilhamentoService {

    @Autowired
    CompartilhamentoRepository repository;
    @Autowired
    HeroiService heroiService;
    @Autowired
    UsuarioService usuarioService;

    public Boolean compartilhar(CompartilhamentoDto compartilhamento) {

        Heroi heroi;
        Usuario usuarioEnvio;
        Usuario usuarioRecebimento;

        try {
            heroi = heroiService.findByIdApi(Long.valueOf(compartilhamento.getIdHeroiApi()));
        } catch (Exception e) {
            HeroiDto heroiDto = heroiService.buscarPorIdApi(compartilhamento.getIdHeroiApi());
            heroi = Heroi.create(heroiDto);
            heroiService.save(heroi);
        }

        try {
            usuarioEnvio = usuarioService.findById(compartilhamento.getUsuarioEnvioId());
            usuarioRecebimento = usuarioService.findByNomeUsuario(compartilhamento.getUsuarioRecebimentoNome());
        } catch (Exception e) {
            return false;
        }

        try {
            repository.save(Compartilhamento.create(usuarioEnvio, usuarioRecebimento, heroi));
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public List<RecebidoDto> recebidos(Long usuarioId) {
        return repository.recebidos(usuarioId);
    }
}

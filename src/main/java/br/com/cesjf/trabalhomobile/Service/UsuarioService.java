package br.com.cesjf.trabalhomobile.Service;

import br.com.cesjf.trabalhomobile.Model.Dto.CadastroDto;
import br.com.cesjf.trabalhomobile.Model.Dto.LoginDto;
import br.com.cesjf.trabalhomobile.Model.Dto.UsuarioDto;
import br.com.cesjf.trabalhomobile.Model.Usuario;
import br.com.cesjf.trabalhomobile.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    public UsuarioDto logar(LoginDto login) {
        return repository.logar(login.getEmail(), login.getSenha());
    }

    public Boolean cadastrar(CadastroDto cadastro) {
        try {
            repository.save(Usuario.createFromCadastro(cadastro));
        }catch (Exception e){
            return Boolean.valueOf(false);
        }
        return Boolean.valueOf(true);
    }

    public Usuario findById(Long id){
        return repository.findById(id).get();
    }

    public List<UsuarioDto> buscarUsuario(String usuario) {
        return repository.findByUsuario(usuario);
    }

    public Usuario findByNomeUsuario(String usuarioRecebimentoNome) {
        return repository.findByNomeUsuario(usuarioRecebimentoNome);
    }
}

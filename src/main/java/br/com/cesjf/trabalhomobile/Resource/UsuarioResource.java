package br.com.cesjf.trabalhomobile.Resource;

import br.com.cesjf.trabalhomobile.Model.Dto.CadastroDto;
import br.com.cesjf.trabalhomobile.Model.Dto.LoginDto;
import br.com.cesjf.trabalhomobile.Model.Dto.UsuarioDto;
import br.com.cesjf.trabalhomobile.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/myhero/usuario")
@CrossOrigin
public class UsuarioResource {

    @Autowired
    UsuarioService service;

    @PostMapping("/logar")
    public ResponseEntity<?> login(@RequestBody LoginDto login){
        UsuarioDto response = service.logar(login);
        return response != null ?
                ResponseEntity.status(HttpStatus.OK).body(response)
                : ResponseEntity.status(HttpStatus.FORBIDDEN).body("Não foi possível logar!");
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody CadastroDto cadastro){
        Boolean cadastrou = service.cadastrar(cadastro);
        return cadastrou ?
                ResponseEntity.status(HttpStatus.CREATED).body(cadastrou)
                : ResponseEntity.status(HttpStatus.CONFLICT).body(cadastrou);
    }

    @GetMapping("/buscar/{usuario}")
    public ResponseEntity<List<UsuarioDto>> buscar(@PathVariable String usuario){
        List<UsuarioDto> respose = service.buscarUsuario(usuario);
        return respose.size() > 0 ?
               ResponseEntity.status(HttpStatus.OK).body(respose)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(respose);
    }

}

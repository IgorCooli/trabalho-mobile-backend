package br.com.cesjf.trabalhomobile.Resource;

import br.com.cesjf.trabalhomobile.Model.Dto.CadastroDto;
import br.com.cesjf.trabalhomobile.Model.Dto.LoginDto;
import br.com.cesjf.trabalhomobile.Model.Dto.UsuarioDto;
import br.com.cesjf.trabalhomobile.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myhero/usuario")
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
    public ResponseEntity<?> cadastrar(CadastroDto cadastro){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(cadastro));
    }

}

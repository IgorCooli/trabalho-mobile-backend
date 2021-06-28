package br.com.cesjf.trabalhomobile.Resource;

import br.com.cesjf.trabalhomobile.Model.Dto.CompartilhamentoDto;
import br.com.cesjf.trabalhomobile.Model.Dto.RecebidoDto;
import br.com.cesjf.trabalhomobile.Service.CompartilhamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/myhero/compartilhamento")
@CrossOrigin
public class CompartilhamentoResource {

    @Autowired
    CompartilhamentoService service;

    @PostMapping("/compartilhar")
    public ResponseEntity<Boolean> compartilhar(@RequestBody CompartilhamentoDto compartilhamento){
        Boolean compartilhado = service.compartilhar(compartilhamento);
        return compartilhado ?
                ResponseEntity.status(HttpStatus.CREATED).body(compartilhado)
                : ResponseEntity.status(HttpStatus.FORBIDDEN).body(compartilhado);
    }
    
    @GetMapping("/recebidos/{usuarioId}")
    public ResponseEntity<List<RecebidoDto>> recebidos(@PathVariable Long usuarioId){
        return ResponseEntity.status(HttpStatus.OK).body(service.recebidos(usuarioId));
    }

}

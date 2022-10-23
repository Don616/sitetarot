package don616.apitarot.controller;

import don616.apitarot.controller.form.CadastrarTiragem;
import don616.apitarot.model.entity.EnumEstiloTiragem;
import don616.apitarot.model.service.TiragemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tiragens")
public class TiragemController {

    @Autowired
    TiragemService tiragemService;

    @PostMapping
    public ResponseEntity<?> postTiragem(@RequestBody @Valid List<CadastrarTiragem> tiragem){
        return tiragemService.cadastrarTiragem(tiragem);
    }

    @GetMapping("/{id}/{idEnum}")
    public ResponseEntity<?> fazerTiragem(@PathVariable Long id, @PathVariable Integer idEnum){
        return tiragemService.fazerTiragem(id,EnumEstiloTiragem.fromInteger(idEnum));
    }

    @GetMapping("/{idEnum}")
    public ResponseEntity<?> fazerTiragem(@PathVariable Integer idEnum){

        return tiragemService.fazerTiragem(EnumEstiloTiragem.fromInteger(idEnum));
    }

}

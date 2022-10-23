package don616.apitarot.controller;

import don616.apitarot.controller.form.CadastrarTiragem;
import don616.apitarot.model.service.TiragemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

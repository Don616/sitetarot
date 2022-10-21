package don616.apitarot.controller;

import don616.apitarot.model.entity.Arcano;
import don616.apitarot.model.service.ArcanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/arcanos")
public class ArcanoController {

    @Autowired
    ArcanoService arcanoService;

    @GetMapping
    public ResponseEntity<?> getArcanos(){
        return arcanoService.getArcanos();
    }

    @GetMapping("/{numero}")
    public ResponseEntity<?> getArcano(@PathVariable @Value("") Integer numero){
        return arcanoService.getArcano(numero);
    }

}

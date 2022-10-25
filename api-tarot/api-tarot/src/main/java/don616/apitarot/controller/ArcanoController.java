package don616.apitarot.controller;

import don616.apitarot.service.ArcanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@RestController
@RequestMapping("/arcanos")
public class ArcanoController {

    @Autowired
    ArcanoService arcanoService;

    @GetMapping
    public ResponseEntity<?> getArcanos(){
        return arcanoService.getArcanos();
    }

    @GetMapping("/find")
    public ResponseEntity<?> getArcanosParam(@RequestParam HashMap<String, String> param){
        return arcanoService.getArcanosParam(param);
    }

    @GetMapping("/{numero}")
    public ResponseEntity<?> getArcano(@PathVariable Integer numero){
        return arcanoService.getArcano(numero);
    }

}

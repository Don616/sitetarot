package don616.apitarot.service;

import don616.apitarot.entity.ArcanoEntity;
import don616.apitarot.repository.ArcanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ArcanoService {
    
    @Autowired
    ArcanoRepository arcanoRepository;

    @Autowired
    BuscaPorParametroService buscaPorParametroService;

    public ResponseEntity<?> getArcanos() {
        List<ArcanoEntity> listaArcanos = arcanoRepository.findAll();
        if(listaArcanos.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(listaArcanos);
    }

    public ResponseEntity<?> getArcano(Integer numero) {
        if(numero>=0&&numero<=77){
            ArcanoEntity arcano = arcanoRepository.findByNumero(numero);
            return ResponseEntity.status(200).body(arcano);
        }
        return ResponseEntity.status(404).body("Arcano não encontrado");
    }

    public ResponseEntity<?> getArcanosParam(HashMap<String, String> param) {
        return buscaPorParametroService.buscaParam(param);
    }
}

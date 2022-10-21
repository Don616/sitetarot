package don616.apitarot.model.service;

import don616.apitarot.model.entity.Arcano;
import don616.apitarot.repository.ArcanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArcanoService {
    
    @Autowired
    ArcanoRepository arcanoRepository;

    public ResponseEntity<?> getArcanos() {
        List<Arcano> listaArcanos = arcanoRepository.findAll();
        if(listaArcanos.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(listaArcanos);
    }

    public ResponseEntity<?> getArcano(Integer numero) {
        if(numero>=0&&numero<=77){
            Arcano arcano = arcanoRepository.findByNumero(numero);
            return ResponseEntity.status(200).body(arcano);
        }
        return ResponseEntity.status(404).body("Arcano não encontrado");
    }
}

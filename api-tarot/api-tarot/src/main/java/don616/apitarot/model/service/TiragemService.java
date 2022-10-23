package don616.apitarot.model.service;

import don616.apitarot.controller.form.CadastrarTiragem;
import don616.apitarot.model.entity.Tiragem;
import don616.apitarot.repository.TiragemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TiragemService {

    @Autowired
    TiragemRepository tiragemRepository;


    public ResponseEntity<?> cadastrarTiragem(List<CadastrarTiragem> tiragens) {
        String uuid = String.valueOf(new UUIDTiragemIdService());
        Integer posicao = 0;
        for(CadastrarTiragem tiragem : tiragens){
            Tiragem novaTiragem = tiragem.criarTiragem(tiragem,uuid,posicao);
            posicao++;
            tiragemRepository.save(novaTiragem);
        }

        return ResponseEntity.status(201).build();
    }
}

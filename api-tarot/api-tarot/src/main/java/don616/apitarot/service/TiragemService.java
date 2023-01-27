package don616.apitarot.service;

import don616.apitarot.dtos.request.CadastrarTiragemReq;
import don616.apitarot.entity.ArcanoEntity;
import don616.apitarot.enums.EnumEstiloTiragem;
import don616.apitarot.entity.TiragemEntity;
import don616.apitarot.entity.UsuarioEntity;
import don616.apitarot.repository.TiragemRepository;
import don616.apitarot.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TiragemService {

    @Autowired
    TiragemRepository tiragemRepository;

    @Autowired
    JogadasService jogadasService;

    @Autowired
    UsuarioRepository usuarioRepository;

    public ResponseEntity<?> cadastrarTiragem(List<CadastrarTiragemReq> tiragens) {
        String uuid = UUID.randomUUID().toString();
        Integer posicao = 0;
        for(CadastrarTiragemReq tiragem : tiragens){
            TiragemEntity novaTiragem = tiragem.criarTiragem(tiragem,uuid,posicao);
            posicao++;
            tiragemRepository.save(novaTiragem);
        }

        return ResponseEntity.status(201).build();
    }

    public ResponseEntity<?> fazerTiragem(Long id, EnumEstiloTiragem estiloTiragem) {
        List<ArcanoEntity> listaArcanos = jogadasService.fazerJogada(estiloTiragem);
        List<CadastrarTiragemReq> tiragens = new ArrayList<>();
        Optional<UsuarioEntity> usuario = usuarioRepository.findById(id);
        if(usuario.isPresent()){

            for(ArcanoEntity arcano : listaArcanos){
                Boolean isReversa = jogadasService.isReversa();
                CadastrarTiragemReq tiragem = new CadastrarTiragemReq(estiloTiragem,isReversa,usuario.get(),arcano);
                tiragens.add(tiragem);
            }

            this.cadastrarTiragem(tiragens);
            return ResponseEntity.status(200).body(tiragens);
        }

        return ResponseEntity.status(404).build();
    }

    public ResponseEntity<?> fazerTiragem(EnumEstiloTiragem estiloTiragem) {
        List<ArcanoEntity> listaArcanos = jogadasService.fazerJogada(estiloTiragem);
        List<CadastrarTiragemReq> tiragens = new ArrayList<>();

        for(ArcanoEntity arcano : listaArcanos) {
            Boolean isReversa = jogadasService.isReversa();
            CadastrarTiragemReq tiragem = new CadastrarTiragemReq(estiloTiragem, isReversa, null, arcano);
            tiragens.add(tiragem);
        }
        return ResponseEntity.status(200).body(tiragens);


    }
}

package don616.apitarot.model.service;

import don616.apitarot.controller.form.CadastrarTiragem;
import don616.apitarot.model.entity.Arcano;
import don616.apitarot.model.entity.EnumEstiloTiragem;
import don616.apitarot.model.entity.Tiragem;
import don616.apitarot.model.entity.Usuario;
import don616.apitarot.repository.TiragemRepository;
import don616.apitarot.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TiragemService {

    @Autowired
    TiragemRepository tiragemRepository;

    @Autowired
    JogadasService jogadasService;

    @Autowired
    UsuarioRepository usuarioRepository;

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

    public ResponseEntity<?> fazerTiragem(Long id, EnumEstiloTiragem estiloTiragem) {
        List<Arcano> listaArcanos = jogadasService.fazerJogada(estiloTiragem);
        List<CadastrarTiragem> tiragens = new ArrayList<>();
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isPresent()){

            for(Arcano arcano : listaArcanos){
                Boolean isReversa = jogadasService.isReversa();
                CadastrarTiragem tiragem = new CadastrarTiragem(estiloTiragem,isReversa,usuario.get(),arcano);
                tiragens.add(tiragem);
            }

            this.cadastrarTiragem(tiragens);
            return ResponseEntity.status(200).body(tiragens);
        }

        return ResponseEntity.status(404).build();
    }

    public ResponseEntity<?> fazerTiragem(EnumEstiloTiragem estiloTiragem) {
        List<Arcano> listaArcanos = jogadasService.fazerJogada(estiloTiragem);
        List<CadastrarTiragem> tiragens = new ArrayList<>();

        for(Arcano arcano : listaArcanos) {
            Boolean isReversa = jogadasService.isReversa();
            CadastrarTiragem tiragem = new CadastrarTiragem(estiloTiragem, isReversa, null, arcano);
            tiragens.add(tiragem);
        }
        return ResponseEntity.status(200).body(tiragens);


    }
}

package don616.apitarot.model.service;

import don616.apitarot.model.entity.Arcano;
import don616.apitarot.model.entity.EnumEstiloTiragem;
import don616.apitarot.repository.ArcanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Service
public class JogadasService {

    @Autowired
    ArcanoRepository arcanoRepository;

    private Integer randomNum(Integer min, Integer max){
        return new Random().nextInt((max-min)+1)+min;
    }

    public List<Arcano> fazerJogada(EnumEstiloTiragem estiloTiragem) {

        switch (estiloTiragem){

            case TIRAGEM_UMA_CARTA:
                return this.jogadaTiragemUmaCarta();
            case TIRAGEM_ARCANO_MAIOR_MENOR:
                return this.jogadaArcanoMaiorMenor();
            case TIRAGEM_PASSADO_PRESENTE_FUTURO:
                return this.jogadaPassadoPresenteFuturo();
            default:
                return null;

        }

    }

    private List<Arcano> jogadaPassadoPresenteFuturo() {
        List<Arcano> listaArcanos = new ArrayList<>();
        Integer passado = this.randomNum(0,77);
        Integer presente = this.randomNum(0,77);
        Integer futuro = this.randomNum(0,77);
        Arcano arcanoPassado = arcanoRepository.findByNumero(passado);
        Arcano arcanoPresente = arcanoRepository.findByNumero(presente);
        Arcano arcanoFuturo = arcanoRepository.findByNumero(futuro);
        listaArcanos.add(arcanoFuturo);
        listaArcanos.add(arcanoPresente);
        listaArcanos.add(arcanoPassado);

        return listaArcanos;

    }

    private List<Arcano> jogadaArcanoMaiorMenor() {

        Integer numArcanoMaior = this.randomNum(0,21);
        Integer numArcanoMenor = this.pegarSomenteArcanosMenores();
        Arcano arcanoMaior = arcanoRepository.findByNumero(numArcanoMaior);
        Arcano arcanoMenor = arcanoRepository.findByNumero(numArcanoMenor);
        List<Arcano> listaArcanos = new ArrayList<>();
        listaArcanos.add(arcanoMaior);
        listaArcanos.add(arcanoMenor);

        return listaArcanos;

    }

    private List<Arcano> jogadaTiragemUmaCarta() {

        Integer num = this.randomNum(0,77);
        Arcano arcano = arcanoRepository.findByNumero(num);
        List<Arcano> listaArcanos = new ArrayList<>();
        listaArcanos.add(arcano);


        return listaArcanos;


    }

    private Integer pegarSomenteArcanosMenores(){
        Integer sorteio = this.randomNum(1,4);
        switch (sorteio){
            case 1:
                return this.randomNum(22,31);
            case 2:
                return this.randomNum(36,45);
            case 3:
                return this.randomNum(50,59);
            case 4:
                return this.randomNum(64,73);
        }
        return null;
    }

    public Boolean isReversa(){
        Integer num = this.randomNum(0,10);
        return num == 0;
    }
}

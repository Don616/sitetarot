package don616.apitarot.service;

import don616.apitarot.entity.ArcanoEntity;
import don616.apitarot.enums.EnumEstiloTiragem;
import don616.apitarot.repository.ArcanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<ArcanoEntity> fazerJogada(EnumEstiloTiragem estiloTiragem) {

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

    private List<ArcanoEntity> jogadaPassadoPresenteFuturo() {
        List<ArcanoEntity> listaArcanos = new ArrayList<>();
        Integer passado = this.randomNum(0,77);
        Integer presente = this.randomNum(0,77);
        Integer futuro = this.randomNum(0,77);
        ArcanoEntity arcanoPassado = arcanoRepository.findByNumero(passado);
        ArcanoEntity arcanoPresente = arcanoRepository.findByNumero(presente);
        ArcanoEntity arcanoFuturo = arcanoRepository.findByNumero(futuro);
        listaArcanos.add(arcanoFuturo);
        listaArcanos.add(arcanoPresente);
        listaArcanos.add(arcanoPassado);

        return listaArcanos;

    }

    private List<ArcanoEntity> jogadaArcanoMaiorMenor() {

        Integer numArcanoMaior = this.randomNum(0,21);
        Integer numArcanoMenor = this.pegarSomenteArcanosMenores();
        ArcanoEntity arcanoMaior = arcanoRepository.findByNumero(numArcanoMaior);
        ArcanoEntity arcanoMenor = arcanoRepository.findByNumero(numArcanoMenor);
        List<ArcanoEntity> listaArcanos = new ArrayList<>();
        listaArcanos.add(arcanoMaior);
        listaArcanos.add(arcanoMenor);

        return listaArcanos;

    }

    private List<ArcanoEntity> jogadaTiragemUmaCarta() {

        Integer num = this.randomNum(0,77);
        ArcanoEntity arcano = arcanoRepository.findByNumero(num);
        List<ArcanoEntity> listaArcanos = new ArrayList<>();
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

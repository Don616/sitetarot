package don616.apitarot.dtos.request;

import don616.apitarot.entity.ArcanoEntity;
import don616.apitarot.enums.EnumEstiloTiragem;
import don616.apitarot.entity.TiragemEntity;
import don616.apitarot.entity.UsuarioEntity;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class CadastrarTiragemReq {

    private EnumEstiloTiragem estiloTiragem;
    private Boolean isReversa;
    private UsuarioEntity usuario;
    private ArcanoEntity arcano;

    public CadastrarTiragemReq(){};

    public CadastrarTiragemReq(EnumEstiloTiragem estiloTiragem, Boolean isReversa, UsuarioEntity usuario, ArcanoEntity arcano) {
        this.estiloTiragem = estiloTiragem;
        this.isReversa = isReversa;
        this.usuario = usuario;
        this.arcano = arcano;
    }

    public Boolean getReversa() {
        return isReversa;
    }

    public void setReversa(Boolean reversa) {
        isReversa = reversa;
    }

    public EnumEstiloTiragem getEstiloTiragem() {
        return estiloTiragem;
    }

    public void setEstiloTiragem(EnumEstiloTiragem estiloTiragem) {
        this.estiloTiragem = estiloTiragem;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public ArcanoEntity getArcano() {
        return arcano;
    }

    public void setArcano(ArcanoEntity arcano) {
        this.arcano = arcano;
    }


    public TiragemEntity criarTiragem(CadastrarTiragemReq tiragem, String uuid, Integer posicao) {
        String dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        return new TiragemEntity(uuid,
                tiragem.getEstiloTiragem(),
                dataHora,
                posicao,
                tiragem.getReversa(),
                tiragem.getUsuario(),
                tiragem.getArcano());
    }
}

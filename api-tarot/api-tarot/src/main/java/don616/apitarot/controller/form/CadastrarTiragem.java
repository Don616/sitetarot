package don616.apitarot.controller.form;

import don616.apitarot.model.entity.Arcano;
import don616.apitarot.model.entity.EnumEstiloTiragem;
import don616.apitarot.model.entity.Tiragem;
import don616.apitarot.model.entity.Usuario;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class CadastrarTiragem {

    private EnumEstiloTiragem estiloTiragem;
    private Boolean isReversa;
    private Usuario usuario;
    private Arcano arcano;

    public CadastrarTiragem(){};

    public CadastrarTiragem(EnumEstiloTiragem estiloTiragem, Boolean isReversa, Usuario usuario, Arcano arcano) {
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Arcano getArcano() {
        return arcano;
    }

    public void setArcano(Arcano arcano) {
        this.arcano = arcano;
    }


    public Tiragem criarTiragem(CadastrarTiragem tiragem, String uuid, Integer posicao) {
        String dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        return new Tiragem(uuid,
                tiragem.getEstiloTiragem(),
                dataHora,
                posicao,
                tiragem.getReversa(),
                tiragem.getUsuario(),
                tiragem.getArcano());
    }
}

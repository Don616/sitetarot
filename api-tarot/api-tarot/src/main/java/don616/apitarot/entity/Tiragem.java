package don616.apitarot.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Tiragem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private UUID tiragemId;
    private EnumEstiloTiragem estiloTiragem;
    private String dataHora;
    private Integer posicao;
    private Boolean isReversa;
    @ManyToOne
    @JoinColumn(name = "fk_usuario")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "fk_arcano")
    private Arcano arcano;

    public Tiragem(){}

    public Tiragem(UUID tiragemId,
                   EnumEstiloTiragem estiloTiragem,
                   String dataHora,
                   Integer posicao,
                   Boolean isReversa,
                   Usuario usuario,
                   Arcano arcano) {
        this.tiragemId = tiragemId;
        this.estiloTiragem = estiloTiragem;
        this.dataHora = dataHora;
        this.posicao = posicao;
        this.isReversa = isReversa;
        this.usuario = usuario;
        this.arcano = arcano;
    }

    public Tiragem(Integer id,
                   UUID tiragemId,
                   EnumEstiloTiragem estiloTiragem,
                   String dataHora,
                   Usuario usuario,
                   Arcano arcano) {
        this.id = id;
        this.tiragemId = tiragemId;
        this.estiloTiragem = estiloTiragem;
        this.dataHora = dataHora;
        this.usuario = usuario;
        this.arcano = arcano;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UUID getTiragemId() {
        return tiragemId;
    }

    public void setTiragemId(UUID tiragemId) {
        this.tiragemId = tiragemId;
    }

    public EnumEstiloTiragem getEstiloTiragem() {
        return estiloTiragem;
    }

    public void setEstiloTiragem(EnumEstiloTiragem estiloTiragem) {
        this.estiloTiragem = estiloTiragem;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public Integer getPosicao() {
        return posicao;
    }

    public void setPosicao(Integer posicao) {
        this.posicao = posicao;
    }

    public Boolean getReversa() {
        return isReversa;
    }

    public void setReversa(Boolean reversa) {
        isReversa = reversa;
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
}

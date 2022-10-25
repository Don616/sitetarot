package don616.apitarot.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Arcano {

    @Id
    private Integer numero;
    private String nome;
    private String categoria;
    private String titulo;
    private String naipe;
    private String correspondenciaAstrologica;
    private String letraHebraica;
    private String runaNordica;


    public Arcano(){}

    public Arcano(Integer numero,
                  String nome,
                  String categoria,
                  String titulo,
                  String naipe,
                  String correspondenciaAstrologica,
                  String letraHebraica,
                  String runaNordica) {

        this.numero = numero;
        this.nome = nome;
        this.categoria = categoria;
        this.titulo = titulo;
        this.naipe = naipe;
        this.correspondenciaAstrologica = correspondenciaAstrologica;
        this.letraHebraica = letraHebraica;
        this.runaNordica = runaNordica;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNaipe() {
        return naipe;
    }

    public void setNaipe(String naipe) {
        this.naipe = naipe;
    }

    public String getCorrespondenciaAstrologica() {
        return correspondenciaAstrologica;
    }

    public void setCorrespondenciaAstrologica(String correspondenciaAstrologica) {
        this.correspondenciaAstrologica = correspondenciaAstrologica;
    }

    public String getLetraHebraica() {
        return letraHebraica;
    }

    public void setLetraHebraica(String letraHebraica) {
        this.letraHebraica = letraHebraica;
    }

    public String getRunaNordica() {
        return runaNordica;
    }

    public void setRunaNordica(String runaNordica) {
        this.runaNordica = runaNordica;
    }
}

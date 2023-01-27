package don616.apitarot.dtos.request;

import don616.apitarot.entity.UsuarioEntity;


public class CadastrarUsuarioReq {

    private String nome;
    private String email;
    private String senha;
    private Character genero;
    private String dataNascimento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Character getGenero() {
        return genero;
    }

    public void setGenero(Character genero) {
        this.genero = genero;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public UsuarioEntity converter(){
        return new UsuarioEntity(nome,email,senha,genero,dataNascimento);
    }
}

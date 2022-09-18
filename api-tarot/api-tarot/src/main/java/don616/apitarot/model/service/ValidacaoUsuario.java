package don616.apitarot.model.service;

import don616.apitarot.controller.form.CadastrarUsuarioForm;
import don616.apitarot.model.GeneroEnum;

import java.util.Arrays;
import java.util.List;

public class ValidacaoUsuario {

    public String validar(CadastrarUsuarioForm form){

        if(!validarNome(form)){
            return "Nome Inválido";
        }
        if(!validaEmail(form)){
            return "Email Inválido";
        }
        if(!validaSenha(form)){
            return "Senha Inválida";
        }
        if(!validarGenero(form)){
            return "Gênero Inválido";
        }


        return null;
    }

    public Boolean validarNome(CadastrarUsuarioForm form){

        String nome = form.getNome();
        return !nome.isBlank() && nome.length() > 2;
    }

    public Boolean validarGenero(CadastrarUsuarioForm form){

        String genero = String.valueOf(Character.toLowerCase(form.getGenero()));
        List<String> listaGenero = List.of(Arrays.toString(GeneroEnum.values()));
        return listaGenero.get(0).contains(genero);
    }

    public Boolean validaEmail(CadastrarUsuarioForm form){

        String email = form.getEmail();
        return email.contains("@") && email.length() > 10 && email.contains(".");
    }

    public Boolean validaSenha(CadastrarUsuarioForm form){

        String senha = form.getSenha();
        return senha.length()>=8;
    }



}

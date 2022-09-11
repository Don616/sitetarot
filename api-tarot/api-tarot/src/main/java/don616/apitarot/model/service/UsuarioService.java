package don616.apitarot.model.service;

import don616.apitarot.controller.dto.UsuarioDTO;
import don616.apitarot.controller.form.CadastrarUsuarioForm;
import don616.apitarot.model.GeneroEnum;
import don616.apitarot.model.entity.Usuario;
import don616.apitarot.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResponseEntity<String> cadastrarUsuario(CadastrarUsuarioForm form){

        String usuarioInvalido = new ValidacaoUsuario().validar(form);

        if(usuarioInvalido==null) {

            if (usuarioRepository.findByEmail(form.getEmail()).isEmpty()) {
                Usuario usuario = form.converter();
                usuarioRepository.save(usuario);
                return ResponseEntity.status(HttpStatus.CREATED).body("Usuario cadastrado com sucesso");
            } else {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Email já existe na base de dados");
            }

        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(usuarioInvalido);
        }
    }

}

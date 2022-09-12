package don616.apitarot.controller;

import don616.apitarot.controller.dto.UsuarioDTO;
import don616.apitarot.controller.form.CadastrarUsuarioForm;
import don616.apitarot.model.entity.Usuario;
import don616.apitarot.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.transaction.Transactional;
import java.util.Map;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;


    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastrarUsuario(@RequestBody CadastrarUsuarioForm form){
        return usuarioService.cadastrarUsuario(form);
    }

    @GetMapping
    public Page<Usuario> listarUsuarios(Pageable pageable,
                                        @RequestParam Map<String,String> param){


        return usuarioService.listarUsuarios(pageable);
    }




}

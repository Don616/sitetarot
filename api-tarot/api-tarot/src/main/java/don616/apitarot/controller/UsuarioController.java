package don616.apitarot.controller;

import don616.apitarot.dtos.request.CadastrarUsuarioReq;
import don616.apitarot.entity.UsuarioEntity;
import don616.apitarot.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;


    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrarUsuario(@RequestBody @Valid CadastrarUsuarioReq form){
        return usuarioService.cadastrarUsuario(form);
    }

    @GetMapping
    public Page<UsuarioEntity> listarUsuarios(Pageable pageable,
                                              @RequestParam(required = false) Map<String,String> param){
        return usuarioService.listarUsuarios(pageable,param);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUsuarioPorId(@PathVariable Long id){
        return usuarioService.getUsuarioPorId(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarUsuario(@PathVariable Long id){
        return usuarioService.deletarUsuario(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarUsuario(@PathVariable Long id,
                                                   @RequestBody @Valid CadastrarUsuarioReq form){
        return usuarioService.atualizarUsuario(id,form);
    }


}

package com.kataokadev.cadastro_usuario.controller;

import com.kataokadev.cadastro_usuario.business.UsuarioServices;
import com.kataokadev.cadastro_usuario.infrastructure.entities.Usuario;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioServices usuarioServices;

    @PostMapping
    public ResponseEntity<Void> salvarUsuario(@RequestBody Usuario usuario){
        usuarioServices.salvarUsuario(usuario);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Usuario> buscarUsuarioPorId(@RequestParam Integer id){
        return ResponseEntity.ok(usuarioServices.buscarUsuarioPorId(id));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarUsuarioPorId(@RequestParam Integer id){
        usuarioServices.deletarPorId(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarUsuarioPorId(@RequestParam Integer id,
                                                      @RequestBody Usuario usuario){
        usuarioServices.atualizarUsuarioPorId(id, usuario);
        return ResponseEntity.ok().build();
    }

}

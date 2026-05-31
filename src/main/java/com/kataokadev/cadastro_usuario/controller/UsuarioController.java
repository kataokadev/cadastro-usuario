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
    public ResponseEntity<Usuario> buscarUsuarioPorEmail(@RequestParam String email){
        return ResponseEntity.ok(usuarioServices.buscarUsuarioPorEmail(email));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarUsuarioPorEmail(@RequestParam String email){
        usuarioServices.deletarPorEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarUsuarioPorId(@RequestParam Integer id,
                                                      @RequestBody Usuario usuario){
        usuarioServices.atualizarUsuarioPorId(id, usuario);
        return ResponseEntity.ok().build();
    }

}

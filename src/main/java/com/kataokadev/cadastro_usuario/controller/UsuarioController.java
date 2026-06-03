package com.kataokadev.cadastro_usuario.controller;

import com.kataokadev.cadastro_usuario.business.UsuarioServices;
import com.kataokadev.cadastro_usuario.infrastructure.entities.Usuario;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioServices usuarioServices;

    @PostMapping
    public ResponseEntity<Void> saveUsuario(@RequestBody Usuario usuario){
        usuarioServices.saveUsuario(usuario);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Usuario> findUsuarioPorId(@RequestParam Integer id){
        return ResponseEntity.ok(usuarioServices.findUsuarioPorId(id));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUsuarioPorId(@RequestParam Integer id){
        usuarioServices.deletePorId(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateUsuarioPorId(@RequestParam Integer id,
                                                      @RequestBody Usuario usuario){
        usuarioServices.updateUsuarioPorId(id, usuario);
        return ResponseEntity.ok().build();
    }

}

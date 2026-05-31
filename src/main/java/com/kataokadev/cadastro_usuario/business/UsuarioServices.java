package com.kataokadev.cadastro_usuario.business;

import com.kataokadev.cadastro_usuario.infrastructure.entities.Usuario;
import com.kataokadev.cadastro_usuario.infrastructure.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServices {

    private final UsuarioRepository repository;

    public UsuarioServices(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void salvarUsuario(Usuario usuario){
        repository.saveAndFlush(usuario);
    }

    public Usuario buscarUsuarioPorEmail(String email){
        return repository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email não encontrado")
        );
    }

    public void deletarPorEmail(String email){
        repository.deleteByEmail(email);
    }

    public void atualizarUsuarioPorId(Integer id, Usuario usuario){
        Usuario usuarioEntities = repository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não econtrado"));
        Usuario usuarioAtualizado = Usuario.builder()
                .email(usuario.getEmail() != null ? usuario.getEmail()
                        : usuarioEntities.getEmail())
                .name(usuario.getName() != null ? usuario.getName()
                        : usuarioEntities.getName())
                .id(usuarioEntities.getId())
                .build();

        repository.saveAndFlush(usuarioAtualizado);

    }


}

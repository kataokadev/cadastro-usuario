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

    public Usuario buscarUsuarioPorId(Integer id){
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Id não encontrado")
        );
    }

    public void deletarPorId(Integer id){
        repository.deleteById(id);
    }

    public void atualizarUsuarioPorId(Integer id, Usuario usuario){
        Usuario usuarioEntities = repository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não econtrado"));
        Usuario usuarioAtualizado = Usuario.builder()
                .email(usuario.getEmail() != null ? usuario.getEmail()
                        : usuarioEntities.getEmail())
                .nome(usuario.getNome() != null ? usuario.getNome()
                        : usuarioEntities.getNome())
                .id(usuarioEntities.getId())
                .build();

        repository.saveAndFlush(usuarioAtualizado);

    }


}

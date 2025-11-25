package com.example.PlacaSegura.Service;

import com.example.PlacaSegura.Model.Usuario;
import com.example.PlacaSegura.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }
    public Usuario findById(Long id_usuario) {
        return usuarioRepository.findById(id_usuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public Usuario actualizar(Long id_usuario, Usuario updated) {
        Usuario usuario = findById(id_usuario);

        usuario.setNombre(updated.getNombre());
        usuario.setCorreo(updated.getCorreo());
        usuario.setContrasena(updated.getContrasena());

        return usuarioRepository.save(usuario);
    }

    public void eliminar(Long id_usuario) {
        usuarioRepository.deleteById(id_usuario);
    }

    public Optional<Usuario> findByEmail(String email) {
        return usuarioRepository.findAll().stream()
                .filter(u -> u.getCorreo().equals(email))
                .findFirst();
    }

    public Usuario login(String email, String password) {
        return findByEmail(email)
                .filter(u -> u.getContrasena().equals(password))
                .orElse(null);
    }
}

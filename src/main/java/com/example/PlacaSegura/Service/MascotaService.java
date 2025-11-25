package com.example.PlacaSegura.Service;

import com.example.PlacaSegura.Model.Mascota;
import com.example.PlacaSegura.Model.Usuario;
import com.example.PlacaSegura.Repository.MascotaRepository;
import com.example.PlacaSegura.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaService {
    @Autowired
    private MascotaRepository mascotaRepository;
    private UsuarioRepository usuarioRepository;

    public Mascota guardar(Mascota mascota, Long id_usuario) {
        Usuario dueno = usuarioRepository.findById(id_usuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        mascota.setDueno(dueno);
        return mascotaRepository.save(mascota);
    }

    // READ ALL
    public List<Mascota> listar() {
        return mascotaRepository.findAll();
    }

    public Mascota findById(Long id) {
        return mascotaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada"));
    }

    public Mascota actualizar(Long id, Mascota updated) {
        Mascota mascota = findById(id);

        mascota.setNombre(updated.getNombre());
        mascota.setRaza(updated.getRaza());
        mascota.setEdad(updated.getEdad());

        return mascotaRepository.save(mascota);
    }

    public void delete(Long id) {
        mascotaRepository.deleteById(id);
    }
}

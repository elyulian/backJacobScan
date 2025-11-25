package com.example.PlacaSegura.Service;

import com.example.PlacaSegura.Model.Mascota;
import com.example.PlacaSegura.Model.Paseo;
import com.example.PlacaSegura.Repository.MascotaRepository;
import com.example.PlacaSegura.Repository.PaseoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaseoService {
    @Autowired
    private PaseoRepository paseoRepository;
    private  MascotaRepository mascotaRepository;

    public Paseo guardar(Paseo paseo, Long id_mascota) {
        Mascota mascota = mascotaRepository.findById(id_mascota)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada"));

        paseo.setMascota(mascota);
        return paseoRepository.save(paseo);
    }

    public List<Paseo> listar() {
        return paseoRepository.findAll();
    }

    public Paseo findById(Long id) {
        return paseoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paseo no encontrado"));
    }

    public void delete(Long id) {
        paseoRepository.deleteById(id);
    }
}

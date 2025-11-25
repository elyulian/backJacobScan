package com.example.PlacaSegura.Controller;

import com.example.PlacaSegura.Model.Mascota;
import com.example.PlacaSegura.Service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mascota")
public class MascotaController {
    @Autowired
    private MascotaService mascotaService;

    @GetMapping("/guardar")
    public ResponseEntity<Mascota> crear(@RequestBody Mascota mascota, @PathVariable Long id_usuario) {
        mascotaService.guardar(mascota,id_usuario);
        return ResponseEntity.created(null).body(mascota);
    }
    // READ ALL
    @GetMapping
    public ResponseEntity<List<Mascota>> findAll() {
        return ResponseEntity.ok(mascotaService.listar());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Mascota> findById(@PathVariable Long id) {
        return ResponseEntity.ok(mascotaService.findById(id));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Mascota> update(@PathVariable Long id, @RequestBody Mascota mascota) {
        return ResponseEntity.ok(mascotaService.actualizar(id, mascota));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        mascotaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

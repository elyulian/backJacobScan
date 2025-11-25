package com.example.PlacaSegura.Controller;

import com.example.PlacaSegura.Model.Mascota;
import com.example.PlacaSegura.Model.Paseo;
import com.example.PlacaSegura.Service.PaseoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paseo")
public class PaseoController {
    @Autowired
    private PaseoService paseoService;

    @PostMapping("/paseo/{idMascota}")
    public ResponseEntity<Paseo> create(@RequestBody Paseo paseo, @PathVariable Long idMascota) {
        return ResponseEntity.ok(paseoService.guardar(paseo, idMascota));
    }

    @GetMapping
    public ResponseEntity<List<Paseo>> listar() {
        return ResponseEntity.ok(paseoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paseo> findById(@PathVariable Long id) {
        return ResponseEntity.ok(paseoService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        paseoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

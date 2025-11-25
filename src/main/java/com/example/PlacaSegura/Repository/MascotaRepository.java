package com.example.PlacaSegura.Repository;

import com.example.PlacaSegura.Model.Mascota;
import com.example.PlacaSegura.Model.Paseo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long> {
}

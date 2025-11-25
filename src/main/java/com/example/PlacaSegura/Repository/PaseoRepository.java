package com.example.PlacaSegura.Repository;

import com.example.PlacaSegura.Model.Paseo;
import com.example.PlacaSegura.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaseoRepository extends JpaRepository<Paseo, Long> {
}

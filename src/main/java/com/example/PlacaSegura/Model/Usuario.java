
package com.example.PlacaSegura.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;
    @Column(name = "nombre", length = 120, nullable = false)
    private String nombre;
    @Column(name = "correo", length = 150, nullable = false, unique = true)
    private String correo;
    @Column(name = "contrasena", length = 100, nullable = false)
    private String contrasena;
    @Column(name = "telefono", length = 10, nullable = true)
    private String telefono;

    @OneToMany(mappedBy = "dueno", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Mascota> mascotas;

    @OneToMany(mappedBy = "dueno", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Paseo> paseosComoDueno;



}

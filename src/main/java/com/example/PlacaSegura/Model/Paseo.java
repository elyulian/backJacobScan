package com.example.PlacaSegura.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Paseo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_paseo;

    private String fecha;

    private String anotacionesPaseo;

    private Double costo;

    // Muchos paseos son para una mascota
    @ManyToOne
    @JoinColumn(name = "id_mascota", nullable = false)
    @JsonIgnore
    private Mascota mascota;

    // Muchos paseos son agendados por un usuario
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    @JsonIgnore
    private Usuario dueno;
}

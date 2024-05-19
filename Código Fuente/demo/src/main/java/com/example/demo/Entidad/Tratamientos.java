package com.example.demo.Entidad;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tratamientos") // Nombre de la tabla
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tratamientos {

    @Id
    @GeneratedValue // autoincrementable
    private long id;

    @Column(name = "NAME")
    private String nombreTratamiento;

    private double precioC;

    @Column(name = "fecha")
    private LocalDate fecha; // Cambiado a LocalDate

    @ManyToOne
    @JoinColumn(name = "droga_id") // Nombre de la columna en la tabla Tratamientos que hace referencia a la tabla Droga
    private Droga droga;

    @JsonIgnore
    @ManyToOne
    private Perro perro;

    @JsonIgnore
    @ManyToOne
    private Veterinario veterinario;

    // Constructor con atributos propios de la clase
    // Sin atributos de las relaciones
    public Tratamientos(String nombreTratamiento, double precioC, LocalDate fecha) {
        this.nombreTratamiento = nombreTratamiento;
        this.precioC = precioC;
        this.fecha = fecha;
    }
}

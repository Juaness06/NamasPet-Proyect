package com.example.demo.Entidad;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "droga")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Droga {

    @Id
    @GeneratedValue
    private long codigo;

    @Column(name = "NAME")
    private String nombre;
    private double precioV;
    private double precioC;
    private int unidades_C;
    private int unidades_V;

    @JsonIgnore
    @OneToMany(mappedBy = "droga", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tratamientos> tratamientos = new ArrayList<>();

    // Constructor con atributos propios de la clase
    // Sin atributos de las relaciones
    public Droga(String nombre, double precioV, double precioC, int unidades_C, int unidades_V) {
        this.nombre = nombre;
        this.precioV = precioV;
        this.precioC = precioC;
        this.unidades_C = unidades_C;
        this.unidades_V = unidades_V;
    }
}

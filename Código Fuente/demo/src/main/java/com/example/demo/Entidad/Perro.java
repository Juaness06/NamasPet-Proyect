package com.example.demo.Entidad;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "perro") // nombre de la tabla
@NoArgsConstructor
@AllArgsConstructor
public class Perro {

    @Id
    @GeneratedValue // autoincrementable
    private long id;

    @Column(name = "imagen", length = 512) // columna
    private String imagen;

    @Column(name = "NAME")
    private String nombre;
    private String raza;
    private int edad;
    private boolean actividad;
    private double peso;
    private int numeroAtenciones;

    @JsonIgnore
    @ManyToOne // relación uno a muchos
    private Cliente cliente;

    @JsonIgnore
    @OneToMany(mappedBy = "perro", cascade = CascadeType.ALL, orphanRemoval = true) // relación uno a muchos
    private List<Tratamientos> tratamientos = new ArrayList<>();

    // Constructor con atributos propios de la clase
    // Sin atributos de las relaciones
    public Perro(String imagen, String nombre, String raza, int edad, boolean actividad, double peso, int numeroAtenciones) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.actividad = actividad;
        this.peso = peso;
        this.numeroAtenciones = numeroAtenciones;
    }
}

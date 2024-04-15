package com.example.demo.Entidad;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tratamientos") // Nombre de la tabla
public class Tratamientos {

    @Id
    @GeneratedValue // autoincrementable
    private long id;

    @Column(name = "NAME")
    private String nombre;
    private double precio;
    private Date fecha;

    @JsonIgnore
    @ManyToOne
    private Droga droga;

    @JsonIgnore
    @ManyToOne
    private Perro perro;

    @JsonIgnore
    @ManyToOne
    private Veterinario veterinario; // Nombre corregido

    // Constructor, getters y setters...

    public Tratamientos(String nombre, double precio, Date fecha) {
        this.nombre = nombre;
        this.precio = precio;
        this.fecha = fecha;
    }

    public Tratamientos() {
    }

    // ID, nombre, precio, fecha getters y setters...

    public Droga getDroga() {
        return droga;
    }

    public void setDroga(Droga droga) {
        this.droga = droga;
    }

    public Perro getPerro() {
        return perro;
    }

    public void setPerro(Perro perro) {
        this.perro = perro;
    }

    public Veterinario getVeterinario() { // Método getter corregido
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) { // Método setter corregido
        this.veterinario = veterinario;
    }

    public Tratamientos findById(Long id2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
}

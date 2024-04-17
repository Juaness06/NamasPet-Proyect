package com.example.demo.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    private double precioV;
    private double precioC;
    private int unidades_C;
    private int unidades_V;

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

    public Tratamientos() {
    }

    // ID, nombre, precio, fecha getters y setters...

    public Tratamientos(long id, String nombre, double precioV, double precioC, int unidades_C, int unidades_V) {
        this.id = id;
        this.nombre = nombre;
        this.precioV = precioV;
        this.precioC = precioC;
        this.unidades_C = unidades_C;
        this.unidades_V = unidades_V;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioV() {
        return precioV;
    }

    public void setPrecioV(double precioV) {
        this.precioV = precioV;
    }

    public double getPrecioC() {
        return precioC;
    }

    public void setPrecioC(double precioC) {
        this.precioC = precioC;
    }

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

    public int getUnidades_V() {
        return unidades_V;
    }

    public void setUnidades_V(int unidades_V) {
        this.unidades_V = unidades_V;
    }

    public int getUnidades_C() {
        return unidades_C;
    }

    public void setUnidades_C(int unidades_C) {
        this.unidades_C = unidades_C;
    }
}

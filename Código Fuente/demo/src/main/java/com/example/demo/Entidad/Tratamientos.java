package com.example.demo.Entidad;

import java.time.LocalDate; // Solo se necesita esta importación para la fecha

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tratamientos") // Nombre de la tabla
public class Tratamientos {

    @Id
    @GeneratedValue // autoincrementable
    private long id;

    @Column(name = "NAME")
    private String nombreTratamiento;

    private double precioC;

    @Column(name = "fecha")
    private LocalDate fecha; // Cambiado a LocalDate

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "droga_id") // Nombre de la columna en la tabla Tratamientos que hace referencia a la tabla Droga
    private Droga droga;
    

    @JsonIgnore
    @ManyToOne
    private Perro perro;

    @JsonIgnore
    @ManyToOne
    private Veterinario veterinario;

    // Constructor, getters y setters...

    public Tratamientos() {
    }

    public Tratamientos(long id, String nombreTratamiento, double precioC, LocalDate fecha) {
        this.id = id;
        this.nombreTratamiento = nombreTratamiento;
        this.precioC = precioC;
        this.fecha = fecha;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreTratamiento() {
        return nombreTratamiento;
    }

    public void setNombreTratamiento(String nombreTratamiento) {
        this.nombreTratamiento = nombreTratamiento;
    }

    public double getPrecioC() {
        return precioC;
    }

    public void setPrecioC(double precioC) {
        this.precioC = precioC;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
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

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }
}

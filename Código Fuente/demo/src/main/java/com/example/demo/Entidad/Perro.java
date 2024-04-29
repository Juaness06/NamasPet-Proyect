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
import lombok.Data;

@Entity
@Data
@Table(name = "perro") // nombre de la tabla
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
    @ManyToOne // relacion uno a muchos
    private Cliente cliente;

    @JsonIgnore
    @OneToMany(mappedBy = "perro", cascade = CascadeType.ALL, orphanRemoval = true) // relacion uno a muchos
    private List<Tratamientos> tratamientos = new ArrayList<>();

    public Perro(String imagen, String nombre, long id, String raza, int edad, boolean actividad, double peso,
            int numeroAtenciones) { // constructor con parámetros
        this.imagen = imagen;
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.actividad = actividad;
        this.peso = peso;
        this.numeroAtenciones = numeroAtenciones;
    }

    public Perro(String imagen, String nombre, String raza, int edad, boolean actividad, double peso,
            int numeroAtenciones, Cliente cliente) { // constructor con parámetros
        this.imagen = imagen;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.peso = peso;
    }

    public Perro(String imagen, long id, String nombre, String raza, int edad, boolean actividad, double peso,
            int numeroAtenciones) { // constructor con parámetros
        this.imagen = imagen;
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.actividad = actividad;
        this.peso = peso;
        this.numeroAtenciones = numeroAtenciones;
    }

    public Perro() {
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean getActividad() {
        return actividad;
    }

    public void setActividad(boolean actividad) {
        this.actividad = actividad;
    }

    public int getNumeroAtenciones() {
        return numeroAtenciones;
    }

    public void setNumeroAtenciones(int numeroAtenciones) {
        this.numeroAtenciones = numeroAtenciones;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Tratamientos> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(List<Tratamientos> tratamientos) {
        this.tratamientos = tratamientos;
    }

}

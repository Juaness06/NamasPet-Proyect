package com.example.demo.Entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "perro")
public class Perro {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "NAME")
    private String imagen;
    private String nombre;
    private String raza;
    private int edad;
    private boolean actividad;
    private double peso;
    private int numeroAtenciones;

    @ManyToOne
    private Cliente cliente;

    public Perro(String imagen, String nombre, long id, String raza, int edad, boolean actividad, double peso, int numeroAtenciones) {
        this.imagen = imagen;
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.actividad = actividad;
        this.peso = peso;
        this.numeroAtenciones = numeroAtenciones;
    }
    public Perro(String imagen, String nombre, String raza, int edad, boolean actividad, double peso, int numeroAtenciones, Cliente cliente) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.peso = peso;
    }
    public Perro(String imagen, long id, String nombre, String raza, int edad, boolean actividad, double peso, int numeroAtenciones) {
        this.imagen = imagen;
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.actividad = actividad;
        this.peso = peso;
        this.numeroAtenciones = numeroAtenciones;
    }
    
    public Perro(){
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

    public boolean isActividad() {
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
}

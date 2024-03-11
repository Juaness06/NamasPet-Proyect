package com.example.demo.Entidad;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "droga") // nombre de la tabla
public class Droga {

    @Id
    @GeneratedValue // autoincrementable
    private long codigo;

    @Column(name = "NAME") // columna
    private String nombre;

    
    private double precio; 
    private int unidades_V;
    private int unidades;

    @OneToMany(mappedBy = "droga",cascade = CascadeType.ALL,orphanRemoval = true) // relacion uno a muchos
    private List<Tratamientos> tratamientos = new ArrayList<>();
    
    public Droga() { // constructor vacio
        
    }

    public Droga(String nombre, double precio, int unidades) { // constructor con parámetros
        this.nombre = nombre;
        this.precio = precio;
        this.unidades_V = 0;
        this.unidades = unidades;
    }


    public long getCodigo() {
        return codigo;
    }


    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getUnidades_V() {
        return unidades_V;
    }


    public void setUnidades_V(int unidades_V) {
        this.unidades_V = unidades_V;
    }

    public int getUnidades() {
        return unidades;
    }


    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public List<Tratamientos> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(List<Tratamientos> tratamientos) {
        this.tratamientos = tratamientos;
    }
}


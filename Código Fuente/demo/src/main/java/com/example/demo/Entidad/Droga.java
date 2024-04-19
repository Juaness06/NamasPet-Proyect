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

@Entity
@Table(name = "droga") // nombre de la tabla
public class Droga {

    @Id
    @GeneratedValue // autoincrementable
    private long codigo;

    @Column(name = "NAME")
    private String nombre;
    private double precioV;
    private double precioC;
    private int unidades_C;
    private int unidades_V;

    @JsonIgnore
    @OneToMany(mappedBy = "droga",cascade = CascadeType.ALL,orphanRemoval = true) // relacion uno a muchos
    private List<Tratamientos> tratamientos = new ArrayList<>();
    
    public Droga() { // constructor vacio
        
    }
    

    public Droga(long codigo, String nombre, double precioV, double precioC, int unidades_C, int unidades_V) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioV = precioV;
        this.precioC = precioC;
        this.unidades_C = unidades_C;
        this.unidades_V = unidades_V;
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

    public int getUnidades_C() {
        return unidades_C;
    }

    public void setUnidades_C(int unidades_C) {
        this.unidades_C = unidades_C;
    }

    public int getUnidades_V() {
        return unidades_V;
    }

    public void setUnidades_V(int unidades_V) {
        this.unidades_V = unidades_V;
    }

    public List<Tratamientos> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(List<Tratamientos> tratamientos) {
        this.tratamientos = tratamientos;
    }

    
}
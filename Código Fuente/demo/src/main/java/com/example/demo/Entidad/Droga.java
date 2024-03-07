package com.example.demo.Entidad;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class Droga {
     @Id
    @GeneratedValue
    private long codigo;

    @Column(name = "NAME")
    private String nombre;

    
    private double precio; 
    private int unidades_V;
    private int unidades;

    @ManyToOne
    private Tratamientos tratamiento;
    


    public Droga() {
        
    }

    public Droga(String nombre, double precio, int unidades) {
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

    public Tratamientos getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamientos tratamiento) {
        this.tratamiento = tratamiento;
    }

    



}

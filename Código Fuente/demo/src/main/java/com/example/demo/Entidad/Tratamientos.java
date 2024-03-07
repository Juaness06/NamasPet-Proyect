package com.example.demo.Entidad;

import java.sql.Date;
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
@Table(name = "tratamientos")
public class Tratamientos {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "NAME")
    private String nombre;
    private double precio;
    private Date fecha;

   @OneToMany(mappedBy = "tratamiento",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Droga> listaDroga = new ArrayList<>();

    @OneToMany(mappedBy = "tratamiento",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Perro> listaPerros = new ArrayList<>();
    
    @OneToMany(mappedBy = "tratamiento",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Veterinario> listaVeterinarios = new ArrayList<>();




    
    public Tratamientos(String nombre, double precio, Date fecha) {
        this.nombre = nombre;
        this.precio = precio;
        this.fecha = fecha;
    }

    public Tratamientos() {
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Droga> getListaDroga() {
        return listaDroga;
    }

    public void setListaDroga(List<Droga> listaDroga) {
        this.listaDroga = listaDroga;
    }

    public List<Perro> getListaPerros() {
        return listaPerros;
    }

    public void setListaPerros(List<Perro> listaPerros) {
        this.listaPerros = listaPerros;
    }

    public List<Veterinario> getListaVeterinarios() {
        return listaVeterinarios;
    }

    public void setListaVeterinarios(List<Veterinario> listaVeterinarios) {
        this.listaVeterinarios = listaVeterinarios;
    }


    
}

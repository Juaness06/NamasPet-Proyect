package com.example.demo.Entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "veterinario")
public class Veterinario {
    
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "NAME")
    private String nombre;

    
    private String especialidad;

    private int atenciones;
    private String foto;

    @ManyToOne
    private Tratamientos tratamiento;

    public Veterinario() {
        
    }

    

    public Veterinario(String nombre, String especialidad, int atenciones, String foto) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.atenciones = atenciones;
        this.foto = foto;
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getAtenciones() {
        return atenciones;
    }

    public void setAtenciones(int atenciones) {
        this.atenciones = atenciones;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }



    public Tratamientos getTratamiento() {
        return tratamiento;
    }



    public void setTratamiento(Tratamientos tratamiento) {
        this.tratamiento = tratamiento;
    }
    
}

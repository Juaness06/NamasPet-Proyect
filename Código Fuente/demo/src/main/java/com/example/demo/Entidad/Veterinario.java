package com.example.demo.Entidad;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "veterinario")
public class Veterinario {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "NAME")
    private String nombre;

    private String contrasena;
    private String especialidad;
    private int atenciones;
    private String foto;

    private boolean activo;

    @JsonIgnore
    @OneToMany(mappedBy = "veterinario")
    private List<Tratamientos> tratamientos = new ArrayList<>();

    public Veterinario() {

    }

    public Veterinario(String nombre, String contrasena,  String especialidad, int atenciones, String foto, boolean activo) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.especialidad = especialidad;
        this.atenciones = atenciones;
        this.foto = foto;
        this.activo = activo;
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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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

    public List<Tratamientos> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(List<Tratamientos> tratamientos) {
        this.tratamientos = tratamientos;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

}

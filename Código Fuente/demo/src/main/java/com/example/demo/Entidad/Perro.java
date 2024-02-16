package com.example.demo.Entidad;

public class Perro {
    
    private int id;
    private String raza;
    private int edad;
    private boolean actividad;
    private int numeroAtenciones;
    public Perro(int id, String raza, int edad, boolean actividad, int numeroAtenciones) {
        this.id = id;
        this.raza = raza;
        this.edad = edad;
        this.actividad = actividad;
        this.numeroAtenciones = numeroAtenciones;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
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

    
}

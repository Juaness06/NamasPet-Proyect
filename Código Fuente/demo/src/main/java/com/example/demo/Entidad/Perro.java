package com.example.demo.Entidad;

public class Perro {

    private String imagen;
    private int id;
    private String nombre;
    private String raza;
    private int edad;
    private boolean actividad;
    private double peso;
    private int numeroAtenciones;
    private Cliente cliente;

    public Perro(String imagen, String nombre, int id, String raza, int edad, boolean actividad, double peso, int numeroAtenciones, Cliente cliente) {
        this.imagen = imagen;
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.actividad = actividad;
        this.peso = peso;
        this.numeroAtenciones = numeroAtenciones;
        this.cliente = cliente;
    }

    public Perro(String imagen, int id, String nombre, String raza, int edad, boolean actividad, double peso, int numeroAtenciones) {
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

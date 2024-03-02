package com.example.demo.Entidad;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "cliente")
public class Cliente {


    @Id
    @GeneratedValue
    private long cedula;

    @Column(name = "NAME")
    private String nombre;
    private String correo;
    private long celular;
    private String Usuario;
    private String contrasena;

    @OneToMany(mappedBy = "cliente")
    private List<Perro> listaPerros = new ArrayList<>();

    public Cliente(long cedula, String nombre, String correo, long celular, String usuario, String contrasena) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.celular = celular;
        this.Usuario = usuario;
        this.contrasena = contrasena;
    }

    public Cliente( String nombre, String correo, long celular, String usuario, String contrasena) {
        this.nombre = nombre;
        this.correo = correo;
        this.celular = celular;
        this.Usuario = usuario;
        this.contrasena = contrasena;
    }

    public Cliente() {
        //TODO Auto-generated constructor stub
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public List<Perro> getListaPerros() {
        return listaPerros;
    }

    public void setListaPerros(List<Perro> listaPerros) {
        this.listaPerros = listaPerros;
    }



}

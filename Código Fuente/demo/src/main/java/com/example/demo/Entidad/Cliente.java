package com.example.demo.Entidad;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    
    private int cedula;
    private String nombre;
    private String correo;
    private long celular;
    private String Usuario;
    private String contrasena;
    List<String> listaPerros = new ArrayList<>();

    public Cliente(int cedula, String nombre, String correo, long celular, String usuario, String contrasena) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.celular = celular;
        this.Usuario = usuario;
        this.contrasena = contrasena;
    }

    public Cliente() {
        //TODO Auto-generated constructor stub
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
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

    public List<String> getListaPerros() {
        return listaPerros;
    }

    public void setListaPerros(List<String> listaPerros) {
        this.listaPerros = listaPerros;
    }

}

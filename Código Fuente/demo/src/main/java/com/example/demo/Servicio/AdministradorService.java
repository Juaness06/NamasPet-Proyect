package com.example.demo.Servicio;

import java.util.List;

import com.example.demo.Entidad.Administrador;

public interface AdministradorService { // servicio de admnistrador

    // metodos
    public Administrador SearchById(int id);

    public List<Administrador> SearchAll();

    public void Add(Administrador d);

    public void DeleteByID(int id);

    public void Update(Administrador p);

    public Administrador findByNombreAndContrasena(String nombre, String contrasena);

}

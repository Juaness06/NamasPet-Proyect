package com.example.demo.Servicio;

import java.util.Collection;

import com.example.demo.Entidad.Administrador;


public interface AdministradorService {

    public Administrador SearchById(int id);

    public Collection<Administrador> SearchAll();

    public void Add(Administrador d);

     public void DeleteByID(int id);

    public void Update(Administrador p);

    
}

package com.example.demo.Servicio;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.example.demo.Entidad.Cliente;


public interface ClienteService {
    
    public Cliente SearchById(int id);

    public Collection<Cliente> SearchAll();

    public void Add(Cliente p);

    public void DeleteByID(int id);

    public void Update(Cliente p);

    public Cliente Cuenta(String Usuario, String contrasena);
    
}

package com.example.demo.Servicio;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.example.demo.Entidad.Cliente;
import com.example.demo.Entidad.Perro;


public interface ClienteService {
    
    public Cliente SearchById(Long id);

    public Collection<Cliente> SearchAll();

    public void Add(Cliente p);

    public void deleteById(Long id);

    public void Update(Cliente p);

    public Cliente Cuenta(Long cedula);
    
    public Collection<Perro> PerrosClientePerros(long cedula);
    
}

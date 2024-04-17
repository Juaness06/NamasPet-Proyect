package com.example.demo.Servicio;

import java.util.List;

import com.example.demo.Entidad.Cliente;
import com.example.demo.Entidad.Perro;

public interface ClienteService { // servicio de cliente

    // metodos del servicio
    public Cliente SearchById(Long id);

    public List<Cliente> SearchAll();

    public void Add(Cliente p);

    public void deleteById(Long id);

    public void Update(Cliente p);

    public Cliente Cuenta(Long cedula);

    public List<Perro> PerrosClientePerros(long cedula);

}

package com.example.demo.Servicio;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.example.demo.Entidad.Perro;

public interface ServicioPerro {

    public Perro SearchById(int id);

    public Collection<Perro> SearchAll();

    public void Add(Perro p);

    public void DeleteByID(int id);

    public void Update(Perro p);

    public Collection<Perro> PerrosClientePerros(int cedula);
}

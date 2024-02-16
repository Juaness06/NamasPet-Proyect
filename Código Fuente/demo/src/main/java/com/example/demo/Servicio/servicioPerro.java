package com.example.demo.Servicio;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.example.demo.Entidad.Perro;


public interface ServicioPerro {
    
    public Perro SearchById(int id);

    public Collection<Perro> SearchAll();
}

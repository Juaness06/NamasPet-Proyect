package com.example.demo.Servicio;

import java.util.Collection;

import com.example.demo.Entidad.Droga;

public interface ServicioDroga {

    public Droga SearchById(long id);

    public Collection<Droga> SearchAll();

    public void Add(Droga d);
    
}
